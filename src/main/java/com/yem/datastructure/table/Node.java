package com.yem.datastructure.table;

/**
 * @Author ym
 * @Date 2022/10/3 19:50
 * @Description:yem
 */
public class Node<T>{
    T data;
    Node<T> next;

    public Node(T t){
        this.data = t;
    }

    public Node(T t, Node<T> pre){
        this.data = t;
        this.next = pre;
    }
}
