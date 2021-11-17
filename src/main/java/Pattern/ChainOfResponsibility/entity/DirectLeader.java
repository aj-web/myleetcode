package Pattern.ChainOfResponsibility.entity;

import Pattern.ChainOfResponsibility.SpecialRequest;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/11/15
 */
public class DirectLeader implements SpecialRequest {
    @Override
    public void SpecialRequest() {
        System.out.println("我是全平");
    }
}
