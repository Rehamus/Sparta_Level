import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    Scanner sc = new Scanner(System.in);
    private final List<Double> list = new ArrayList<>();
    // 추후 추가 선언을 해서 문제을 잃으키지 않기 위해서 final 로 선언함
    private final List<Double> list_circle = new ArrayList<>();

    public Calculator() {}


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

        list.add(c);
        return c;
    }

    public List<Double> getList() {
        return list;
    }

    public void viewList() {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void first_viewList() {
        System.out.println(list.get(0));
    }

    public void setList() {
        System.out.println("저장 내역 수정");
        while (true){
            System.out.println(Arrays.toString(list.toArray()));
            System.out.print("'+' 추가, '-' 오래된 값 제거 'end' 완료 \n입력해 주세요 :");
            String st = sc.nextLine();
            if (st.equals("+")){
                System.out.print("추가값 :");
                list.add(sc.nextDouble());
            }else if (st.equals("-")){
                list.remove(0);
            }else if (st.equals("end")){
                System.out.println();
                break;
            }
        }
    }

    final public void half_circle(double a){
        double A = Math.round(3.1415 * Math.pow(a, 2));
        System.out.println("원의 넓이 : "+A);
        list_circle.add(A);
    }

    public void setList_circle(){
        list_circle.remove(0);
    }

    public List<Double> getList_circle() {
        return list_circle;
    }

    public void view_circle(){System.out.println(Arrays.toString(list_circle.toArray()));}
}
