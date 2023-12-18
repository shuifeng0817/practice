package com.itheima;

public class GirlFriend {
    private String name;
    private  int age;
    private  String gender;

    public void setName(String name){
       this.name=name;
    }

    public String  getName(){
        return name;
    }

    public void setAge(int age){
        if(age>=18&&age<=50){
           this.age =age;
        }else{
            System.out.println("数据非法");
        }
    }

    public  int getAge(){
        return age;
    }

    public void setGender(String gender){
        if (gender.equals("女")){
            this.gender =gender;
        }else{
            System.out.println("输入非法");
        }
    }
    public String getGender(){
        return gender;
    }
}
