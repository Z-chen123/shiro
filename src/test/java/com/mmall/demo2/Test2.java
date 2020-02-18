package com.mmall.demo2;

import java.util.*;

public class Test2 {
    private static final String[] strArr ={"2,石浩密,60","4,杨超,98","3,刘瑞,95","5,于涛,91","6,程普,85","1,梁艳,75"};

    //private static List<String> list= new ArrayList<>();
        private static List <String> list = Arrays.asList(strArr);
   /* public static List<String> transfer(){
        return list= Arrays.asList(strArr);
    }*/

    public static void main(String[] args) {
        //transfer();
        Map<String, Integer> map = new HashMap<>();
        for(String str : list){
            String[] split = str.split(",");
            map.put(new StringBuilder().append(split[0]).append(split[1]).toString(),Integer.valueOf(split[2]));
        }
        int max = map.entrySet().iterator().next().getValue();

        for(Map.Entry<String,Integer> m : map.entrySet()){
            if(max<m.getValue()){
                max = m.getValue();
            }
        }

        for(String key :map.keySet()){
            if(max==map.get(key)){
                String xuehao = key.substring(0, 1);
                System.out.println(xuehao);
            }
        }
    }
}
