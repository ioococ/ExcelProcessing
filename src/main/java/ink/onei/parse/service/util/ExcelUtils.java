package ink.onei.parse.service.util;

import ink.onei.parse.domain.RabbitMSG;
import ink.onei.parse.domain.WaterSheet;

import java.util.*;

/**
 * @Author: nekotako
 * @Description: Excel Verification Tools
 * @Date: 16/03/2024 15:04 Saturday
 */

public class ExcelUtils {

    public static RabbitMSG dateVerify(Calendar calendar, List<WaterSheet> list) {
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        WaterSheet[] dataList = new WaterSheet[day];
        Map<Integer, String> msgMap = new HashMap<>();

        list.forEach(sheet -> {
            int index = CalendarUtils.toCalendar(sheet.getDate()).get(Calendar.MONTH);
            dataList[index] = sheet;
        });

        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i] == null) {
                msgMap.put(i + 1, "Data not recorded");
            }
        }
        return new RabbitMSG(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), msgMap);
    }
}
