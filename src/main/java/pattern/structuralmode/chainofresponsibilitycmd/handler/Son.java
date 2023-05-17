package pattern.structuralmode.chainofresponsibilitycmd.handler;

import pattern.structuralmode.chainofresponsibilitycmd.IWomen;

/**
 * @author : chezj
 * @date : 2022/8/17 22:20
 */
public class Son extends Handler {
    
    
    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }
    
    @Override
    protected void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}
