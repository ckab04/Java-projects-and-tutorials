package pb_500;

import java.util.Scanner;

public class ChefAndNextGen {
    static void main() {
        System.out.println("Chef and NextGen");
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        while (numTest-- > 0) {

            // problems
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int powerNeeded = a * b;
            int powerOnMoon = x * y;

            if(powerOnMoon >= powerNeeded){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
