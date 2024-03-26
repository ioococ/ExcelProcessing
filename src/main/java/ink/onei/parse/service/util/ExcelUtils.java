package ink.onei.parse.service.util;

import ink.onei.parse.domain.RabbitMSG;
import ink.onei.parse.domain.WaterSheet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @Author: nekotako
 * @Description: Excel Verification Tools
 * @Date: 16/03/2024 15:04 Saturday
 */

@Slf4j
public class ExcelUtils {

    public static RabbitMSG dateVerify(String name, List<WaterSheet> list) {

        GregorianCalendar calendar = new GregorianCalendar();

        // file name date parse
        String[] dateS = FilenameUtils.getBaseName(name).split("-");
        calendar.set(Integer.parseInt(dateS[0]), Integer.parseInt(dateS[1]) - 1, 1);

        // get number of days in the current month
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        WaterSheet[] dataList = new WaterSheet[day];
        Map<Integer, String> msgMap = new HashMap<>();

        list.forEach(sheet -> {
            Calendar cale = CalendarUtils.toCalendar(sheet.getDate());
            int index = cale.get(Calendar.DATE) - 1;
            dataList[index] = sheet;
        });

        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i] == null) {
                msgMap.put(i + 1, "Data not recorded");
            }
        }
        return new RabbitMSG(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), msgMap);
    }

    public static String getTitle(File excelFile, String sheetName) {
        Row titleRow = null;
        try (FileInputStream fis = new FileInputStream(excelFile)) {

            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // 读取标题行，假设标题行是第一行
            titleRow = sheet.getRow(0);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return titleRow.getCell(0).toString();
    }
}
