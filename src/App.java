import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void app_calculate() {//쓰기 편하게 하려고
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArithmeticCalculator A_cr = new ArithmeticCalculator();
        CircleCalculator Ci_cr = new CircleCalculator();


        try {
            System.out.print("원넓이 or 사칙연산 : ");
            String strat_order = bf.readLine();
            System.out.println();

            while (true){
                if(strat_order.equals("원넓이")) {
                System.out.print("반지를 값 (remove,end,view) :");
                String half = (bf.readLine());
                if(half.equals("end")){
                    break;
                } else if (half.equals("view")) {
                    Ci_cr.view_circle();
                }else if (half.equals("remove")) {
                    Ci_cr.setList_circle();
                    Ci_cr.view_circle();
                }else {
                    Ci_cr.half_circle(Double.parseDouble(half));
                }
                System.out.println();
            } else {
                System.out.print("첫 번째 숫자를 입력하세요:");
                double a = Double.parseDouble(bf.readLine());
                System.out.print("첫 번째 숫자를 입력하세요:");
                double b = Double.parseDouble(bf.readLine());
                System.out.print("사칙연산 기호를 입력하세요: ");
                strat_order = bf.readLine();

                try {
                    System.out.println("계산값 : "+ A_cr.calculate(a, strat_order, b));
                } catch (Calculator_Exception e) {
                    String message = e.getMessage();
                    System.out.println(message);
                }

                while (true){
                    System.out.print("더 계산하시겠습니까? (help) : ");
                    strat_order = bf.readLine();
                    if (strat_order.equals("end")) {
                        System.exit(0);
                    }else if (strat_order.equals("modify")) {
                        A_cr.modify_List();
                    }else if (strat_order.equals("view")) {
                        A_cr.viewList();
                    }else if (strat_order.equals("what_is_more_big")) {
                        System.out.print("어떠한 값 이상일지 입력해주세요 : ");
                        A_cr.what_is_more_big(Double.parseDouble(bf.readLine()));
                    }else if (strat_order.equals("first_remove")) {
                        A_cr.viewList();
                        System.out.print("지워진 가장 오래된 값 : ");
                        A_cr.first_remove_List();
                        System.out.print("이후 값 : ");
                        A_cr.viewList();
                    }else if (strat_order.equals("help")) {
                        System.out.println("end,view,modify,first_remove,what_is_more_big");
                    }else{
                        break;
                    }
                }
                System.out.println();
            }}


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
