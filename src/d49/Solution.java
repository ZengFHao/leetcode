package d49;

import org.junit.Test;

import java.util.*;

public class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> list1 = new ArrayList<>();
//        Map<String,List<String>> map = new HashMap<>();
//        for (String s : strs){
//            List<String> list = new ArrayList<>();
//            String key = s;
//            char[] chars = key.toCharArray();
//            Arrays.sort(chars);
//            key = String.copyValueOf(chars);
//            if(map.containsKey(key))
//                list = map.get(key);
//            list.add(s);
//            map.put(key , list);
//        }
//        Set<String> set = map.keySet();
//        for (String s : set){
//            List<String> list = map.get(s);
//            list1.addAll(Collections.singleton(list));
//        }
//        return list1;
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list1 = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for (String s : strs){
            String key = s;
            char[] chars = key.toCharArray();
            Arrays.sort(chars);
            key = String.copyValueOf(chars);
            map.put(key , s);
        }
//        Set<String> set = map.keySet();
//        for (String s : set){
//            List<String> list = new ArrayList<>();
////            Iterator iterator = new Collection().iterator();
//            list.add(map.get(s));
//            list1.addAll(Collections.singleton(list));
//        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            List<String> list = new ArrayList<>();
            String str = (String) iterator.next();
            for (Map.Entry m : map.entrySet()){
                if(m.getKey() == str){
                    list.add(map.get(str));
                }
            }
            list1.addAll(Collections.singleton(list));
        }
        return list1;
    }
    @Test
    public void test(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list= groupAnagrams(strs);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
//            for(Object j : i){
//                System.out.print(j+" ");
//            }
            System.out.println(list.get(i));
        }
    }
}
