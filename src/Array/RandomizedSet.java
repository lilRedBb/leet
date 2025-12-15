package Array;

import java.util.*;

class RandomizedSet {
    //要支持insert remove random的方法，时间复杂度都是1
    //之所以要用到array就是因为random，只有通过array的index来randomly的找到值才能达成random
    //如果直接用set，set是没有index可言的，所以就不能random
    private List<Integer> nums;
    private Map<Integer, Integer> idxMap;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!idxMap.containsKey(val)) {
            idxMap.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(idxMap.containsKey(val)) {
            int swapVal = nums.get(nums.size() - 1), idx = idxMap.get(val);
            idxMap.put(swapVal, idx);
            nums.set(idx, swapVal);
            idxMap.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(nums.size());
        return nums.get(randomIdx);
    }
};
