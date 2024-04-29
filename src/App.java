import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void app_calculate() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Calculator cr = new Calculator();

        try {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요:");
                double a = Double.parseDouble(bf.readLine());
                System.out.print("첫 번째 숫자를 입력하세요:");
                double b = Double.parseDouble(bf.readLine());
                System.out.print("사칙연산 기호를 입력하세요: ");
                String str = bf.readLine();

                try {
                    System.out.println("계산값 : "+cr.calculate(a, str, b));
                } catch (Calculator_Exception e) {
                    String message = e.getMessage();
                    System.out.println(message);
                }

                System.out.print("더 계산하시겠습니까? (exit,view,modify) : ");
                str = bf.readLine();
                if (str.equals("exit")) {
                    System.exit(0);
                }else if (str.equals("modify")) {
                    cr.setList();
                }else if (str.equals("view")) {
                    cr.viewList();
                }

                System.out.println();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
