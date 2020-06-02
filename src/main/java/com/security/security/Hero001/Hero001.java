package com.security.security.Hero001;

public class Hero001 {
    public String name;
    public float hp;
    public int damage;

    public Hero001() {
    }

    //定义一个回血的方法
    public synchronized void recover() {
        if (hp >= 1000) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    //定义一个减血的方法
    public synchronized void hurt() {
        if (hp == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }


    public void attackHero(Hero001 h) {
        h.hp -= damage;
        System.out.printf("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead()) {
            System.out.println(h.name + "死了");
        }
    }

    private boolean isDead() {
        return 0 >= hp ? true : false;
    }
}
