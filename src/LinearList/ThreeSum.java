package LinearList;

import org.testng.annotations.Test;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final int LEN = nums.length;
        List<List<Integer>> list1 = new ArrayList<>();
        Map<List<Integer>,List<Integer>> map = new HashMap<>();
        Arrays.sort(nums,0,nums.length);
        //优化3
        for(int i = 0; i<LEN && nums[i]<=0; i++){
            //优化1
            if(i>0 && nums[i] == nums[i-1])
                continue;
            //int low = 0;
            //优化2
            int low = i+1;
            int high = LEN-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(low == i){
                    low++;
                    continue;
                }else if(high == i){
                    high--;
                    continue;
                }


                if(sum > 0)
                    high--;
                else if(sum < 0)
                    low++;
                else{
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(nums[i]);
                    list2.add(nums[low]);
                    list2.add(nums[high]);
                    List<Integer> list3 = new ArrayList<>();
                    list3 = list2;
                    Collections.sort(list2);
                    map.put(list2,list3);
                    /**
                     * contains()方法不能判断乱序的值是否相等
                     * 只判断的是字面量是否相同
                     * eg：[1,2,3],[3,2,1]
                     * 在contains()方法返回的结果为false
                     * 所以先通过Collections.sort()将list排序
                     * 其本质就是先将list转化为Arrays，然后调用Arrays.sort()
                     */
                    //Collections.sort(list2);
                    low++;
//                    if(!list1.contains(list2)){
//                        list1.add(list2);
//                    }
                }
            }
        }
        List<List<Integer>> list2 = new ArrayList<>();
        for (Map.Entry i : map.entrySet()){
            list2.add((List<Integer>) i.getValue());
        }
        return list2;
    }

    @Test
    public void test(){
        //int []nums = new int[]{-1,0,1,2,-1,-4};
        int []nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        //int []nums = new int[]{0,0,0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
}
