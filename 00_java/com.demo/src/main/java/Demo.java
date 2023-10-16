import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하시오 : ");
        int num = sc.nextInt();     //숫자를 입력받아
        if (num > 100){     //큰지 작은지
            System.out.println("100보다 큰 수 입니다.");
        } else {
            System.out.println("100보다 작은 수 입니다.");
        }
    }



}
