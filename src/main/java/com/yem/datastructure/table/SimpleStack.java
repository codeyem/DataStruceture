package com.yem.datastructure.table;

/**
 * @Author ym
 * @Date 2022/10/3 20:48
 * @Description:yem
 */
public class SimpleStack<T> {
    public T top;
    private Object[] array;
    private int index;
    public SimpleStack(int size){
        this.array = new Object[size];
    }
    public boolean push(T t){
        if(index > array.length){
            return false;
        }
        array[index] = t;
        index++;
        return true;
    }
    public T pop(){
        if(index > 0){
            Object o = array[index-1];
            array[index - 1] = null;
            index--;
           return (T)o;
        }
        return null;
    }
    public void printStack(){
        for(int i = 0; i < index; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        SimpleStack<String> simpleStack = new SimpleStack<String>(7);
        simpleStack.push("a");
        simpleStack.push("c");
        simpleStack.push("2");
        simpleStack.pop();
        simpleStack.printStack();
    }
}
