package pattern.creativemode.builder;

/**
 * @author : chezj
 * @date : 2023/2/28 16:41
 */
public interface ComputerBuilder {
    
    Computer computer = new Computer();
    
    void buildMotherboard();
    
    void buildCpu();
    
    void buildMemory();
    
    void buildDisk();
    
    void buildGpu();
    
    void buildHeatSink();
    
    void buildPower();
    
    void buildChassis();
    
    Computer build();
    
}
