package ink.onei.excel.mapper;

import ink.onei.excel.domain.Demo;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 15/03/2024 20:00 Friday
 */

public class DemoMapper {
    public void save(List<Demo> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
