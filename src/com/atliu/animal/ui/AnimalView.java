package com.atliu.animal.ui;

import com.atliu.animal.bean.Animal;
import com.atliu.animal.service.AnimalList;
import com.atliu.animal.uti.CMUtility;
import com.atliu.animal.service.myComparetor;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 刘芋池
 * @Description 为主模块，负责菜单的处理和显示用户操作
 * @create 2020/10/8 23:12
 */
public class AnimalView {
    private AnimalList animalList=new AnimalList(100);
    public  AnimalView(){
        Animal animal1=new Animal("猴类","男",22);
        animalList.addAnimal(animal1);
    }

    public void enterMainMenu(){
        boolean isFlag=true;
        while(isFlag) {
            System.out.println("\n----------动物信息管理系统----------");
            System.out.println("            1.添加动物");
            System.out.println("            2.修改动物");
            System.out.println("            3.删除动物");
            System.out.println("            4.动物列表");
            System.out.println("            5.动物排序");
            System.out.println("            6.退出\n");
            System.out.print("            请选择(1-6):");
            char menu=CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewAnimal();
                    break;
                case '2':
                    modifyAnimal();
                    break;
                case '3':
                    deleteAnimal();
                    break;
                case '4':
                    listAllAnimal();
                    break;
                case '5':
                    sortOfAnimal();
                    break;
                case '6':
                    System.out.println("退出");
                    System.out.println("确认是否退出(Y/N):");
                    char isExit=CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        isFlag=false;
                    }
                    break;
                default:
            }
        }
    }

    public void addNewAnimal(){
        System.out.println("添加动物的操作");
        System.out.println("--------------------------------添加动物------------------------------------");
        System.out.println("种类:");
        String speices=CMUtility.readString(10);
        System.out.println("性别：");
        String gender=CMUtility.readString(1);
        System.out.println("年龄");
        int age=CMUtility.readInt();
        //封装
        Animal animal=new Animal(speices,gender,age);
        boolean isSuccess=animalList.addAnimal(animal);
        if(isSuccess){
            System.out.println("--------------------------------添加完成---------------------------------------");
        }else{
            System.out.println("-------------------------------动物列表已满，添加失败-----------------------------------");
        }
    }

    public void modifyAnimal(){
        System.out.println("修改动物的操作");
        System.out.println("---------------------------------------修改动物----------------------------------");
        int number;
        Animal ani;
        for(;;) {
            System.out.println("请选择待修改动物编号(-1退出)");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            ani = animalList.getAniaml(number - 1);
            if (ani == null) {
                System.out.println("无法找到指定动物！");
            } else {
                //找到指定动物
                break;
            }
        }
        //修改动物信息
        System.out.println("种类("+ani.getSpecies()+"):");
        String speices=CMUtility.readString(10,ani.getSpecies());
        System.out.println("性别("+ani.getGender()+"):");
        String gender=CMUtility.readString(1,ani.getGender());
        System.out.println("年龄("+ani.getAge()+"):");
        int age=CMUtility.readInt(ani.getAge());

        Animal newanimal=new Animal(speices,gender,age);
        boolean isReplaced =animalList.replaceAnimal(number-1,newanimal);
        if(isReplaced) {
            System.out.println("----------------------------------修改完成------------------------------");
        }else {
            System.out.println("-----------------------------------修改失败------------------------------");
        }
    }

    public void deleteAnimal(){
        System.out.println("删除动物的操作");
        System.out.println("----------------------------------删除动物--------------------------------");
        int number;
        for(;;){
            System.out.println("请选择待删除动物的编号(-1退出)");
            number=CMUtility.readInt();

            if(number==-1){
                return;
            }
            Animal animal=animalList.getAniaml(number-1);
            if(animal==null){
                System.out.println("无法找到动物!");
            }else{
                break;
            }
        }
        //找到了指定用户
        System.out.println("是否要确定删除(Y/N):");
        char isDelete=CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean deleteSuccess=animalList.deleteAnimal(number-1);
            if(deleteSuccess){
                System.out.println("--------------------------------删除完成--------------------------");
            }else {
                System.out.println("-------------------------------删除失败-----------------------------");
            }
        }else{
            return ;
        }

    }

    public void listAllAnimal(){
        System.out.println("显示动物列表的操作");
        System.out.println("---------------------------------动物列表-----------------------------------");
        int total=animalList.getTotal();
        if(total==0){
            System.out.println("没有客户记录！");
        }else{
            System.out.println("编号\t种类\t性别\t年龄");
            Animal[] custs=animalList.getAllAnimals();
            for(int i=0;i< custs.length;i++){
                Animal cust=custs[i];
                System.out.println((i+1)+"\t"+cust.getSpecies()+"\t"+cust.getGender()+"\t"+cust.getAge());
            }
        }

        System.out.println("---------------------------------动物列表完成----------------------------------");

    }
    public void sortOfAnimal() {
        System.out.println("动物排序操作");
//        animalList.sortAge(animalList.getAnimals());
        myComparetor mc = new myComparetor();
        Arrays.sort(animalList.getAnimals(),mc);
        System.out.println(Arrays.toString(animalList.getAnimals()));
    }
    public static void main(String[] args) {
        AnimalView view=new AnimalView();
        view.enterMainMenu();
    }


}
