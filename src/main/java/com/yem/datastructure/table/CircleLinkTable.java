package com.yem.datastructure.table;

/**
 * @Author ym
 * @Date 2022/10/3 19:52
 * @Description:yem
 * 循环链表
 */
public class CircleLinkTable<T> {
    private int size;
    private CircleNode<T> end;

    public boolean add(T t){
        if(size == 0){
            CircleNode<T> circleNode = new CircleNode<T>(t);
            end = circleNode;
            circleNode.next = circleNode;
            size++;
        }else {
            CircleNode<T> circleNode = new CircleNode<T>(t);
            circleNode.next = end.next;
            end.next = circleNode;
            end = circleNode;
            size++;
        }
        return true;
    }

    public boolean delete(int index){
        if(index < 0 || index > size){
            return false;
        }
        CircleNode<T> e = end;
        for(int i = 0; i < index; i++){
            e = end.next;
        }
        e.next = e.next.next;
        size--;
        return true;
    }
    public static void main(String[] args) {
        CircleLinkTable<Integer> linkTable = new CircleLinkTable<Integer>();
        linkTable.add(1);
        linkTable.add(2);
        linkTable.add(3);
        linkTable.delete(2);
    }
}
class CircleNode<T>{
    T data;
    CircleNode<T> next;
    public CircleNode(T t){
        this.data = t;
    }
    public CircleNode(T t, CircleNode<T> next){
        this.next = next;
    }
}
