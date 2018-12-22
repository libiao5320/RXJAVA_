package com.lee.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author :Lee
 * Since :2018/12/10下午3:23
 * Desc :TwoSum Do What ?
 */
public class TwoSum {


    /**
     * 暴力解决方法,循环遍历两次
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        long start  = System.currentTimeMillis();

        int[] result = new int[2];

        if (null != nums && nums.length > 0) {
            int len = 0;
            len = nums.length;
            for (int i = 0; i < len; i++) {

                int j = i + 1;
                while (j < len) {

                    System.out.println(nums[i] + nums[j]);
                    if ((nums[i] + nums[j]) == target) {
                        result[0] = i;
                        result[1] = j;
                        System.out.println("speed time" + (System.currentTimeMillis() - start));

                        return result;


                    } else {
                        j++;
                        continue;
                    }


                }


            }

        }

        return result;

    }


    /**
     * 两遍hash表
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（
     *
     * target−nums[i]）是否存在于表中。注意，该目标元素不能是nums[i] 本身！
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表

       事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_1(int[] nums, int target) {


        long start  = System.currentTimeMillis();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("speed time" + (System.currentTimeMillis() - start));
                return new int[] { map.get(complement), i };

            }
            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {

        int[] params = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] result = twoSum(params, target);
        System.out.print(result[0] + "||" + result[1]);

    }

}