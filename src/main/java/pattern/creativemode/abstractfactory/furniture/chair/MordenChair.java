package pattern.creativemode.abstractfactory.furniture.chair;

/**
 * @author : chezj
 * @date : 2023/2/28 14:36
 */
public class MordenChair implements Chair {
    
    @Override
    public String hasLegs() {
        return "现代椅子4条腿";
    }
    
    @Override
    public String sitOn() {
        return "现代椅子可以做";
    }
}
