package Bincode;

class MinOperationToZero2571 {
    //一个数，减去or加上2的次方，可以是2的任意次方，要用最少的次数把自己变成0.
    //可以减去比自己大的数字，然后留存一个负数，负数加另一个数，也慢慢变成了0
    public int minOperations(int n) {

        int operations = 0;

        while (n>0){
            int power = 1;
            while (n-power*2>=0){

                power*=2;

            }

            int nextPowerNumber = power*2;

            if (n-power>nextPowerNumber-n){
                n = nextPowerNumber - n;
            }else {
                n = n - power;
            }
            operations++;
        }


        return operations;
    }

    public int minOperationsRe(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 0;

        // Find the largest power of 2 ≤ n
        int power = 1;
        while (power * 2 <= n) {
            power *= 2;
        }

        int nextPower = power * 2;

        // Choose the smaller move: subtract or add
        if (n - power < nextPower - n) {
            return 1 + helper(n - power);
        } else {
            return 1 + helper(nextPower - n);
        }
    }
}
