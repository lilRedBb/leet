package Array;

public class pruductNotself238 {
    public int[] productExceptSelf(int[] nums) {
        //给你一个数组，返回新的数组，新数组【i】= 老数组【i】之外的其他元素的乘机


        //result【i】,它前面的result【i-1】已经是nums里nums[0]*nums[1]*....nums[i-2]的乘机了，
        //所以result[i]的结果就是 前面的乘积，再乘以nums【i-1】
        int n = nums.length;
        int[] result = new int[n];

        // Compute left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }


        //上面拿到的result，都没有乘以i往右边走的nums的元素，这里补乘
        // Compute right products and update result
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }


}
