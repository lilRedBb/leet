package Heap;
import java.util.*;
public class minpairs373 {

/**输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 输出: [1,2],[1,4],[1,6]
 解释: 返回序列中的前 3 对数：
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 示例 2:**/


        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
                return result;
            }

            //a[0] 应该是nums1[i],a[1]是nums2[0],  {nums1[i],nums2[j]}的和来比较，造成排序
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
            );

            // InThe first for loop in the code actually pairs each element in nums1 with the first element
            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                minHeap.offer(new int[]{nums1[i], nums2[0], 0}); // {num1, num2, index in nums2}
            }

            // Extract the smallest pairs from the heap
            while (k > 0 && !minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                result.add(Arrays.asList(current[0], current[1]));
                k--;

                // If there is a next element in nums2, push the next pair into the heap
                if (current[2] + 1 < nums2.length) {
                    minHeap.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
                }
            }

            /**Why Just Pairing with nums2[0] Isn't Enough:
             If you only paired each element in nums1 with nums2[0],
             you'd only be considering the first possible smallest sum for each element in nums1. However, other combinations might form smaller sums that need to be included in the k smallest pairs. For example:

             Consider nums1 = [1, 2, 3] and nums2 = [1, 2, 3].
             The k smallest pairs might include (1,1), (1,2), (2,1), etc.
             If you only considered pairs with nums2[0] (i.e., (1,1), (2,1), (3,1)), you'd miss pairs like (1,2) or (2,1) that could be smaller than others in the initial set.**/

            return result;
        }
        /**a[0] + a[1]:

         This calculates the sum of the first two elements in the array a.
         In the context of the k smallest pairs problem, a[0] might be an element from nums1,and a[1] an element from nums2.
         So, a[0] + a[1] gives the sum of that particular pair.**/

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] nums1 = {1, 7, 11};
//            int[] nums2 = {2, 4, 6};
//            int k = 3;
//            List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
//            System.out.println(result);
//        }
//

}
