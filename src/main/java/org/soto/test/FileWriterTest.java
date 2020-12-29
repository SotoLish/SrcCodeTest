package org.soto.test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter测试
 * @author: liuqixin
 * @date: 2020/12/14 14:25
 */
public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("d:\\1\\cache\\test.json");
        fileWriter.write("测试json");
        fileWriter.flush();
        fileWriter.close();
    }
}
