package com.owen.serializable;

import java.io.*;

/**
 * @author wenqiang
 * @date 2023/08/08 10:14
 **/
public class SerializationDemo {
    public static void main(String[] args) {
        // 创建Person对象
        Person person = new Person("John Doe", 30);

        // 序列化对象到文件
        try {
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Person对象已序列化到person.ser文件");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从文件反序列化对象
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("从person.ser文件反序列化得到的Person对象：" + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}