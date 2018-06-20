package com.rain.mymvpdemo.test;

/**
 * Author:rain
 * Date:2018/6/20 11:23
 * Description:
 * 参见:https://blog.csdn.net/u011974987/article/details/60765721
 * 1.使用泛型定义x y类型
 * 2.泛型方法的使用
 * 3.note 泛型方法中的类型参数与泛型类参数没有联系
 */
class PointB<T,Y>{
    private T pointX;
    private Y pointY;

    public T getPointX() {
        return pointX;
    }

    public void setPointX(T pointX) {
        this.pointX = pointX;
    }

    public Y getPointY() {
        return pointY;
    }

    public void setPointY(Y pointY) {
        this.pointY = pointY;
    }

    // 泛型方法类型参数写在修饰符之后，返回值类型之前
    // 使用泛型方法时不必指明参数类型，编译器会根据传递的参数自动查找出具体的类型。
    public static <V,M> void printPoint(V x,M y){
        V m = x;
        M n = y;
        System.out.println("This point is：" + m + ", " + n);
    }
}
