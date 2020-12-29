package org.soto.test;

import java.io.File;

/**
 * 递归创建文件夹
 *
 * @author: liuqixin
 * @date: 2020/12/21 10:22
 */
public class RecurMkdir {

    public static void main(String[] args) {

        String path = "D:" + File.separator + "A" + File.separator + "B" + File.separator + "C";
//        String path = "D:" + File.separator + "A";
        mkdir(path);
//        System.out.println(path);


    }

    public static void mkdirs(String path) {
        String separator = "/|\\\\";
        String[] paths = path.split(separator);
        String rootPath = "";

        for (int i = 0; i < paths.length; i++) {
            rootPath += File.separator + paths[i];
            mkdir(rootPath);
        }
    }

    public static void mkdir(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
