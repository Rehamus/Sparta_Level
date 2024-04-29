import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);

    private List<Double> list = new ArrayList<>();
    private  List<Double> list_circle = new ArrayList<>();

    public Calculator() {}

    // 사칙연산 get set
    public List<Double> getList_circle() {
        return list;
    }
    public void setList(List<Double> list) {
        this.list = list;
    }

    // 원둘래 get set
    public List<Double> getList() {
        return list_circle;
    }
    public void setList_circle(List<Double> list_circle) { this.list_circle = list_circle; }


}

