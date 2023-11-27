package com.owen.collection.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wenqiang
 * @date 2023/11/01 11:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private String name;

    private int age;

    /**
     * this 比 obj
     *
     * 升序：< -1 ; = 0 ; > 1
     * 降序：< 1 ; = 0 ; > -1
     * 倒序：直接返回-1
     * 不改变顺序：返回0或者1
     *
     * @param  obj object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student obj) {
        int flag = this.name.compareTo(obj.name);
        if (flag == 0) {
            return  obj.age - this.age;
        }
        return flag;
    }
}