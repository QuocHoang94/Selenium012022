package test_data;

public class ComputerDataObject {
    private String processorType;
    private String ram;

    public ComputerDataObject(String processorType, String ram) {
        this.processorType = processorType;
        this.ram = ram;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
