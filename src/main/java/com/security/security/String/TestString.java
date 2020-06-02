package com.security.security.String;

public class TestString {
    public static void main(String[] args) {
        String sentrnce = "     盖伦,在进行了连续8次击杀后,获得了 超神 的称号    ";
        //charAt(int index)获取指定位置的字符
        char c = sentrnce.charAt(0);
        System.out.println(c);

        // toCharArray()
        //获取对应的字符数组
        char[] charArray = sentrnce.toCharArray();
        System.out.println(charArray.length);


       // subString    截取子字符串
        String subString = sentrnce.substring(3);
        System.out.println(subString);

        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串
        //左闭右开
        String subString2 = sentrnce.substring(3, 5);
        System.out.println(subString2);


        //split
        //根据,进行分割，得到3个子字符串
        String subSentences[] = sentrnce.split(",");
        for (String sub : subSentences) {
            System.out.println("分隔后的结果为："+sub);
        }

        //去掉首尾空格
        System.out.println("去掉首尾空格后的字符串为："+sentrnce.trim());

    }
}
