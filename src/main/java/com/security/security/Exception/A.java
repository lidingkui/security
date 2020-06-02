package com.security.security.Exception;

public class A {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (0 == i % 2) {
                continue;
            }
            System.out.println(i);
        }
        double x = 99.99999;
//        a%b=a-(int)(a/b)*b
//        -7 % 2 = -7 - (int)(-7/2)* b = -7 + 6

    }
}
