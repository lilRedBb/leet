package Array;

public class stock121 {
    public int maxProfit(int[] prices) {
        int sellOne = 0; // Maximum profit after selling one stock
        int holdOne = Integer.MIN_VALUE; // Maximum profit after buying one stock

        for (int price : prices) {
            sellOne = Math.max(sellOne, holdOne + price); // Update sellOne with the best profit after selling today
            holdOne = Math.max(holdOne, -price); // Update holdOne with the best profit after buying today
            //当hold+price盈利更多的时候，你会选择在今天卖出
            //于是下面的（holdone,-price）这里，肯定不会选-price，因为今天是卖出了，没有以price价格买入
        }

        return sellOne; // The maximum profit after one transaction
    }

    public static void main(String[] args) {
        stock121 aa = new stock121();
        int[] array = {1,2,3,4,5};
        int a = aa.maxProfit(array);
    }
}
