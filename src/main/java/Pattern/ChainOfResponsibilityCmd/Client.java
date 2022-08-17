package Pattern.ChainOfResponsibilityCmd;

import Pattern.ChainOfResponsibilityCmd.handler.Father;
import Pattern.ChainOfResponsibilityCmd.handler.Husband;
import Pattern.ChainOfResponsibilityCmd.handler.Handler;
import Pattern.ChainOfResponsibilityCmd.handler.Son;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author : chezj
 * @date : 2022/8/17 22:21
 */
public class Client {

    public static void main(String[] args) {
        //随机挑选几个女性
        Random rand = new Random();
        ArrayList<Women> arrayList = new ArrayList<>();

        for(int i=0;i<5;i++){
            arrayList.add(new Women(rand.nextInt(4),"我要出去逛街"));
        }

        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();


        father.setNext(husband);
        husband.setNext(son);


        for(Women women:arrayList) {
            father.HandleMessage(women);
        }

    }



}
