package d27;

import org.junit.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int num=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }

    @Test
    public void test(){
//        int[] array = new int[]{0,1,2,2,3,0,4,2};
        int[] array = new int[]{4};
        int len = removeElement(array,5);
        for(int i = 0; i<len; i++){
            System.out.print(array[i] + " ");
        }
    }
}
