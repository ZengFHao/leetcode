package d899;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String orderlyQueue(String s, int k) {
        if(k != 1){
            char[] chars = s.toCharArray();
            Arrays.sort(chars,0,s.length());
            return String.copyValueOf(chars);
        }else{
            List<String> list = new ArrayList<>();
            for(int i = 0;i < s.length();i++){
                String s1 = s.substring(0,i);
                String s2 = s.substring(i,s.length());
                list.add(s2 + s1);
            }
            return Collections.min(list);
        }
    }

    @Test
    public void test(){
        String s1 = "cba";
        System.out.println(orderlyQueue(s1, 1));
        String s2 = "baaca";
        System.out.println(orderlyQueue(s2, 3));
    }
}
