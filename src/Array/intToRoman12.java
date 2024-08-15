package Array;

public class intToRoman12 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuffer buff = new StringBuffer();
        for(int i=0;i<values.length;i++){
            int val = values[i];
            String symbol = symbols[i];
            while(num>=val){
                buff.append(symbol);
                num -= val;
            }
            if(num==0){
                break;
            }
        }


        return buff.toString();
    }
}
