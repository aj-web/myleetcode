package pattern.creativemode.builder;

/**
 * @author : chezj
 * @date : 2023/2/28 16:42
 */
public class AsusComputerBuilder implements ComputerBuilder {
    
    @Override
    public void buildMotherboard() {
        computer.setMotherboard("Extreme主板");
    }
    
    @Override
    public void buildCpu() {
    
    }
    
    @Override
    public void buildMemory() {
        computer.setCpu("Inter 12900KS");
    }
    
    @Override
    public void buildDisk() {
    
    }
    
    @Override
    public void buildGpu() {
    
    }
    
    @Override
    public void buildHeatSink() {
    
    }
    
    @Override
    public void buildPower() {
    
    }
    
    @Override
    public void buildChassis() {
    
    }
    
    @Override
    public Computer build() {
        return null;
    }
}
