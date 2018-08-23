package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 给定一个整型数组和指定值，返回数组内两数相加等于指定值的两数的数组下标
 * @author: wqdong
 * @create: 2018-08-23 12:18
 **/
public class TwoSum {

    //暴力法
    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //哈希
    public static int[] twoSum2(int[] nums,int target){
        int[] result = new int[2];
        Map<Integer,Integer> mp = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                result[0] = mp.get(target-nums[i]);
                result[1] = i;
                return  result;
            }
            mp.put(nums[i],i);
        }

        return result;
    }

    public static  void main(String[] args){
        int[] nums = {155,2,7,11,15};
        int target = 9;
        int[] rs = twoSum(nums,target);
        System.out.println(rs[0]+","+rs[1]);
        rs = twoSum2(nums,target);
        System.out.println(rs[0]+","+rs[1]);
    }
}
