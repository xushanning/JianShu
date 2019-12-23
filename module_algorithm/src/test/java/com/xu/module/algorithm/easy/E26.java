package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/22.
 */
public class E26 {
    /**
     * 给定一个排序数组(这个数组只能建立在从小到大的基础之上)，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * nums = [0,0,1,1,1,2,2,3,3,4]
     * <p>
     * 示例  :
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素(这点非常重要，其实数组的长度没变，只是把不重复的放到前面，重复的丢到了后面)。
     */
    @Test
    public void test() {
        int[] data = new int[]{0, 0, 1, 1, 1, 2, 0, 3, 3, 4};
        PrintUtil.print(remove(data));
    }

    private int remove(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //第一个指针i
        int i = 0;
        //第二个指针j
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                //不同的话，就赋值
                i++;
                nums[i] = nums[j];
            }
        }
//        for (int num : nums) {
//            PrintUtil.print(num);
//        }

        return i + 1;
    }
}
