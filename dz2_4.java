import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// К калькулятору из предыдущего дз добавить логирование.

public class dz2_4 {
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
        int answer = calculator(a, operation, b);
        System.out.println(answer);
        writeLogs(a, operation, b, answer);
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
                if(m != 0) res = n / m;
                else System.out.println("Делить на ноль нельзя!");
                break;
            case '*':
                res = n * m;
                break;
        }
        return res;
    }
    public static void writeLogs(int a1, char oper, int a2, int answ) {
        StringBuilder str = new StringBuilder();
        str.append(a1 + " " + oper + " " + a2 + " = " + answ);
        Logger logger = Logger.getLogger(dz2_4.class.getName());
        logger.setLevel(Level.INFO);
            try {
                FileHandler fh = new FileHandler("log.txt");
                logger.addHandler(fh);
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                logger.info(str.toString());
            } catch (IOException e) {
                e.getStackTrace();
            }
    }
}
