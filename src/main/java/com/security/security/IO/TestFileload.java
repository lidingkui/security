package com.security.security.IO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFileload {
    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    public static void listFile(File file) {
        if (file.isFile()) {
            if (file.length() > maxSize) {
                maxSize = file.length();
                maxFile = file;
            }
            if (file.length() != 0 && file.length() < minSize) {
                minSize = file.length();
                minFile = file;
            }
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file1 : files) {
                    listFile(file1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/lidingkui/Desktop/健康");
        listFile(file);
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());

    }
}


//  File f = new File("/Users/lidingkui/Desktop/健康");