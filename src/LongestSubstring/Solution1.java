package LongestSubstring;

import java.util.HashSet;

//暴力算法
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int maxSize=1;
        int size=1;
        HashSet<Character> hashSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hashSet.add(s.charAt(i));
            for (int j=i+1;j<s.length();j++){
                Boolean flag=true;
                for(Character c:hashSet){
                    if(c==s.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    size++;
                    hashSet.add(s.charAt(j));
                    if(size>maxSize){
                        maxSize=size;
                    }
                }else {
                    hashSet.remove(s.charAt(i));
                    //size--;
                    //i=j;
//                    if(s.charAt(i)!=s.charAt(j)){
//                        size=1;
//                    }else {
//                        size--;
//                    }
                    hashSet.clear();
                    size=1;
                    break;
                }
            }
        }
        return maxSize;
    }
}
