package twoSum;

import java.util.Arrays;

public class towSumTest {
    public static void main(String[] args) {
        Solution solution=new Solution();
        //int []array=new int[]{5,8,0,1,2,3,4,5,19,23,50};
        //int []array=new int[]{-10,-1,-18,-19};
       //int []array=new int[]{-3,4,3,90};
        int []array=new int[]{-1,-2,-3,-4,-5};
        int a[]=solution.twoSum(array,-8);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
}
