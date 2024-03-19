package ink.onei.excel.service.excel;

import ink.onei.excel.domain.RabbitMSG;
import ink.onei.excel.domain.WaterSheet;

import java.util.*;

/**
 * @Author: nekotako
 * @Description: Excel Verification Tools
 * @Date: 16/03/2024 15:04 Saturday
 */

public class ExcelUtil {

    public static RabbitMSG dateVerify(GregorianCalendar calendar, List<WaterSheet> list) {
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        WaterSheet[] dataList = new WaterSheet[day];
        Map<Integer, String> msgMap = new HashMap<>();

        list.forEach(sheet -> {
            int index = (sheet.getDate().getDate()) - 1;
            dataList[index] = sheet;
        });

        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i] == null) {
                msgMap.put(i + 1, "未记录数据");
            }
        }
        return new RabbitMSG(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), msgMap);
    }
}
