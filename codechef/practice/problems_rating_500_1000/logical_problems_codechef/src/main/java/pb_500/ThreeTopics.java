package pb_500;

import java.util.Scanner;

public class ThreeTopics {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();

        if(x == a || x == b || x == c){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
