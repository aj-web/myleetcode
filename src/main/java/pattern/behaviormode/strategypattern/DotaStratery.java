package pattern.behaviormode.strategypattern;

/**
 * @Author ninan
 * @Description 新增第二个策略
 * @Date 2021/7/25
 **/
public class DotaStratery implements GameStrategy {


    @Override
    public void mobaStrategy() {
        System.out.println("我玩Dota");
    }
}
