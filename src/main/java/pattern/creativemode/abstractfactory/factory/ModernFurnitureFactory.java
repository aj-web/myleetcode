package pattern.creativemode.abstractfactory.factory;

import pattern.creativemode.abstractfactory.furniture.chair.Chair;
import pattern.creativemode.abstractfactory.furniture.chair.MordenChair;
import pattern.creativemode.abstractfactory.furniture.sofa.MordenSofa;
import pattern.creativemode.abstractfactory.furniture.sofa.Sofa;

/**
 * @author : chezj
 * @date : 2023/2/28 14:44
 */
public class ModernFurnitureFactory implements FurnitureFactory {
    
    @Override
    public Chair createChair() {
        return new MordenChair();
    }
    
    @Override
    public Sofa createSofa() {
        return new MordenSofa();
    }
}
