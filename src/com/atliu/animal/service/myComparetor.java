package com.atliu.animal.service;

import com.atliu.animal.bean.Animal;

import java.util.Comparator;

/**
 * @author 刘芋池
 * @Description
 * @create 2020/10/9 22:53
 */

public class myComparetor implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Animal ani1=(Animal) o1;
        Animal ani2=(Animal) o2;
        return Double.compare(ani1.getAge(),ani2.getAge());
    }
}
