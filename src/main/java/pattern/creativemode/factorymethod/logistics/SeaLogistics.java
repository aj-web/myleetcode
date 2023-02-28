package pattern.creativemode.factorymethod.logistics;

import pattern.creativemode.factorymethod.transport.Ship;
import pattern.creativemode.factorymethod.transport.Transport;

/**
 * @author : chezj
 * @date : 2023/2/26 16:51
 */
public class SeaLogistics extends Logistics {
    
    @Override
    Transport creatTransport() {
        return new Ship();
    }
}
