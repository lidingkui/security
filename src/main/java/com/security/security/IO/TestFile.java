package com.security.security.IO;

import java.io.File;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) {
        File f = new File("/Users/lidingkui/Desktop/健康卡");
        System.out.println("当前文件是：" + f);

        System.out.println("判断是否存在：" + f.exists());

        System.out.println("判断是否是文件夹" + f.isDirectory());

        //是否是文件（非文件夹）
        System.out.println("判断是否是文件："+f.isFile());

        //文件长度
        System.out.println("获取文件的长度："+f.length());

        //文件最后修改时间
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间："+d);
        //设置文件修改时间为1970.1.1 08:00:00
        f.setLastModified(0);

        //文件重命名
        File f2 =new File("/Users/lidingkui/Desktop/健康");
        f.renameTo(f2);
        System.out.println("把/Users/lidingkui/Desktop/健康卡 改名成了   /Users/lidingkui/Desktop/健康");

        System.out.println("注意： 需要在/Users/lidingkui/Desktop/健康卡,\r\n才可以看到对应的文件长度、修改时间等信息");
    }
}
