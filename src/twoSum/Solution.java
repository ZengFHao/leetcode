package twoSum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 设置a数组的目的就是为了保存原数组的序列
         * 如果像下面这样，两者会指向堆空间的同一地址区域
         * 所以压根就没能保存原数组的序列
         * 即我们需要在堆中单独声明一个数组
         */
        //int []a=nums;
        int[] a=new int[]{};
        a=nums.clone();
        Arrays.sort(nums,0,nums.length);
        //int result[]=new int[]{-1,-1};
        Boolean flag1=false;
        Boolean flag2=false;
        int [] result=new int[2];
        int low=0;
        int high=nums.length-1;
        while(low<high){
            if(nums[low]+nums[high]<target){
                low++;

            }else if(nums[low]+nums[high]>target){
                high--;
            }else{
                for(int i=0;i<nums.length;i++){
                    if(a[i]==nums[low]||a[i]==nums[high]){
                        if(flag1==false){
                            result[0]=i;
                            flag1=true;
//                            System.out.println(a[i]);
                        }else{
                            result[1]=i;
                            flag2=true;
//                            System.out.println(a[i]);
                        }
                    }
                    if(flag2==true){
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}
