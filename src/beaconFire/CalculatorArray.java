package beaconFire;

import java.util.ArrayList;
import java.util.List;
/*
input1 = [5, 6, 14, 7];
input2 = ["add", "sub", "div"];
For example, the above input should be evaluated as:

5 + 6 - (14 / 7) = 9
*/
public class CalculatorArray {

    public int calculate(int[] input1, String[] input2) {
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for(int n:input1) numbers.add(n);
        for(String s:input2) operators.add(s);

        for(int i=0;i<operators.size();){
            String op = operators.get(i);

            if(op.equals("mul")||op.equals("div")){
                int left = numbers.get(i);
                int right = numbers.get(i+1);
                int val = (op.equals("mul"))?left*right:left/right;

                numbers.set(i,val);
                numbers.remove(i+1);
                operators.remove(i);
            }else{
                i++;
            }
        }

        int res = numbers.get(0);
        for(int i=0;i<operators.size();i++){
            int right = numbers.get(i+1);
            if(operators.get(i).equals("add")){
                res += right;
            }else{
                res -= right;
            }
        }
        return res;

    }
}

