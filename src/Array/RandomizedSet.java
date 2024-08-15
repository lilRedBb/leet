package Array;

import java.util.*;

class RandomizedSet {
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
