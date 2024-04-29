import java.util.Arrays;
import java.util.regex.Pattern;

public class ArithmeticCalculator extends Calculator {
    // 계산식이니 나중에 실수로 추가 선언해서 문제 안생기도록 만듬
    final double calculate(double a, String str, double b) throws Calculator_Exception {

        double c = 0;
        String p = "^[a-zA-Z]*$";
        String num = "^[0-9]*$";

        if (str.equals("+")){
            c = a + b;
        }else if (str.equals("-")){
            c = a - b;
        }else if (str.equals("*")){
            c = a * b;
        }else if (str.equals("/")){
            c = a / b;
        }else if (str.equals("%") && a == 0 || b == 0){
            throw new Calculator_Exception(" 0은 나눌 수 없습니다");
        }else if(str.equals("%")){
            c = a%b;
        }else if (str.isBlank()|| Pattern.matches(p,str) || Pattern.matches(num,str) ){
            throw new Calculator_Exception(" 제대로 된 값을 입력해 주세요");
        }

        getList().add(c);
        return c;
    }

    public void viewList() {
        System.out.println(Arrays.toString(getList().toArray()));
    }

    public void first_viewList() {
        System.out.println(getList().getFirst());
    }

    public void modify_List() {
        System.out.println("저장 내역 수정");
        while (true){
            System.out.println(Arrays.toString(getList().toArray()));
            System.out.print("'+' 추가, '-' 오래된 값 제거 'end' 완료 \n입력해 주세요 :");
            String st = sc.nextLine();
            if (st.equals("+")){
                System.out.print("추가값 :");
                getList().add(sc.nextDouble());
            }else if (st.equals("-")){
                getList().removeFirst();
            }else if (st.equals("end")){
                System.out.println();
                break;
            }
        }
    }

}
