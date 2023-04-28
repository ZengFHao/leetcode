package d732;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 1;
        int[] push = new int[pushed.length+1];
        for(int i = 0;i < push.length;i++){
            push[i] = -1;
        }
        while(index2 < pushed.length){
            if(push[index3 - 1] != popped[index2]){
                if(index1 == pushed.length){
                    return false;
                }
                push[index3] = pushed[index1];
                index1++;
                index3++;
            }else{
                index2++;
                index3--;
                push[index3] = -1;
            }
        }
        if(index3 == 1)
            return true;
        else return false;
    }

    @Test
    public void test(){
        int[] pushed = new int[]{1,2,3,4,5};
//        int[] poped = new int[]{4,5,3,2,1};
        int[] poped = new int[]{4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, poped));
    }
}
