package pattern.creativemode.abstractfactory.factory;

import pattern.creativemode.abstractfactory.furniture.chair.Chair;
import pattern.creativemode.abstractfactory.furniture.sofa.Sofa;
import pattern.creativemode.abstractfactory.furniture.sofa.VictorianSofa;

/**
 * @author : chezj
 * @date : 2023/2/28 14:45
 */
public class VictorianFurnitureFactory implements FurnitureFactory {
    
    @Override
    public Chair createChair() {
        return null;
    }
    
    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
