package com.security.security.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");

        System.out.println("Lambda表达式：");
        filter(heros,h-> h.hp>100 && h.damage<50 );

        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");
        filter(heros,h-> h.matched() );

        System.out.println("引用容器中对象的方法 之过滤结果：");
        filter(heros, Hero::matched);

        //匿名类的正常写法
        HeroChecker checker = new HeroChecker() {
            @Override
            public  boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };


        // 把new HeroChcekcer，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };

        // 把return和{}去掉
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

        // 把 参数类型和圆括号去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

        // 把c4作为参数传递进去
        filter(heros, c4);

        // 直接把表达式传递进去
        filter(heros, h -> h.hp > 100 && h.damage < 50);

    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero)) {
                System.out.print(hero);
            }
        }
    }

    public static boolean testHero(Hero h) {
        return h.hp > 100 && h.damage < 50;
    }
}
