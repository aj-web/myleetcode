package pattern.creativemode.factorymethod.logistics;

import pattern.creativemode.factorymethod.transport.Transport;
import pattern.creativemode.factorymethod.transport.Truck;

/**
 * @author : chezj
 * @date : 2023/2/26 16:50
 */
public class RoadLogistics extends Logistics {
    
    @Override
    Transport creatTransport() {
        return new Truck();
    }
}
