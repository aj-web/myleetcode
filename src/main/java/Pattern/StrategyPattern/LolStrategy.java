package Pattern.StrategyPattern;

/**
 * @Author ninan
 * @Description 第一个
 * @Date 2021/7/25
 **/
public class LolStrategy implements GameStrategy {

    @Override
    public void mobaStrategy() {
        System.out.println("我玩LOL");
    }
}
