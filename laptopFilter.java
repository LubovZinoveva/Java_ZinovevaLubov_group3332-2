import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class laptopFilter {
    public static void main(String[] args) {
        // Создадим 12 экземпляров класа Laptop
        Laptop lp1 = new Laptop(16, "HUAWEI", 15.6, "AMD Ryzen 5", 512, 6, "Windows 11", "AMD", 62999);
        Laptop lp2 = new Laptop(8, "Apple", 13.3, "Apple M2", 512, 8, "macOS", "Apple", 132299);
        Laptop lp3 = new Laptop(16, "Apple", 14.2, "Apple M1", 512, 8, "macOS", "Apple", 169999);
        Laptop lp4 = new Laptop(8, "Lenovo", 15.6, "AMD Ryzen5", 512, 6, "Windows 10", "AMD", 74399);
        Laptop lp5 = new Laptop(4, "HP", 15.6, "Intel Celeron", 128, 2, "Windows 10", "Intel", 26999);
        Laptop lp6 = new Laptop(8, "Lenovo", 15.6, "Intel Core i3", 256, 2, "Windows 11", "Intel", 41999);
        Laptop lp7 = new Laptop(16, "HUAWEI", 16.0, "Intel core i7", 512, 14, "Windows 11", "Intel", 86999);
        Laptop lp8 = new Laptop(16, "HUAWEI", 16.0, "Intel core i7", 1000, 14, "Windows 11", "Intel", 105999);
        Laptop lp9 = new Laptop(8, "Apple", 13.3, "Apple M2", 256, 8, "macOS", "Apple", 106199);
        Laptop lp10 = new Laptop(8, "HP", 15.6, "Intel core i5", 256, 6, "Windows 10", "Intel", 47999);
        Laptop lp11 = new Laptop(8, "Honor", 15.6, "Intel core i5", 512, 4, "Windows 10", "Intel", 62999);
        Laptop lp12 = new Laptop(32, "Lenovo", 16.0, "AMD Ryzen 9", 2000, 8, "Windows 10", "AMD", 234999);
       
        //Создадим множество ноутбуков
        Set<Laptop> lp = new HashSet<>();
        lp.add(lp1); lp.add(lp2); lp.add(lp3); lp.add(lp4); lp.add(lp5); lp.add(lp6);
        lp.add(lp7); lp.add(lp8); lp.add(lp9); lp.add(lp10); lp.add(lp11); lp.add(lp12);

        Set<Laptop> afterFilter = noteFilter(lp);
        System.out.println();
        System.out.println("Подходящие ноутбуки: ");
        if(afterFilter.isEmpty()) System.out.println("Нет ноутбуков, подходящих выбранным параметрам :(");
        int count = 1; 
        for(Laptop item : afterFilter){
            System.out.println(count + ") " + item);
            count++;
        }
    }

    public static Set<Laptop> noteFilter(Set<Laptop> lptp) {
        //получаем список фильтров из метода getCriteria
        List<Map<String, String>> criteria = new ArrayList<>();
        getCriteria(criteria);

        int answer = 1;
        Scanner iScanner = new Scanner(System.in);
        while(answer == 1){
            System.out.println("Если хотите задать еще фильтр, напишите '1', если нет, напишите '2': ");
            String answ = iScanner.nextLine();
            answer = Integer.parseInt(answ);
            if(answer == 1){
                getCriteria(criteria);
            }
        }
        iScanner.close();
        
        // Создадим Set ноутбуков. Скопируем в него все имеющиеся экземпляры ноутбуков
        // В Set 'delete' добавим экземпляр ноутбука, если ноутбук не соответствует какому-нибудь из выбранных параметров 
        // Вычтем из 'result' Set все ноутбуки из 'delete' 
        Set<Laptop> result = new HashSet<>();
        result.addAll(lptp);
        Set<Laptop> delete = new HashSet<>();
        for (Laptop laptop : result) {
            for(Map<String, String> item : criteria){
                boolean leave = false;
                if(item.containsValue("manufacturer")){
                    for(String key : item.keySet()){
                        if(key.equals(laptop.manufacturer)){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("CPU")){
                    for(String key : item.keySet()){
                        if(key.equals(laptop.cpu)){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("processorManufacturer")){
                    for(String key : item.keySet()){
                        if(key.equals(laptop.processorManufacturer)){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("OS")){
                    for(String key : item.keySet()){
                        if(key.equals(laptop.operatingSystem)){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("core")){
                    for(String key : item.keySet()){
                        if((Integer.parseInt(key)) == laptop.cores){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("RAM")){
                    for(String key : item.keySet()){
                        if((Integer.parseInt(key)) == laptop.ram){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("SSD")){
                    for(String key : item.keySet()){
                        if((Integer.parseInt(key)) == laptop.ssd){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("diagonal")){
                    for(String key : item.keySet()){
                        if(Double.parseDouble(key) == laptop.diagonal){
                            leave = true;
                        }
                    }
                } else if(item.containsValue("minPrice")){
                    int min = -1; int max = -1;
                    for(var pair : item.entrySet()){
                        if(pair.getValue().equals("minPrice")) min = Integer.parseInt(pair.getKey());
                        else if(pair.getValue().equals("maxPrice")) max = Integer.parseInt(pair.getKey());
                    }
                    if(laptop.price >= min && laptop.price <= max) leave = true;
                }

                if(!leave) delete.add(laptop);
            } 
        }
        result.removeAll(delete);           
        return result;
    }

    private static List<Map<String, String>>  getCriteria(List<Map<String, String>> filter) {
        Scanner iScanner = new Scanner(System.in);
        
        System.out.printf("1) Производитель%n" +
                          "2) Линейка процессора%n" +
                          "3) Производитель процессора%n" +
                          "4) Операционная система%n" +
                          "5) Количество ядер%n" +
                          "6) Объем оперативной памяти(ГБ)%n" +
                          "7) Общий объем твердотельных накопителей(SSD)(ГБ)%n" +
                          "8) Диагональ экрана(дюйм)%n" +
                          "9) Цена%n");
        
        System.out.print("Напишите цифру критерия, который хотите задать: ");
        int num = Integer.parseInt(iScanner.nextLine());
        Map<String, String> filterMap = new HashMap<>();

        switch(num) {
            case 1:
                System.out.printf("1) HUAWEI%n" +
                                  "2) Apple%n" +
                                  "3) Honor%n" +
                                  "4) HP%n" +
                                  "5) Lenovo%n");
                System.out.println("Напишите выбранных производителей в одну строку через пробел/n" +
                                   "Например: HP Apple Lenovo");
                String[] manufacturerFilter = iScanner.nextLine().split(" ");
               
                for(String item : manufacturerFilter) filterMap.put(item, "manufacturer");
                filter.add(filterMap);
                break;

            case 2:
                String[] processors = {"AMD Ryzen 5", "AMD Ryzen 9", "Apple M1", "Apple M2", "Intel Celeron", "Intel core i3", "Intel core i5", "Intel core i7"};
                System.out.printf("1) AMD Ryzen 5%n" +
                                  "2) AMD Ryzen 9%n" +
                                  "3) Apple M1%n" +
                                  "4) Apple M2%n" +
                                  "5) Intel Celeron%n" +
                                  "6) Intel core i3%n" + 
                                  "7) Intel core i5%n" +
                                  "8) Intel core i7%n");
                System.out.println("Напишите номера выбранных процессоров в одну строку через пробел/n" +
                                   "Например: 3 7");
                String[] cpuFilter = iScanner.nextLine().split(" ");
                for(String item : cpuFilter) filterMap.put(processors[Integer.parseInt(item) - 1], "CPU");
                filter.add(filterMap);
                break;

            case 3:
                System.out.printf("1) AMD%n" +
                                  "2) Apple%n" +
                                  "3) Intel%n");
                System.out.println("Напишите выбранных производителей в одну строку через пробел/n" +
                                   "Например: Apple AMD");
                String[] cpuManufacturerFilter = iScanner.nextLine().split(" ");
                for(String item : cpuManufacturerFilter) filterMap.put(item, "processorManufacturer");
                filter.add(filterMap);
                break;
            
            case 4:
                String[] OS = {"Windows 10", "Windows 11", "macOS"};
                System.out.printf("1) Windows 10%n" +
                                  "2) Windows 11%n" +
                                  "3) macOS%n");
                System.out.println("Напишите номера выбранных операционных систем в одну строку через пробел/n" +
                                   "Например: 1 3");
                String[] OSFilter = iScanner.nextLine().split(" ");
                for(String item : OSFilter) filterMap.put(OS[Integer.parseInt(item) - 1], "OS");
                filter.add(filterMap);
                break;
              
            case 5:
                System.out.printf("- 2%n" +
                                  "- 4%n" +
                                  "- 6%n" +
                                  "- 8%n" +
                                  "- 14%n");
                System.out.println("Напишите количество выбранных ядер в одну строку через пробел/n" +
                                   "Например: 4 14");
                String[] coreFilter = iScanner.nextLine().split(" ");
                for(String item : coreFilter) filterMap.put(item, "core");
                filter.add(filterMap);
                break; 
               
            case 6:
                System.out.printf("- 4%n" +
                                  "- 8%n" +
                                  "- 16%n" +
                                  "- 32%n");
                System.out.println("Напишите выбранный объем в одну строку через пробел/n" +
                                   "Например: 16 32");
                String[] RAMFilter = iScanner.nextLine().split(" ");
                for(String item : RAMFilter) filterMap.put(item, "RAM");
                filter.add(filterMap);
                break;
            
            case 7:
                System.out.printf("- 128%n" +
                                  "- 256%n" +
                                  "- 512%n" +
                                  "- 1000%n" + 
                                  "- 2000%n");
                System.out.println("Напишите выбранный объем в одну строку через пробел/n" +
                                   "Например: 256 512");
                String[] SSDFilter = iScanner.nextLine().split(" ");
                for(String item : SSDFilter) filterMap.put(item, "SSD");
                filter.add(filterMap);
                break;
            
            case 8:
                System.out.printf("- 13.3%n" +
                                  "- 14.2%n" +
                                  "- 15.6%n" +
                                  "- 16.0%n");
                System.out.println("Напишите выбранный объем в одну строку через пробел/n" +
                                   "Например: 13.3 15.6");
                String[] diagonalFilter = iScanner.nextLine().split(" ");
                for(String item : diagonalFilter) filterMap.put(item, "diagonal");
                filter.add(filterMap);
                break; 
            
            case 9:
                System.out.print("Введите минимальную цену: ");
                String minPrice = iScanner.nextLine();
                System.out.print("Введите мaксимальную цену: ");
                String maxPrice = iScanner.nextLine();
                filterMap.put(minPrice, "minPrice");
                filterMap.put(maxPrice, "maxPrice");
                filter.add(filterMap);
                break;     
        }

        return filter;
    }
}
