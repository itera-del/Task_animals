package com.atliu.animal.service;
import com.atliu.animal.bean.Animal;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 刘芋池
 * @Description AnimalList为Animal对象的管理模块，内部用数组管理一组Animal对象，
 *  * 并提供相应的添加、修改、删除、遍历方法，供AniamlView调用
 * @create 2020/10/8 23:11
 */
public class AnimalList {
    private Animal[] animals;
    private int total =0;//记录动物的数量

    public AnimalList(int capacity){
        animals =new Animal[capacity];
    }
    public boolean addAnimal(Animal animal){
        if(total>= animals.length){
            return  false;//失败
        }
        animals[total++]=animal;
        return true;//成功
    }
    public boolean replaceAnimal(int index,Animal cust){
        if(index<0||index>=total){
            return false;
        }
        animals[index]=cust;
        return true;
    }
    public boolean deleteAnimal(int index){
        if(index<0||index>=total){
            return false;
        }
        for(int i=index;i<total-1;i++){
            animals[i]=animals[i+1];
        }
        animals[total-1]=null;
        total--;
        return true;
    }
    public Animal[] getAllAnimals(){
        Animal[] ani=new Animal[total];
        for(int i=0;i<total;i++){
            ani[i]=animals[i];
        }
        return ani;
    }
    public Animal getAniaml(int index){
        if(index<0||index>=total){
            return null;
        }
        return animals[index];
    }
    public int getTotal(){
        return total;
    }

    public Animal[] getAnimals() {
        return animals;
    }

//    public void sortAge(Animal[] animals1){
//        Arrays.sort(animals1);
//        System.out.println(Arrays.toString(animals1));
//    }
}


