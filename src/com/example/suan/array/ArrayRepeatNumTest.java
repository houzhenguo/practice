package com.example.suan.array;

public class ArrayRepeatNumTest {
    // 找出数组中任意一个重复的元素
    public static void main(String[] args) {

    }
    // 查找到任意一个数组中重复的数字 数字范围 0-n-1
    // 解题思路： 把每个数字放在 对应的下标的位置上，如果对应下标
    // 位置已经有一个一模一样的数字，那么这就是有重复的
    public void findRepeatedNum() {
        int [] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNum = -1;
        for (int i=0; i<nums.length;i++) {
            int currNum = nums[i];
            int otherNum = nums[currNum];
            if(currNum == otherNum) {
                repeatNum = currNum;
                break;
            }
            swap(nums, i, currNum);
        }
        System.out.println("repeated" + repeatNum); // 2
    }
    public  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
