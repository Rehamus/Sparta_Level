import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) {
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
                    System.out.println(cr.calculate(a, str, b));
                } catch (Calculator_Exception e) {
                    String message = e.getMessage();
                    System.out.println(message);
                }

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
                str = bf.readLine();
                if (str.equals("exit")) {
                    System.exit(0);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
