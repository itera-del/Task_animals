package com.atliu.animal.uti;

import java.util.Scanner;

/**
 * @author 刘芋池
 * @Description 工具类 将不同的功能功能封装为方法
 * @create 2020/10/8 23:04
 */

public class CMUtility {
    private static Scanner scanner=new Scanner(System.in);
    //用于界面菜单的选择，用户选择1，2，3，4，5，6
    public static  char readMenuSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'&&c!='6'){
                System.out.println("选择错误，请重新输入;");
            }else{
                break;
            }
        }
        return c;
    }
    //读取性别
    public static char readChar(){
        String str=readKeyBoard(1,false);
        return str.charAt(0);
    }
    //对读取性别的重写
    public static char readChar(char defaultValue){
        String str=readKeyBoard(1,true);//是空能否返回
        return (str.length()==0)?defaultValue:str.charAt(0);

    }
    //读年龄
    public static  int readInt(){
        int n;
        for(;;){
            String str=readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    public static int readInt(int defaultValue){
        int n;
        for(;;){
            String str=readKeyBoard(2,true);
            if(str.equals("")){
                return defaultValue;
            }
            try{
                n=Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    //读取长度不超过limit的字符串
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    //重写
    public static String readString(int limit,String defaultValue){
        String str=readKeyBoard(limit,true);
        return str.equals("")?defaultValue:str;
    }
    //用于确定的输入
    public static  char readConfirmSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
    private static String readKeyBoard(int limit,boolean blankReturn){
        String line ="";

        while(scanner.hasNextLine()){
            line=scanner.nextLine();
            if(line.length()==0){
                if(blankReturn){
                    return line;
                }else{
                    continue;
                }
            }
            if(line.length()<1||line.length()>limit){
                System.out.println("输入长度（不大于"+limit+")错误，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }
}