import java.util.regex.Pattern;

public class Calculator {
        double c = 0;

    public double calculate(double a, String str, double b) throws Calculator_Exception {

        String p = "^[a-zA-Z]*$";

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
        }else if (str.isBlank()|| Pattern.matches(p,str) ){
            throw new Calculator_Exception(" 제대로 된 값을 입력해 주세요");
        }
        return c;
    }
}
