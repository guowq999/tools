package com.owen.collection.compare;

import java.util.Comparator;

/**
 * @author wenqiang
 * @date 2023/11/01 13:58
 **/
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int flag = o1.getName().compareTo(o2.getName());
        if (flag == 0) {
            return o1.getAge() - o2.getAge();
        }
        return flag;
    }
}