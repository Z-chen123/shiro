package com.mmall.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

    private static final String[] strArr ={"2,石浩密,60","4,杨超,98","3,刘瑞,95","5,于涛,91","6,程普,85","1,梁艳,75"};

    private static List<String> list= new ArrayList<>();

    public static List<String> transfer(){
       return list= Arrays.asList(strArr);
    }

    public static void main(String[] args) {
        transfer();
        //转成对象集合
        ArrayList<User> users = new ArrayList<>();
        for(String str : list){
            User user = new User();
            String[] split = str.split(",");
            user.setId(Integer.valueOf(split[0]));
            user.setName(split[1]);
            user.setScore(Integer.valueOf(split[2]));
            users.add(user);
        }
//        users.forEach(user -> System.out.println("user = " + user));
        //取出成绩最高的学号
        int max=users.get(0).getScore();
        for(int i =0;i<users.size();i++){
            if(users.get(i).getScore()>max){
                max=users.get(i).getScore();
            }
        }
        for(User u:users){
            if(max==u.getScore()){
                System.out.println(u.getId().toString());
            }
        }
    }
}
