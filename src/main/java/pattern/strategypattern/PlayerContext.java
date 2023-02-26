package pattern.strategypattern;

/**
 * @Author ninan
 * @Description 环境类(Context):用来操作策略的上下文环境
 * @Date 2021/7/25
 **/
public class PlayerContext {


    GameStrategy gameStrategy;


    public void setGameStrategy(GameStrategy Strategy) {
        this.gameStrategy = Strategy;
    }


    public static void main(String[] args) {
        PlayerContext playerContext = new PlayerContext();
        playerContext.setGameStrategy(new DotaStratery());
        playerContext.gameStrategy.mobaStrategy();

        playerContext.setGameStrategy(new LolStrategy());
        playerContext.gameStrategy.mobaStrategy();
    }
}
