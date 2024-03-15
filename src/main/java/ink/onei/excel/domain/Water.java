package ink.onei.excel.domain;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * @Author: nekotako
 * @Description: Water Entity Class
 * @Date: 15/03/2024 22:46 Friday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Water extends BaseWater {
    private Long id;

    // 类型
    private String type;

    // pH
    private BigDecimal pH;

    // SS
    private BigDecimal SS;

    // 氨氮
    private BigDecimal NH3N;

    // 总氮
    private BigDecimal TN;

    // COD
    private BigDecimal COD;

    // BOD
    private BigDecimal BOD;

    // 硫氰酸根
    private BigDecimal SCN;

    // 硫化物
    private BigDecimal S;

    // 挥发酚
    private BigDecimal C6H6O;

    // 碱度
    private BigDecimal ALK;

    // 氯离子
    private BigDecimal Cl;

    // 石油类
    private BigDecimal CxHy;

    // 苯
    private BigDecimal C6H6;

    // 多环芳烃
    private BigDecimal PAH;

    // 苯并芘
    private BigDecimal BaP;

    // 总氰
    private BigDecimal TC;

    private String remark;

    private Long createUser;

    private Date createTime;

    private Integer delFlag;
}
