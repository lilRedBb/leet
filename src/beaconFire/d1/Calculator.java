package beaconFire.d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    public int calculate(int[] input1, String[] input2){
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i:input1){
            numbers.add(i);
        }

        Collections.addAll(operators, input2);

        for (int i=0;i<operators.size();){
            String op = operators.get(i);

            if (op.equals("mul")||op.equals("div")){
                int left = numbers.get(i);
                int right = numbers.get(i+1);
                int val = op.equals("mul")?left*right:left/right;
                numbers.set(i,val);
                numbers.remove(i+1);
                operators.remove(i);
            }else{
                i++;
            }
        }

        int res = numbers.get(0);
        for (int i=0;i<operators.size();i++){
            int right = numbers.get(i+1);
            if (operators.get(i).equals("add")){
                res += right;
            }else {
                res -= right;
            }
        }
        return res;


    }
}
