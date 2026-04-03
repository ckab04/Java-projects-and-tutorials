package pb_500;

import java.util.Scanner;

public class Subscriptions {
    static void main() {
        System.out.println("Buy subscription");
        buySubscription();
    }


    public static void buySubscription(){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int numOfShare = 6;
        int res;

        while(testCases-- > 0){
            int N = sc.nextInt();
            int price = sc.nextInt();
            res = N / numOfShare;
            if(N % numOfShare == 0){
                System.out.println(price * res);
            }else{
                System.out.println(price * (res + 1));
            }
        }


    }


}
