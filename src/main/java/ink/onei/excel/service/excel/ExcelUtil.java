package ink.onei.excel.service.excel;

import ink.onei.excel.service.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: Excel Verification Tools
 * @Date: 16/03/2024 15:04 Saturday
 */

public class ExcelUtil {

    @Autowired
    private RedisCache redisCache;

    public void dateVerify(Calendar calendar, List<?> list) {
        redisCache.getCacheObject()
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
