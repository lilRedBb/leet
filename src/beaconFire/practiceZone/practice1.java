package beaconFire.practiceZone;

import java.util.Scanner;

public class practice1 {

    public int largeFre(String s){
        String[] sArray = s.trim().split("\\s+");
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (String string:sArray){
            int curr = Integer.parseInt(string);
            if (curr>max){
                count = 1;
                max = curr;
            } else if (curr==max) {
                count++;
            }
        }
        System.out.println();
        return count;

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your number");
        String input = scanner.nextLine();
        practice1 p = new practice1();
        int res = p.largeFre(input);
        System.out.println(res);

    }
}
