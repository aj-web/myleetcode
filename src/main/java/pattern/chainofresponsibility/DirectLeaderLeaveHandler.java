package pattern.chainofresponsibility;

/**
 * @author chezhijun
 * @descririon 1级处理：直接主管处理
 * @date 2021/11/15
 */
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {
    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getDays() <= this.MIN) {
            System.out.println("直接主管:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}
