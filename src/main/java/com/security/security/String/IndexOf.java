package com.security.security.String;

public class IndexOf {
    public static void main(String[] args) {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";

        System.out.println(sentence.indexOf('8'));

        System.out.println(sentence.indexOf("超神"));

        System.out.println(sentence.indexOf("了"));

        // fromIndex 表示从几号索引开始查找
        System.out.println(sentence.indexOf(",",5));

        System.out.println(sentence.indexOf("击杀"));

    }
}
