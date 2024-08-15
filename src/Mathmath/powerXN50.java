package Mathmath;

public class powerXN50 {
    public double myPow(double x, int n) {
        // Handle the case when n is negative
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        // Binary exponentiation
        while (N > 0) {
            if ((N % 2) == 1) {
                result = result * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            N = N / 2;
        }

        return result;
    }



    public double myPow2(double x, int n) {
        // Handle the case when n is negative
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        // Call the recursive helper function
        return powHelper(x, n);
    }

    private double powHelper(double x, int n) {
        // Base case: x^0 is always 1
        if (n == 0) {
            return 1.0;
        }

        // Recursive case: divide the problem into smaller parts
        double half = powHelper(x, n / 2);

        // If n is even, the result is half * half
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd, we multiply by x one more time
            return half * half * x;
        }
    }
}
