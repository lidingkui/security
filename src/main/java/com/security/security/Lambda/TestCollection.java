package com.security.security.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestCollection {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heroes);


        HeroChecker c = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return h.hp > 100 && h.damage < 50;
            }
        };


        //使用 引用容器中的对象的方式来实现
        Collections.sort(heroes, TestCollection::compare);
        System.out.println("排序后的集合为:" + heroes);


        System.out.println("使用匿名类过滤");
        filter(heroes, c);
        System.out.println("使用Lambda表达式");
        filter(heroes, h -> h.hp > 100 && h.damage < 50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heroes, h -> TestLambda.testHero(h));
        System.out.println("直接引用静态方法");
        filter(heroes, TestLambda::testHero);
    }

    public static boolean testHero(Hero h) {
        return h.hp > 100 && h.damage < 50;
    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero)) {
                System.out.print(hero);
            }
        }
    }

    public static int compare(Hero h1, Hero h2) {
        return h1.hp > h2.hp ? 1 : -1;
    }
}
