package org.soto.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileWriter测试
 *
 * @author: liuqixin
 * @date: 2020/12/14 14:25
 */
public class FileWriterTest {

    public static void main(String[] args) throws Exception {
        String filename = "d:\\cache\\test.json";
        String content = "1测试json2";
        fileWrite(filename, content);
//        pringWrite(filename,"重写测试json");
    }

    public static void fileWrite(String filename, String content) throws Exception {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void pringWrite(String filename, String content) throws Exception {
        //写入的txt文档的路径
        PrintWriter pw = new PrintWriter(filename);
        //写入的内容
        pw.write(content);
        pw.flush();
        pw.close();
    }
}
