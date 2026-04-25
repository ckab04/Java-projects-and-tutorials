package pb_500;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemsInYourToDoList {

    static void main() {
        System.out.println("Problems in your to-do list");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        while (numTest-- > 0) {
            int n = sc.nextInt();
            int [] problems= new int[n];
            int i = 0;
            while(i < n){
                problems[i++] = sc.nextInt();
            }
            long count = Arrays.stream(problems)
                    .filter(p -> p >= 1000)
                    .count();
            System.out.println(count);

        }

    }


}
