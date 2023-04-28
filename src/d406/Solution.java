package d406;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] ret = new int[people.length][people[0].length];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0])
                    return -(o2[1] - o1[1]);
                else
                    return  o2[0] - o1[0];
            }
        });
        int len = 0;
        int index = 0;
        for(int i = 0; i < people.length; i++){
            index = len;
            if(len <= people[i][1]){
                ret[len][0] = people[i][0];
                ret[len][1] = people[i][1];
                len++;
            }else{
                for(int j = len; j > people[i][1]; j--){
                    ret[j][0] = ret[j - 1][0];
                    ret[j][1] = ret[j - 1][1];
                    index--;
                }
                ret[index][0] = people[i][0];
                ret[index][1] = people[i][1];
                len++;
            }
        }
        ret = aaa(people);
        return ret;
    }
    int[][] aaa(int[][] people){
        List<int []> list = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            if(people[i][1] == 0){
                list.add(people[i]);
            }else{
                list.add(people[i][1],people[i]);
            }
        }
        for(int i = 0; i <list.size(); i++){
            System.out.println(list.get(i));
        }
        return  list.toArray(new int[people.length][]);
    }


    @Test
    public void test(){
        //int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] people = new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        int[][] queue = reconstructQueue(people);
        for(int i = 0; i < queue.length; i++){
            for (int j = 0; j < queue[i].length; j++){
                System.out.print(queue[i][j]);
            }
            System.out.print(" ");
        }
    }

}
