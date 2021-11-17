package Pattern.ChainOfResponsibility;

/**
 * @author chezhijun
 * @descririon 2级处理：部门主管处理
 * @date 2021/11/15
 */
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {
    public DeptManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getDays()<= this.MIDDLE){
            System.out.println("部门主管:" + handlerName + ",已经处理;流程结束。");
            return;
        }

        if (null != this.nextHandler){
            this.nextHandler.handlerRequest(request);
        }else {
            System.out.println("审批拒绝！");
        }
    }
}
