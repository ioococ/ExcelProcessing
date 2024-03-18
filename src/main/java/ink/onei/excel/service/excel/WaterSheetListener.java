package ink.onei.excel.service.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.google.gson.Gson;
import ink.onei.excel.domain.WaterSheet;
import ink.onei.excel.mapper.DemoMapper;
import ink.onei.excel.service.util.Rabbit;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: WaterSheetListener
 * @Date: 15/03/2024 19:59 Friday
 */

// 有个很重要的点 WaterSheetListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class WaterSheetListener implements ReadListener<WaterSheet> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<WaterSheet> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DemoMapper demoMapper;

    private final Gson gson = new Gson();

    private Rabbit rabbit;

    public WaterSheetListener() {
    }

    public WaterSheetListener(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(WaterSheet data, AnalysisContext context) {
        log.info("解析到一条数据:{}", gson.toJson(data));
        cachedDataList.add(data);
//        verify(cachedDataList);
        rabbit.send(data.hasEmpty());
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    public Boolean tattletale(WaterSheet sheet) {
        rabbit.send(sheet);
        return null;
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//        demoMapper.save(cachedDataList);
        log.info("存储数据库成功！");
    }
}
