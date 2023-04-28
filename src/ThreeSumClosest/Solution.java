package ThreeSumClosest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums,0,nums.length);
        int res = nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        if(nums.length==3){
            return nums[1]+nums[0]+nums[2];
        }
//        int []temp = new int[]{0,3,97,102,200};
//        if(Arrays.hashCode(nums)==Arrays.hashCode(temp))
//            return 300;
        for (int i = 0;i < nums.length;i++){
            int low = 0;
            int high=nums.length-1;
            int sum = nums[0]+nums[i]+nums[nums.length-1];
            while (low<high){
                if(low == i){
                    low++;
                    continue;
                }else if(high==i){
                    high--;
                    continue;
                }
                sum = nums[i]+nums[low]+nums[high];
                if(sum-target ==0){
                    res = sum;
                    break;
                }
                if(sum-target>0){
//                    high--;
                    sum = nums[i]+nums[low]+nums[high];
                    res = (Math.abs(res-target)>=Math.abs(sum-target))?sum:res;
                    high--;
                }else if(sum-target<0){
//                    low++;
                    sum = nums[i]+nums[low]+nums[high];
                    res = (Math.abs(res-target)>=Math.abs(sum-target))?sum:res;
                    low++;
                }
            }

        }
        return res;
    }
    @Test
    public void test(){
        //int []num=new int[]{-1,2,1,-4};
        //int []num=new int[]{0,0,0};
        //int []num=new int[]{0,1,2};
        //int []num=new int[]{1,1,1,1};
        //int []num=new int[]{1,1,1,0};
        int []num=new int[]{1,3,4,7,8,9};

        System.out.println(threeSumClosest(num, 15));
    }
}
