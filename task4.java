// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно 
// решение или сообщить, что его нет.

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Напишите уравнение: ");
        String equation = iScanner.nextLine();
        iScanner.close();
        String[] words = equation.split(" ");
        char[] firstNum = words[0].toCharArray();
        char[] secondNum = words[2].toCharArray();
        int result = Integer.parseInt(words[4]);

        int replace1 = 0;
        int replace2 = 0;
        int num1 = -1;
        int num2 = -1;
        for(int i = 0; i < firstNum.length; i++){
            if(firstNum[i] == '?') replace1 = i;
        }
        for(int i = 0; i < secondNum.length; i++){
            if(secondNum[i] == '?') replace2 = i;
        }
        for(int i = 0; i < 10; i++){
            char[] temp1 = Integer.toString(i).toCharArray();
            firstNum[replace1] = temp1[0];
            String n1 = new String(firstNum);
            int nmb1 = Integer.parseInt(n1);
            for(int j = 0; j < 10; j++){
                    char[] temp2 = Integer.toString(j).toCharArray();
                    secondNum[replace2] = temp2[0];
                    String n2 = new String(secondNum);
                    int nmb2 = Integer.parseInt(n2);
                    if(nmb1 + nmb2 == result){
                        num1 = nmb1;
                        num2 = nmb2;
                        break;
                    }
                }
            }
            if(num1 == -1){
                System.out.println("Решений нет");
            }
            else{
                System.out.printf("%d + %d = %d", num1, num2, result);
            }
        }
    }

