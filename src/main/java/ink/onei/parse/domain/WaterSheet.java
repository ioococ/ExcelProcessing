package ink.onei.parse.domain;


import com.google.gson.Gson;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellsJoinedByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: nekotako
 * @Description: Water Entity Class
 * @Date: 15/03/2024 22:46 Friday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterSheet {

//    @ExcelIgnore
    private Long id;

    // 类型
//    @ExcelIgnore
    private Integer type;

    @ExcelCell(0)
    private String date;

    @ExcelCell(1)
    private String time;

    // pH
    @ExcelCellsJoinedByName(expression = "pH")
    private MultiValuedMap<String, BigDecimal> pH = new ArrayListValuedHashMap<>();

    // SS
    @ExcelCellsJoinedByName(expression = "SS")
    private MultiValuedMap<String, BigDecimal> SS = new ArrayListValuedHashMap<>();

    // 氨氮
    @ExcelCellsJoinedByName(expression = "氨氮")
    private MultiValuedMap<String, BigDecimal> NH3N = new ArrayListValuedHashMap<>();

    // 总氮
    @ExcelCellsJoinedByName(expression = "总氮")
    private MultiValuedMap<String, BigDecimal> TN = new ArrayListValuedHashMap<>();

    // COD
    @ExcelCellsJoinedByName(expression = "COD")
    private MultiValuedMap<String, BigDecimal> COD = new ArrayListValuedHashMap<>();

    // BOD
    @ExcelCellsJoinedByName(expression = "BOD")
    private MultiValuedMap<String, BigDecimal> BOD = new ArrayListValuedHashMap<>();

    // 硫氰酸根
    @ExcelCellsJoinedByName(expression = "硫氰酸根")
    private MultiValuedMap<String, BigDecimal> SCN = new ArrayListValuedHashMap<>();

    // 硫化物
    @ExcelCellsJoinedByName(expression = "硫化物")
    private MultiValuedMap<String, BigDecimal> Sx = new ArrayListValuedHashMap<>();

    // 挥发酚
    @ExcelCellsJoinedByName(expression = "挥发酚")
    private MultiValuedMap<String, BigDecimal> C6H6O = new ArrayListValuedHashMap<>();

    // 碱度
    @ExcelCellsJoinedByName(expression = "碱度")
    private MultiValuedMap<String, BigDecimal> ALK = new ArrayListValuedHashMap<>();

    // 氯离子
    @ExcelCellsJoinedByName(expression = "氯离子")
    private MultiValuedMap<String, BigDecimal> Cl = new ArrayListValuedHashMap<>();

    // 石油类
    @ExcelCellsJoinedByName(expression = "石油类")
    private MultiValuedMap<String, BigDecimal> CxHy = new ArrayListValuedHashMap<>();

    // 苯
    @ExcelCellsJoinedByName(expression = "苯")
    private MultiValuedMap<String, BigDecimal> C6H6 = new ArrayListValuedHashMap<>();

    // 多环芳烃
    @ExcelCellsJoinedByName(expression = "多环芳烃")
    private MultiValuedMap<String, BigDecimal> PAH = new ArrayListValuedHashMap<>();

    // 苯并芘
    @ExcelCellsJoinedByName(expression = "苯并芘")
    private MultiValuedMap<String, BigDecimal> BaP = new ArrayListValuedHashMap<>();

    // 总氰
    @ExcelCellsJoinedByName(expression = "总氰")
    private MultiValuedMap<String, BigDecimal> TC = new ArrayListValuedHashMap<>();

//    @ExcelIgnore
    private String remark;

//    @ExcelIgnore
    private Long createUser;

//    @ExcelIgnore
    private Date createTime;

//    @ExcelIgnore
    private Integer delFlag;

    public Boolean hasEmpty() {
        return null;
    }
}
