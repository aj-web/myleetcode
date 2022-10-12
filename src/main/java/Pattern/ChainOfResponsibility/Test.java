package Pattern.ChainOfResponsibility;

import Pattern.ChainOfResponsibility.entity.GManager;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/11/15
 */
public class Test {

    SpecialRequest specialRequest;

    public static void main(String[] args) {


        LeaveRequest cc = LeaveRequest.builder().days(19).name("cc").build();

        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("全平");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("春哥");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("BOSS");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);


        directLeaderLeaveHandler.handlerRequest(cc);


        Test test = new Test();
        test.setSpecialRequest(new GManager());
        test.specialRequest.SpecialRequest();
    }

    public void setSpecialRequest(SpecialRequest specialRequest) {
        this.specialRequest = specialRequest;
    }

}
