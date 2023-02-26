package pattern.structuralmode.chainofresponsibilitycmd.handler;

import pattern.structuralmode.chainofresponsibilitycmd.IWomen;

/**
 * @author : chezj
 * @date : 2022/8/17 22:17
 */
public class Father extends Handler {


    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }
}
