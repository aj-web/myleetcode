package pattern.creativemode.factorymethod.transport;

/**
 * @author : chezj
 * @date : 2023/2/26 16:51
 */
public class Ship implements Transport {
    
    @Override
    public String deliver() {
        return "Ship deliver!!! ";
    }
}
