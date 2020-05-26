package com.security.security.多线程;

import lombok.Data;

@Data
public class Hero {
    String name;
    float hp;
    int deamge;

    public void attackHero(Hero h) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        h.hp -= deamge;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if (h.isDead()) {
            System.out.println(h.name+"已经死了");
        }
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
