package com.itmuch.cloud.study.controller;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.util.*;

public class com implements Comparable<com> {
private int id;
private String name;

    public com(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(com o) {
       // return 0;
        return new CompareToBuilder().append(id,o.getId()).toComparison();
    }

    public static void main(String[] args) {
       // Vector<User> users=new Vector<>();
        List<com> users=new ArrayList<>();
        users.add(new com(23,"电饭锅"));
        users.add(new com(3,"电饭锅"));
        users.add(new com(263,"电饭锅"));
        users.add(new com(4,"电饭锅"));
        Collections.sort(users);
        for (com user:users ){
            System.out.println(user.getId());
     }

      Class s=UserController.class;
       // s.getConstructors().

     List<Integer> integerList=new Stack<>();
        integerList.add(3);
        integerList.add(4);
        integerList.add(56);
        integerList.size();
     final Vector<String> list=new Vector<>();
        for(int i=0;i<10000;i++){
            list.add("火车票:"+i);
        }

        //退票
        Thread returnThread=new Thread(){
            public void run(){
                while (true){
                    list.add("车票："+new Random().nextInt());
                }
            }
        };
        //售票
        Thread shouThread=new Thread(){
            public void run(){
                for (String tiket:list) {
                    list.remove(tiket);
                }
            }
        };

        //启动退票线程
        returnThread.start();
        //启动售票线程
        shouThread.start();
    }
}
