package pb_500;

import java.util.Scanner;

public class GreaterAverage {

    static void main() {
        System.out.println("Greater average");
        findAverage();
    }

    public static void findAverage(){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.next());
        sc.nextLine();

        while(num > 0){
            String[] numbers = sc.nextLine().trim().split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);
            int num3 = Integer.parseInt(numbers[2]);

            int avg = (num1 + num2) / 2;
            if(avg > num3){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            num--;
        }
    }


}
