package pb_500;


import java.util.Scanner;

public class Mahasena {

    static void main() {

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        sc.nextLine();
        int lucky = 0;
        int unlucky = 0;
       // while(numTest-- > 0){
            String[] line = sc.nextLine().trim().split(" ");
            int len = line.length;
            for(int i = 0; i< len; i++){
                int temp = Integer.parseInt(line[i]);
                if(temp % 2 == 0){
                    lucky++;
                }else{
                    unlucky++;
                }
            }
      //  }

        if(lucky > unlucky){
            System.out.println("READY FOR BATTLE");
        }else {
            System.out.println("NOT READY");
        }
    }

}
