// Вывести все простые числа от 1 до 1000. Использовала решето Эратосфена.
public class task2 {
    public static void main(String[] args) {
        boolean[] a = new boolean[10001];
        for(int i = 2; i*i < 1001; i++){
            if(a[i] == false){
                for(int j = i*i; j < 1001; j = j + i){
                    a[j] = true;
                }
            }
        }
        for(int i = 2; i < 1001; i++){
            if(a[i] == false) System.out.print(i + " ");
        } 
    } 
}
