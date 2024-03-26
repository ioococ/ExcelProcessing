package ink.onei.parse.domain.dto;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellsJoinedByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 25/03/2024 16:16 Monday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSheet {

    private Long id;

    private String location;

    // 类型
    private Integer waterType;

    @ExcelCell(0)
    private String date;

    @ExcelCell(1)
    private String time;

    // 调节池
    @ExcelCellsJoinedByName(expression = "调节池")
    private MultiValuedMap<String, Integer> retention = new ArrayListValuedHashMap<>();

    // 预曝器
    @ExcelCellsJoinedByName(expression = "预曝器")
    private MultiValuedMap<String, Integer> aerator = new ArrayListValuedHashMap<>();

    // 初沉池
    @ExcelCellsJoinedByName(expression = "初沉池")
    private MultiValuedMap<String, Integer> primary = new ArrayListValuedHashMap<>();

}
