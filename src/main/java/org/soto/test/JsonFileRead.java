package org.soto.test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * JSON文本文件读取
 *
 * @author: liuqixin
 * @date: 2020/12/22 10:46
 */
public class JsonFileRead {


    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d://cache//11.json"));) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
