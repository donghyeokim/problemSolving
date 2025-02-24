package LeetCode.medium;
import java.util.*;
public class P1711 {
    class Solution {
        public int countPairs(int[] deliciousness) {
            int mod= 1_000_000_007;
            int n=deliciousness.length;
            int count=0;
            Map<Integer,Integer> map=new HashMap<>();
            for(int num:deliciousness){
                for(int power=1;power<=(1<<21);power<<=1){
                    int complement=power-num;
                    count=(count+ map.getOrDefault(complement,0)) % mod;
                }
                map.put(num,map.getOrDefault(num,0)+1);
            }
            return count;
        }
    }
}
