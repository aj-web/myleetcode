package pattern.creativemode.logistics;

import pattern.creativemode.transport.Transport;

/**
 * 运输方法
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
