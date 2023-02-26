package pattern.creativemode.logistics;

import pattern.creativemode.transport.Transport;
import pattern.creativemode.transport.Truck;

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
