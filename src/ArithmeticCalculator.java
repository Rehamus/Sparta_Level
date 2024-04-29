import java.util.Arrays;
import java.util.regex.Pattern;

public class ArithmeticCalculator extends Calculator {


    final double calculate(double a, String str, double b) throws Calculator_Exception {

        AllOperator all_a = new AddOperator();
        String p = "^[a-zA-Z]*$";
        String num = "^[0-9]*$";
        double answer = 0;

        if (str.equals("+")){
            all_a = OperatorType.ADD.getOperator();
        }else if (str.equals("-")){
            all_a = OperatorType.SUB.getOperator();
        }else if (str.equals("*")){
            all_a = OperatorType.MLT.getOperator();
        }else if (str.equals("/")){
            all_a = OperatorType.DIV.getOperator();
        }else if (str.equals("%") && a == 0 || b == 0){
            throw new Calculator_Exception(" 0은 나눌 수 없습니다");
        }else if(str.equals("%")){
            all_a = OperatorType.MOD.getOperator();
        }else if (str.isBlank()|| Pattern.matches(p,str) || Pattern.matches(num,str) ){
            throw new Calculator_Exception(" 제대로 된 값을 입력해 주세요");
        }

        answer = all_a.operate(a, b);
        getList().add(answer);
        return answer;
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

