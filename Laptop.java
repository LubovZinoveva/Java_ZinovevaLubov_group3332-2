public class Laptop {
    int ram;
    String manufacturer;
    double diagonal;
    String cpu;
    int ssd;
    int cores;
    String operatingSystem;
    String processorManufacturer;
    int price;

    public Laptop(int ram, String manufacturer, double diagonal, String cpu, int ssd, int cores, String operatingSystem,
            String processorManufacturer, int price) {
        this.ram = ram;
        this.manufacturer = manufacturer;
        this.diagonal = diagonal;
        this.cpu = cpu;
        this.ssd = ssd;
        this.cores = cores;
        this.operatingSystem = operatingSystem;
        this.processorManufacturer = processorManufacturer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop [RAM=" + ram + ", manufacturer=" + manufacturer + ", diagonal=" + diagonal + ", CPU=" + cpu
                + ", SSD=" + ssd + ", cores=" + cores + ", operatingSystem=" + operatingSystem
                + ", processorManufacturer=" + processorManufacturer + ", price=" + price
                + "]";
    }  
}
