package ink.onei.parse;


import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import ink.onei.parse.domain.WaterSheet;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: Poiji Demo
 * @Date: 20/03/2024 14:36 Wednesday
 */
public class Demo {

    @Test
    public void shouldReadAlbumData() {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .sheetName("原料水监测表").headerStart(2).datePattern("yyyy-MM-dd")
                .build();

        List<WaterSheet> actualData = Poiji.fromExcel(new File("C:\\Users\\荣耀\\Desktop\\2021-01.xlsx"), WaterSheet.class, options);

        actualData.forEach(System.out::println);
    }
}
