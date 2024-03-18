package ink.onei.excel.service.excel;

import ink.onei.excel.domain.WaterSheet;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: Excel Verification Tools
 * @Date: 16/03/2024 15:04 Saturday
 */

public class ExcelUtil {

    public static void dateVerify(Calendar calendar, List<WaterSheet> list) {
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        WaterSheet[] dataList = new WaterSheet[day];

        list.forEach(sheet -> {
            int index = (sheet.getDate().getDate()) - 1;
            dataList[index] = sheet;
        });

        
//        for (Object o : list) {
//            if (o instanceof WaterSheet sheet) {
//                int index = (sheet.getDate().getDate()) - 1;
//            }
//        }
    }
}
