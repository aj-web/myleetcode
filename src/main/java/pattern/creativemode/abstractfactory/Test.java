package pattern.creativemode.abstractfactory;

import pattern.creativemode.abstractfactory.factory.FurnitureFactory;
import pattern.creativemode.abstractfactory.factory.ModernFurnitureFactory;

/**
 * @author : chezj
 * @date : 2023/2/28 14:48
 */
public class Test {
    
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        System.out.println(factory.createChair().hasLegs());
    }
    
}
