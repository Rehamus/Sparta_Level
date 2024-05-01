import java.util.Arrays;
import java.util.regex.Pattern;

public class ArithmeticCalculator<T,U> extends Calculator {

    private T t;

    private U u;

    public T get_t() {
        return t;
    }
    public U get_u() {
        return u;
    }
    public void add(T t, U u) {
        this.t = t;
        this.u = u;
    }

    final double calculate(double a, String str, double b) throws Calculator_Exception {

        ArithmeticCalculator<Double,Double> art = new ArithmeticCalculator<>();
        art.add(a, b);
        AllOperator all_a = new AddOperator();
        String p = "^[a-zA-Z]*$";
        String num = "^[0-9]*$";
        double answer = 0;
        switch (str) {
            case "+" -> all_a = OperatorType.ADD.getOperator();
            case "-" -> all_a = OperatorType.SUB.getOperator();
            case "*" -> all_a = OperatorType.MLT.getOperator();
            case "/" -> all_a = OperatorType.DIV.getOperator();
            case "%" -> {
                if ( a == 0 || b == 0){
                    throw new Calculator_Exception(" 0은 나눌 수 없습니다");
                }else {
                    all_a = OperatorType.MOD.getOperator();
            }}
            default -> throw new Calculator_Exception(" 제대로 된 값을 입력해 주세요");
        }
        answer = all_a.operate(art.get_t(), art.get_u());
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
            System.out.print("'+' 추가, '-' 제거 ,'find' 특정값 찾기,'end' 완료 \n입력해 주세요 :");
            String st = sc.nextLine();
            if (st.equals("+")){
                System.out.print("추가값 :");
                getList().add(sc.nextDouble());
            }else if (st.equals("find")){
                while (true){
                    System.out.print("max 최대값 ,min 최소값 ,avg 평균값 ,'end' 완료 \n입력해 주세요 : ");
                    String num = sc.nextLine();
                    if (num.equals("min")){
                        Double min = getList().stream()
                                .mapToDouble(x -> x)
                                .min()
                                .orElseThrow();
                        System.out.println(min);

                    }else if (num.equals("max")){
                        Double max = getList().stream()
                                .mapToDouble(x -> x)
                                .max()
                                .orElseThrow();
                        System.out.println(max);

                    }else if (num.equals("avg")){
                        Double avg = getList().stream()
                                .mapToDouble(x -> x)
                                .average()
                                .orElseThrow();

                        System.out.println(avg);

                    }else if (num.equals("end")){
                        break;
                    }
                }
                System.out.println();
            }else if (st.equals("-")){
                viewList();
                System.out.println("몇번째를 지우시겠습니까? : ");
                    int finalIndex = sc.nextInt() ;
                    if (getList().size() < finalIndex){
                        System.out.println("제대로 입력해 주세요");
                    }else{
                        getList().remove(finalIndex);
                    }
            }else if (st.equals("end")){
                System.out.println();
                break;
            }
        }
    }

}

