package com.yem.datastructure.stack;

import java.util.Stack;

/**
 * @Author ym
 * @Date 2024/3/7 22:56
 * @Description:y
 * 逆波兰计算
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class ReversePolish {
    public static void main(String[] args) {
        int caculate = caculate(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(caculate);
    }

    public static int caculate(String[] tokens){
        if(tokens.length <= 0){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for(String item : tokens){
            if("+".equals(item)){
                int first =  Integer.valueOf(stack.pop());
                int second = Integer.valueOf(stack.pop());
                int result = first + second;
                stack.push(String.valueOf(result));
                continue;
            }

            if("-".equals(item)){
                int first =  Integer.valueOf(stack.pop());
                int second = Integer.valueOf(stack.pop());
                int result = first - second;
                stack.push(String.valueOf(result));
                continue;
            }

            if("*".equals(item)){
                int first =  Integer.valueOf(stack.pop());
                int second = Integer.valueOf(stack.pop());
                int result = first * second;
                stack.push(String.valueOf(result));
                continue;
            }

            if("/".equals(item)){
                int first =  Integer.valueOf(stack.pop());
                int second = Integer.valueOf(stack.pop());
                int result = second / first;
                stack.push(String.valueOf(result));
                continue;
            }
            stack.push(item);
        }
        return Integer.valueOf(stack.pop());
    }

    /*
     * @description:中缀表达式转后缀表达式
     * 　　1、从左至右扫描一中缀表达式。
     * 　　2、若读取的是操作数，则判断该操作数的类型，并将该操作数存入操作数堆栈
     * 　　3、若读取的是运算符
     * 　　　　(1) 该运算符为左括号"("，则直接存入运算符堆栈。
     * 　　　　(2) 该运算符为右括号")"，则输出运算符堆栈中的运算符到操作数堆栈，直到遇到左括号为止。
     * 　　　　(3) 该运算符为非括号运算符：
     * 　　　　　　(a) 若运算符堆栈栈顶的运算符为括号（只可能是左括号），则直接存入运算符堆栈。
     * 　　　　　　(b) 若比运算符堆栈栈顶的运算符优先级高，则直接存入运算符堆栈。
     * 　　　　　　(c) 若比运算符堆栈栈顶的运算符优先级低或相等，则不断输出栈顶运算符到操作数堆栈，直到栈顶没有运算符的优先级大于或者等于当前预算符（即栈顶存在运算符的话，优先级一定是小于当前运算符），最后将当前运算符压入运算符堆栈。
     * 　　4、当表达式读取完成后运算符堆栈中尚有运算符时，则依序取出运算符到操作数堆栈，直到运算符堆栈为空。
     **/
}

