package Pattern.ChainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chezhijun
 * @descririon 员工请假请求
 * @date 2021/11/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {

    private int days;

    private String name;
}
