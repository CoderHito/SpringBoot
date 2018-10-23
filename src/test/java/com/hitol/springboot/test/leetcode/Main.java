package com.hitol.springboot.test.leetcode;


import antlr.collections.impl.LList;

import java.util.HashMap;
import java.util.Map;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//class Solution {
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode tmp = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return tmp;
//    }
//}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmpNode = head;
            tmpNode.next = res;
            res = tmpNode;
            head = head.next;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

//        ListNode listNode = createList();
////
////        while (listNode != null){
////            System.out.println(listNode.val);
////            listNode = listNode.next;
////        }
//
////        createListDesc();
//        System.out.println("reversetList");
//        ListNode res = reversetList2(listNode);
//        while (res != null){
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(adjective());
        calculation();

    }

    /**
     * 在操作的时候是通过两个栈来实现的，一个用来保存操作的数据，一个用来保存运算符。
     * 从左到右遍历表达式，当遇到数字的时候就把数字压入到数字的栈内，
     * 当遇到运算符a的时候就与运算符栈的栈顶元素b进行比较，
     * 如果运算符栈顶元素b的优先级比a低，就将当前操作入栈；
     * 如果栈顶运算符b的优先级大于等于a，则从数字栈中取出两个数字进行对应的操作，并将操作结果压入到数字栈内。
     */
    private static void calculation() {

        //操作符等级
        Map<Character, Integer> signMap = new HashMap();
        signMap.put('+', 1);
        signMap.put('-', 1);
        signMap.put('*', 2);
        signMap.put('/', 2);

        String s = "3+5*8-6";
        LList num = new LList();
        LList sign = new LList();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //是操作符
            if (signMap.containsKey(ch)) {
                if (sign != null && sign.length() == 0) {
                    sign.push(ch);
                } else {
                    //如果运算符栈顶元素b的优先级比a低，就将当前操作入栈；
                    if (signMap.get(sign.top()) < signMap.get(ch)) {
                        sign.push(ch);
                    } else {
                        //如果栈顶运算符b的优先级大于等于a，则从数字栈中取出两个数字进行运算符栈顶对应的操作，并将操作结果压入到数字栈内。
                        operate(num, (char) sign.pop());
                        sign.push(ch);
                    }
                }
            } else {
                num.push(new Integer(String.valueOf(ch)));
            }
        }
        while (sign.length() != 0 && num.length() > 1) {
            operate(num, (char) sign.pop());
        }
        System.out.println(num.top());

    }

    private static void operate(LList num, char ch) {
        Integer b = (Integer) num.pop();
        Integer a = (Integer) num.pop();
        switch (ch) {
            case '+':
                num.push(a + b);
                break;
            case '-':
                num.push(a - b);
                break;
            case '*':
                num.push(a * b);
                break;
            case '/':
                num.push(a / b);
                break;
        }
    }


    private static boolean adjective() {
        String[] str = new String[]{"{", "}", "{", "[", "(", ")", "]", "(", ")", "}"};
        LList stack = new LList();
        for (String s : str) {
            if (s.equals("(") || s.equals("[") || s.equals("{")) {
                stack.push(s);
            } else {
                String top = (String) stack.top();
                stack.pop();
                if (s.equals(")") && !"(".equals(top)) {
                    return false;
                } else if (s.equals("]") && !"[".equals(top)) {
                    return false;
                } else if (s.equals("}") && !"{".equals(top)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 链表反转--非递归方式
     */
    private static ListNode reversetList2(ListNode listNode) {
        ListNode prev = null;
        ListNode curr = listNode;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 链表反转--递归方式
     */
    private static ListNode reversetList(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            System.out.println(listNode.val);
            return listNode;
        }
        ListNode tmpNode = reversetList(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return tmpNode;
    }

    private static void printfListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    private static ListNode createListDesc() {
        ListNode tail = new ListNode(0);
        tail.next = null;
        ListNode head = tail;
        /**
         *  倒序链表
         */
        for (int i = 0; i < 10; i++) {
            ListNode tmpNode = new ListNode(i);
            tmpNode.next = head;
            head = tmpNode;
        }
        while (head != null && head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        return head;

    }

    private static ListNode createList() {
        ListNode head = new ListNode(0);
        ListNode res = head;
        /**
         * 正序链表
         */
        for (int i = 0; i < 10; i++) {
            ListNode tmp = new ListNode(i);
            tmp.next = null;
            head.next = tmp;
            head = tmp;
        }
//        res = res.next;
//        while (res != null && res.next != null) {
//            System.out.println(res.next.val);
//            res = res.next;
//        }
        return res.next;
    }
}
