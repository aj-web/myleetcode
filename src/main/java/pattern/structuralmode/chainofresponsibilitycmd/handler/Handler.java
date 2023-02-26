package pattern.structuralmode.chainofresponsibilitycmd.handler;

import pattern.structuralmode.chainofresponsibilitycmd.IWomen;
import pattern.structuralmode.chainofresponsibilitycmd.Women;

/**
 * @author : chezj
 * @date : 2022/8/17 22:14
 */
public abstract class Handler {

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    //能处理的级别
    private int level = 0;
    //责任传递，下一个人责任人是谁
    private Handler nextHandler;

    //每个类都要说明一下自己能处理哪些请求
    public Handler(int _level) {
        this.level = _level;
    }


    public final void HandleMessage(Women women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {  //有后续环节，才把请求往后递送
                this.nextHandler.HandleMessage(women);
            } else { //已经没有后续处理人了，不用处理了
                System.out.println("---没地方请示了，按不同意处理---\n");
            }
        }
    }


    /*
     * 如果不属于你处理的请求，你应该让她找下一个环节的人，如女儿出嫁了，
     * 还向父亲请示是否可以逛街，那父亲就应该告诉女儿，应该找丈夫请示
     */
    public void setNext(Handler _handler) {
        this.nextHandler = _handler;
    }


    //有请示那当然要回应
    protected abstract void response(IWomen women);

}
