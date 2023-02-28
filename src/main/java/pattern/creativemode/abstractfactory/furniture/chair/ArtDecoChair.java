package pattern.creativemode.abstractfactory.furniture.chair;

/**
 * @author : chezj
 * @date : 2023/2/28 14:35
 */
public class ArtDecoChair implements Chair {
    
    @Override
    public String hasLegs() {
        return "艺术椅子没有腿";
    }
    
    @Override
    public String sitOn() {
        return "艺术椅子不能坐";
    }
}
