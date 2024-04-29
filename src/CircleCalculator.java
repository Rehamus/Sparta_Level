import java.util.Arrays;

public class CircleCalculator extends Calculator {

    final public void half_circle(double a){
        double A = Math.round(3.1415 * Math.pow(a, 2));
        System.out.println("원의 넓이 : "+A);
        getList_circle().add(A);
    }

    public void setList_circle(){
        getList_circle().removeFirst();
    }

    public void view_circle(){System.out.println(Arrays.toString(getList_circle().toArray()));}

}
