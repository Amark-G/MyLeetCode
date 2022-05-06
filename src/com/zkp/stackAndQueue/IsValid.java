package com.zkp.stackAndQueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class IsValid {
    public static void main(String[] args){
        String str = "[()]";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        int len = s.length();
        if (len%2==1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '['||c == '{'){
                stack.push(c);
            }else {
                switch (c){
                    case ')':
                        if (stack.isEmpty()||stack.peek()!='('){
                            return false;
                        }else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.isEmpty()||stack.peek()!='['){
                            return false;
                        }else {
                            stack.pop();
                        }
                        break;
                    case '}':
                        if (stack.isEmpty()||stack.peek()!='{'){
                            return false;
                        }else {
                            stack.pop();
                        }
                        break;
                }
            }
        }
        return true;
    }
}
