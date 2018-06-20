package com.rain.mymvpdemo.test;

/**
 * Author:rain
 * Date:2018/6/20 11:15
 * Description:
 * 泛型传参练习，相比于object类型优势
 * 保证类型安全
 */
public class GenericityDemo {

    public static void main(String[] args) {
        PointA pointA = new PointA();
        pointA.setPointX(10);
        pointA.setPointY(20);
        System.out.println("PointX:" + pointA.getPointX() + "PointY:" + pointA.getPointY());
        pointA.setPointX(10.11);
        pointA.setPointY("y值为20.22");
        System.out.println("PointX:" + pointA.getPointX() + "PointY:" + pointA.getPointY());

        // 如果在使用泛型时不指定类型，那么泛型类型会转为Objec类型，和不使用泛型没区别
        PointB<Integer, String> pointB = new PointB<>();
        pointB.setPointX(10);
        pointB.setPointY("y值为20.22");
        System.out.println("PointX:" + pointB.getPointX() + "PointY:" + pointB.getPointY());

        // 编译器会根据传入值类型自动添加类型
        PointB.printPoint("这是point吗？", 20.22);

        Integer max = getMax(new Integer[]{1, 3, 8, 2, 0});
        System.out.println("max:" + max);

    }

    // 求一个继承、实现Number接口类型数组中的最大值
    // 限制泛型的可用类型
    private static <T extends Number> T getMax(T array[]) {

        T max = array[0];
        for (T element :
                array) {
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
}
