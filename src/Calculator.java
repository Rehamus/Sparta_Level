public class Calculator {

    public double calculate(double a,String str ,double b) throws Calculator_Exception {
        double c = 0;

        if (str.equals("+")){
            c = a + b;
        }else if (str.equals("-")){
            c = a - b;
        }else if (str.equals("*")){
            c = a * b;
        }else if (str.equals("/")){
            c = a / b;
        }else if (str.equals("%") && a == 0 || b == 0){
            throw new Calculator_Exception();
        }else if(str.equals("%")){
            c = a%b;
        }
        return c;
    }
}
