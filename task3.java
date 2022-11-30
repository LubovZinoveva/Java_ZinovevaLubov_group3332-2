// Реализовать простой калькулятор 
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите 1-е число: ");
        int a = Integer.parseInt(iScanner.nextLine());
        System.out.printf("Введите операцию: ");
        char[] o = (iScanner.nextLine()).toCharArray();
        char operation = o[0];
        System.out.printf("Введите 2-е число: ");
        int b = Integer.parseInt(iScanner.nextLine());
        iScanner.close();
        System.out.println(calculator(a, operation, b));
    }
    public static int calculator(int n, char oper, int m) {
        int res = 0;
        switch(oper){
            case '+':
                res = n + m;
                break;
            case '-':
                res = n - m;
                break;
            case '/':
                res = n / m;
                break;
            case '*':
                res = n * m;
                break;
        }
        return res;
    }
}
