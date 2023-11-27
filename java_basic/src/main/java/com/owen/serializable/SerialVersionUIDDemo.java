package com.owen.serializable;

import java.io.*;

/**
 * @author wenqiang
 * @date 2023/08/08 13:25
 **/
public class SerialVersionUIDDemo {
    public static void main(String[] args) {
        // 创建Person对象
//        Person person = new Person("John Doe", 30);

        // 序列化对象到文件
//        serialization(person,"bbb");

        // 从文件反序列化对象
        Person aaa = deserialization("bbb");
    }

    /**
     * 序列化对象到文件
     *
     * @param person
     */
    public static void serialization(Person person, String fileName) {
        // 序列化对象到文件
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Person对象已序列化到person.ser文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserialization(String fileName) {
        Person deserializedPerson = null;
        // 从文件反序列化对象
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("从person.ser文件反序列化得到的Person对象：" + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedPerson;
    }


}