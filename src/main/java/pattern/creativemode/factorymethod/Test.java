package pattern.creativemode.factorymethod;

import pattern.creativemode.factorymethod.logistics.Logistics;
import pattern.creativemode.factorymethod.logistics.RoadLogistics;

/**
 * @author : chezj
 * @date : 2023/2/26 17:01
 */
public class Test {
    
    public static void main(String[] args) {
        Logistics logistics = new RoadLogistics();
        System.out.println(logistics.planDeliver());
    }
}
