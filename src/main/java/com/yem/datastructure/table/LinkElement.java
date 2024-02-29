package com.yem.datastructure.table;

/**
 * @Author ym
 * @Date 2022/10/2 20:00
 * @Description:yem
 * 单链表
 */
public class LinkElement<T> {
    private Node<T> head;
    private int size;

    public boolean addHead(T t){
        if(size == 0){
            Node<T> node = new Node<T>(t);
            head = node;
            size++;
        }else {
            //将头节点
            Node<T> node = new Node<T>(t);
            node.next = head;
            head = node;
            size++;
        }
        return true;
    }

    public boolean add(T t){
        if(size == 0){
            Node<T> node = new Node<T>(t);
            head = node;
            size++;
        }else {
            Node node = new Node(t);
            node.next = head;
            head = node;
            size++;
        }
        return true;
    }

    public boolean addIndex(T t, int index){
        if(index < 0 || index > size){
            System.out.println("越界了");
            return false;
        }
        if(index == 0){
            Node<T> node = new Node<T>(t);
            head = node;
            size++;
        }else {
            Node end = head;
            for(int i = 1; i < index - 1; i++){
                end = end.next;
            }
            Node<T> node = new Node<T>(t);
            node.next = end.next;
            end.next = node;
            size++;
        }
        return true;
    }

    public boolean delete(int index){
        if(index < 1 || index > size){
            return false;
        }
        if(index == 1){
            head = head.next;
        }
        Node end = head;
        for(int i = 1; i < index - 1; i ++){
            end = end.next;
        }
        end.next = end.next.next;
        size--;
        return true;
    }

    public String toString(){
        return "";
    }
    public static void main(String[] args) {
        LinkElement<Integer> linkElement = new LinkElement<>();
        linkElement.add(1);
        linkElement.add(2);
        linkElement.add(3);
        linkElement.add(4);
        linkElement.addIndex(0,3);
        linkElement.delete(2);
    }
}

