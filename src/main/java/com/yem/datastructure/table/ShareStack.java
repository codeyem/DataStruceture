package com.yem.datastructure.table;

import java.util.Objects;

/**
 * @Author ym
 * @Date 2022/10/3 21:22
 * @Description:双栈共享数据
 */
public class ShareStack<T> {
    private int bottomStackIndex = -1;
    private int topStackIndex;
    private Object[] arary;

    public ShareStack(int size){
        this.arary = new Object[size];
        topStackIndex = size;
    }

    public boolean push(int type, T t){
        if(bottomStackIndex + 1 == topStackIndex){
            System.out.println("满了");
            return false;
        }
        if(type == 1){
            //像下面栈存储
            bottomStackIndex++;
            arary[bottomStackIndex] = t;
        }else {
            topStackIndex--;
            arary[topStackIndex] = t;
        }
        return true;
    }

    public void print(){
        for(int i = 0; i < arary.length; i++){
            if(!Objects.isNull(arary[i])){
                System.out.printf(arary[i].toString());
            }
            System.out.printf(",");
        }
    }
    public static void main(String[] args) {
        ShareStack<String> shareStack = new ShareStack<>(10);
        shareStack.push(1,"@");
        shareStack.push(2,"vvv");
        shareStack.push(1,"gasd");
        shareStack.push(1,"weoi");
        shareStack.push(2,"88");
        shareStack.print();
    }
}
