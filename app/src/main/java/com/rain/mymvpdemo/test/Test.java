package com.rain.mymvpdemo.test;

/**
 * Author:rain
 * Date:2018/6/20 10:06
 * Description:
 * 仅仅用于代码测试
 * 1.测试静态代码块、构造代码块、构造函数执行顺序
 * 2.静态内部类饿汉式创建单例
 *
 */
public class Test {
    {
        System.out.println("构造代码块1");
    }
    private Test() {
        System.out.println("构造函数");
    }

    {
        System.out.println("构造代码块2");
    }

    private static class LazyHolder {
        static {
            System.out.println("静态代码块2");
        }
        private static final Test instance = new Test();
    }

    static {
        System.out.println("静态代码块1");
    }

    public static Test getInstance() {
        return LazyHolder.instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().toString());
        System.out.println(getInstance().toString());
    }
}
