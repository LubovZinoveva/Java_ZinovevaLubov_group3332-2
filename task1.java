// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите n: ");
        int n = Integer.parseInt(iScanner.nextLine());
        iScanner.close();

        System.out.println("Треугольное число = " + calculateTriangularNumber(n));
        System.out.println("Факториал = " + calculateFactorial(n));
    }
    
    public static int calculateTriangularNumber(int num) {
        int result = (num*(num+1))/2;
        return result;
    }

    public static int calculateFactorial(int number) {
        int factorial = 1;
        for(int i = 1; i <= number; i++){
            factorial *= i;
        }
        return factorial;
    }
    
}