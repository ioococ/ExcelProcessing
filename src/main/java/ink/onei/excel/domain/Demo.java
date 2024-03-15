package ink.onei.excel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: nekotako
 * @Description: Demo Entity Class
 * @Date: 15/03/2024 19:56 Friday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
    private String string;
    private Date date;
    private Double doubleData;
}
