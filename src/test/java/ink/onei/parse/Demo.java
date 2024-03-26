package ink.onei.parse;


import ink.onei.parse.service.util.ExcelParseService;
import ink.onei.parse.service.util.ExcelUtils;
import org.junit.Test;

import java.io.File;

/**
 * @Author: nekotako
 * @Description: Poiji Demo
 * @Date: 20/03/2024 14:36 Wednesday
 */
public class Demo {

    @Test
    public void readExcelData() throws InterruptedException {

        ExcelParseService.parse(new File("C:\\Users\\荣耀\\Desktop\\2021-01.xlsx"));
    }
}
