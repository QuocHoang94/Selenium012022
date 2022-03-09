package test_data;

public class ComputerDataObject {
    private String processorType;
    private String ram;
    private String os;
    private String hdd;


    public ComputerDataObject(String processorType, String ram,String os) {
        this.processorType = processorType;
        this.ram = ram;
        this.os = os;
        this.hdd = hdd;
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

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
}
