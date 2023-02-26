package pattern.creativemode.logistics;

import pattern.creativemode.transport.Ship;
import pattern.creativemode.transport.Transport;

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
