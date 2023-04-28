package LongestSubstring;

import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        final int len=s.length();
        int left=0;
        int right=0;
        int maxSize=0;
        HashSet<Character> hashSet=new HashSet<>();
        while(right<len){
            if(!hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right));
                right++;
                maxSize=Math.max(maxSize,right-left);
            }else{
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxSize;
    }
}
