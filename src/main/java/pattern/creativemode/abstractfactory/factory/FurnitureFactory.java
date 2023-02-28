package pattern.creativemode.abstractfactory.factory;

import pattern.creativemode.abstractfactory.furniture.chair.Chair;
import pattern.creativemode.abstractfactory.furniture.sofa.Sofa;

/**
 * @author : chezj
 * @date : 2023/2/28 14:42
 */
public interface FurnitureFactory {
    
    Chair createChair();
    
    Sofa createSofa();
    
}
