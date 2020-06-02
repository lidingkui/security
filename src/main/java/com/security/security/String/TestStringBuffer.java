package com.security.security.String;

public class TestStringBuffer {
    public static void main(String[] args) {
        String str1 = "let there";

        StringBuffer sb = new StringBuffer(str1);
        sb.append(" be light");
        System.out.println(sb);

        //delete 方法也是左闭右开  从0 到 5 但不包括5   取 0-4之间的数字
        sb.delete(0, 5);
        System.out.println(sb);


        sb.insert(0, "there ");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
    }
}
