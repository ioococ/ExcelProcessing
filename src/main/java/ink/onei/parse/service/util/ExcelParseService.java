package ink.onei.parse.service.util;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import ink.onei.parse.domain.WaterSheet;
import ink.onei.parse.domain.dto.DataSheet;

import java.io.File;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 22/03/2024 11:59 Friday
 */

public class ExcelParseService {

    public static Boolean parse(File file) throws InterruptedException {
//        new WaterParseThread(file).start();
        DataParseThread thread = new DataParseThread(file);
        thread.start();
        thread.join();
//        new ArgumentParseThread(file).start();
//        new ProductionParseThread(file).start();
//        String title = ExcelUtils.getTitle(file, "原料水监测表").split("-")[1].substring(0, 2);
        return true;
    }
    static class WaterParseThread extends Thread {

        private File file;

        public WaterParseThread() {
        }

        public WaterParseThread(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                    .sheetName("原料水监测表").headerStart(2).limit(40)
                    .build();

            Poiji.fromExcel(file, WaterSheet.class, options, System.out::println);
        }
    }

    static class DataParseThread extends Thread {

        private File file;

        public DataParseThread() {
        }

        public DataParseThread(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                    .sheetName("过程数据监测表").headerStart(2).limit(40)
                    .build();

            Poiji.fromExcel(file, DataSheet.class, options, System.out::println);
        }
    }

    static class ArgumentParseThread extends Thread {

        private File file;

        public ArgumentParseThread() {
        }

        public ArgumentParseThread(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                    .sheetName("工艺参数监测表").headerStart(2).limit(40)
                    .build();

            Poiji.fromExcel(file, WaterSheet.class, options, System.out::println);
        }
    }

    static class ProductionParseThread extends Thread {

        private File file;

        public ProductionParseThread() {
        }

        public ProductionParseThread(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                    .sheetName("生产数据").headerStart(2).limit(40)
                    .build();

            Poiji.fromExcel(file, WaterSheet.class, options, System.out::println);
        }
    }
}
