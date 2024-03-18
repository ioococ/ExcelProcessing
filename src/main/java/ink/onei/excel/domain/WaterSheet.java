package ink.onei.excel.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.google.gson.Gson;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: nekotako
 * @Description: Water Entity Class
 * @Date: 15/03/2024 22:46 Friday
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class WaterSheet extends BaseWater {

    @ExcelIgnore
    private Long id;

    // 类型
    @ExcelIgnore
    private Integer type;

    @ExcelProperty("日期")
    private Date date;

    // pH
    @ExcelProperty(value = "pH")
    private BigDecimal pH;

    // SS
    @ExcelProperty(value = "SS")
    private BigDecimal SS;

    // 氨氮
    @ExcelProperty(value = "氨氮")
    private BigDecimal NH3N;

    // 总氮
    @ExcelProperty(value = "总氮")
    private BigDecimal TN;

    // COD
    @ExcelProperty(value = "COD")
    private BigDecimal COD;

    // BOD
    @ExcelProperty(value = "BOD")
    private BigDecimal BOD;

    // 硫氰酸根
    @ExcelProperty(value = "硫氰酸根")
    private BigDecimal SCN;

    // 硫化物
    @ExcelProperty(value = "硫化物")
    private BigDecimal Sx;

    // 挥发酚
    @ExcelProperty(value = "挥发酚")
    private BigDecimal C6H6O;

    // 碱度
    @ExcelProperty(value = "碱度")
    private BigDecimal ALK;

    // 氯离子
    @ExcelProperty(value = "氯离子")
    private BigDecimal Cl;

    // 石油类
    @ExcelProperty(value = "石油类")
    private BigDecimal CxHy;

    // 苯
    @ExcelProperty(value = "苯")
    private BigDecimal C6H6;

    // 多环芳烃
    @ExcelProperty(value = "多环芳烃")
    private BigDecimal PAH;

    // 苯并芘
    @ExcelProperty(value = "苯并芘")
    private BigDecimal BaP;

    // 总氰
    @ExcelProperty(value = "总氰")
    private BigDecimal TC;

    @ExcelIgnore
    private String remark;

    @ExcelIgnore
    private Long createUser;

    @ExcelIgnore
    private Date createTime;

    @ExcelIgnore
    private Integer delFlag;

    public String hasEmpty() {
        return new Gson().toJson(this).contains("null") ? "0":"1";
    }
}
