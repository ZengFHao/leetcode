package GroupAnagrams;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list1=new ArrayList<>();
//        List<String> list2=new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String temp=str;
            char[] s1 = temp.toCharArray();
            Arrays.sort(s1);
            /**
             * toString方法是将数组的首地址直接给字符串
             * 而不是将字符数组的值拼接之后给字符串
             * 所以应当采用copyValueOf方法
             */
            //String s=s1.toString();
            String s = String.copyValueOf(s1);
            //System.out.println(s);
            //System.out.println(s1);
            //List<String> list=map.getOrDefault(s , new ArrayList<String>());
            List<String> list = new ArrayList<>();
            if(map.containsKey(s)){
                for(Map.Entry entry : map.entrySet()){
                    /**
                     * ==判断的是两个字符串的地址是否一样
                     * 如果判断两个字符串字面量是否相同
                     * 应该用String中重写的equal方法
                     */
                    if(entry.getKey().equals(s)){
                        String subs = entry.getValue().toString();
                        subs = subs.substring(1,subs.length()-1);
                        list.add(subs);
                    }
                }
            }
            list.add("\"" +str +"\"");

            map.put(s,list);
        }
        for(Map.Entry<String, List<String>> i : map.entrySet()){
            List<String> list2=new ArrayList<>();
            int lenth=i.getValue().toString().length();
            list2.add(i.getValue().toString().substring(1,lenth-1));
            list1.addAll(Collections.singleton(list2));
            //list2.clear();
        }
        return list1;
    }
    @Test
    public void test(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list= groupAnagrams(strs);
        int num=123;
        String s = num+"";
        System.out.println(s);
        for(int i=0;i<list.size();i++){
//            for(Object j : i){
//                System.out.print(j+" ");
//            }
            System.out.println(list.get(i));
        }
    }
}
