package FindSubstring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        if(s.length()<words[0].length()){
            return list;
        }

        final int len=words[0].length();
        int left=0;
        int start=0;
        int right= words.length*len;
        String str=s.substring(left,left+len);
        Boolean flag=false;
        Boolean []time=new Boolean[words.length];
        for (int i=0;i< words.length;i++){
            time[i]=false;
        }
        while(right<=s.length()){
            str=s.substring(left,left+len);
            flag=false;
            for(int i=0;i< words.length;i++){
                if(words[i].equals(str) && time[i]==false){
                    flag=true;
                    time[i]=true;
                    left+=len;
//                    right+=len;
                    break;
                }
                if(i== words.length-1 && flag==false){
                    start++;
                    left=start;
                    right++;
                    for(int j=0;j< words.length;j++){
                        time[j]=false;
                    }
                }
            }
            Boolean mask=true;
            for(int i=0;i< words.length && !flag;i++){
                if(time[i]==false){
                    mask=false;
                    break;
                }
            }
            if(mask && left==right){
                list.add(start);
                start++;
                left=start;
                right=left+words.length*len;
                for(int j=0;j< words.length;j++){
                    time[j]=false;
                }
            }

        }
        return list;
    }


    @Test
    public void test(){
        String  s = "barfoothefoobarman";// words = ["foo","bar"]
        //String[] words=new String[]{"foo","bar"};
        //s="foobarthefoobarman";
        //String[] words=new String[]{"bar","foo","the"};
        //s="wordgoodgoodgoodbestword";
        //String[] words=new String[]{"word","good","best","word"};
        s="wordgoodgoodgoodbestword";
        String[] words=new String[]{ "word","good","best","good"};
        //s="aaa";
        //String[] words=new String[]{ "a","a"};
        List<Integer> res =findSubstring(s,words);
        for (Integer i:res){
            System.out.println(i);
        }
    }
}


