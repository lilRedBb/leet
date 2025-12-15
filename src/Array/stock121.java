package Array;

public class stock121 {
    public int maxProfit(int[] prices) {


            if (prices == null || prices.length == 0) return 0;

            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                // update min price
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    // calculate profit if sold today
                    int profit = prices[i] - minPrice;
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }

            return maxProfit;
        }




    public static void main(String[] args) {
        stock121 aa = new stock121();
        int[] array = {1,2,3,4,5};
        int a = aa.maxProfit(array);
    }
}
