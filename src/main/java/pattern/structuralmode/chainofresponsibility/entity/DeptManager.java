package pattern.structuralmode.chainofresponsibility.entity;

import pattern.structuralmode.chainofresponsibility.SpecialRequest;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/11/15
 */
public class DeptManager implements SpecialRequest {
    @Override
    public void SpecialRequest() {
        System.out.println("我是春哥");

    }
}
