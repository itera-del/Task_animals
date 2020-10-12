package com.atliu.animal.bean;

/**
 * @author 刘芋池
 * @Description Animal为实体对象，用于封装客户信息
 * @create 2020/10/8 23:08
 */
public class Animal implements Comparable{
    private String species;
    private String gender;
    public int age;

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Animal(){

    }

    public Animal(String species, String gender, int age) {
        this.species = species;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Animal){
            Animal animal=(Animal)o;
            if(this.age>animal.age){
                return 1;
            }else if(this.age<animal.age){
                return  -1;
            }else{
                return 0;
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
