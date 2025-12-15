package beaconFire.d1;

import java.util.Scanner;

public class LargestNumCount {

    public void countTheBiggest(String s){
        String[] parts = s.trim().split("\\s+");

        int max = Integer.MIN_VALUE;
        int count = 0;

        for (String part:parts){
            if (part.matches("\\d+")){
                int partInt = Integer.parseInt(part);
                if (partInt>max){
                    max = partInt;
                    count =  1;
                } else if (partInt==max) {
                    count++;
                }
            }
        }

        System.out.println(" The largest number is "+ max);
        System.out.println("The occurrence of the biggest number is "+ count);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        String input = scanner.nextLine();
        countTheBiggest(input);
    }


    public static void main(String[] args) {

        LargestNumCount lnc = new LargestNumCount();
        lnc.run();

    }
}
