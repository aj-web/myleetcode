package pattern.creativemode.abstractfactory.factory;

import pattern.creativemode.abstractfactory.furniture.chair.ArtDecoChair;
import pattern.creativemode.abstractfactory.furniture.chair.Chair;
import pattern.creativemode.abstractfactory.furniture.sofa.Sofa;

/**
 * @author : chezj
 * @date : 2023/2/28 14:46
 */
public class ArtDecoFurnitureFactory implements FurnitureFactory {
    
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }
    
    @Override
    public Sofa createSofa() {
        return null;
    }
}
