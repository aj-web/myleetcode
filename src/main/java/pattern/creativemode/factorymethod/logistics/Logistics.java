package pattern.creativemode.factorymethod.logistics;

import pattern.creativemode.factorymethod.transport.Transport;

/**
 * 运输方法, 工厂模式中的工厂
 *
 * @author : chezj
 * @date : 2023/2/26 16:50
 */
public abstract class Logistics {
    
    public String planDeliver() {
        Transport transport = creatTransport();
        return transport.deliver();
    }
    
    
    abstract Transport creatTransport();
}
