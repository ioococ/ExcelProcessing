package ink.onei.excel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author: nekotako
 * @Description: RabbitMSG Entity Class
 * @Date: 15/03/2024 19:56 Friday
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMSG {
    private Integer year;
    private Integer month;
    // <day, msg>
    private Map<Integer, String> msg;
}
