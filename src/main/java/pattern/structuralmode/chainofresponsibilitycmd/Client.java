package pattern.structuralmode.chainofresponsibilitycmd;

import pattern.structuralmode.chainofresponsibilitycmd.handler.Father;
import pattern.structuralmode.chainofresponsibilitycmd.handler.Handler;
import pattern.structuralmode.chainofresponsibilitycmd.handler.Husband;
import pattern.structuralmode.chainofresponsibilitycmd.handler.Son;

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

        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4), "我要出去逛街"));
        }

        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();


        father.setNext(husband);
        husband.setNext(son);


        for (Women women : arrayList) {
            father.HandleMessage(women);
        }

    }


}
