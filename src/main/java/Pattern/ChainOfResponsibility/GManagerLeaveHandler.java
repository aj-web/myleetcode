package Pattern.ChainOfResponsibility;

/**
 * @author chezhijun
 * @descririon 3级处理：总经理处理
 * @date 2021/11/15
 */
public class GManagerLeaveHandler extends AbstractLeaveHandler {
    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getDays() <= this.MAX) {
            System.out.println("总经理:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}
