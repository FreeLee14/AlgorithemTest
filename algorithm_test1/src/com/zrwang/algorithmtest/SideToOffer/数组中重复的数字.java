package com.zrwang.algorithmtest.SideToOffer;

public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    /**
     * 此次解题的思路是将时间复杂度和空间复杂度降低至O(n)和O(1)
     * @param nums
     * @return
     */
    public static int findRepeatNumber (int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++){
            // 对应的数字要放在对应的索引上
            while (i != nums[i] && nums[nums[i]] != nums[i] ){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
            // 当索引与当前数字不等时，但是当前数字作为索引对应的位置等于当前数字，说明存在重复值
            if (i != nums[i] && nums[nums[i]] == nums[i])
                return nums[i];
        }
        return -1;
    }

}
