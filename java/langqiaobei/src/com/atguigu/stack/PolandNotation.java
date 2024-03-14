package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀"+infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀"+parseSuffixExpressionList);


        System.out.printf("expression=%d",calculate(parseSuffixExpressionList));

        /*//先定义一个逆波兰表达式
        String suffixExpression = "3 4 + 5 * 6 -";

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList" + rpnList);


        int res = calculate(rpnList);
        System.out.println("计算的结果是=" + res);
*/
    }


    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();//符号站
        List<String> s2 = new ArrayList<>();//存储中间结果

        //遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出s1栈，消除小括号
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }


    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;//这是一个指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放入c中
        do {
            //如果c是一个非数字，我需要加入到ls
            if (((c = s.charAt(i)) < 48) || ((c = s.charAt(i)) > 57)) {
                ls.add("" + c);
                i++;
            } else {
                str = "";//现将str 置成""
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);

            }

        } while (i < s.length());
        return ls;
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();

        for (String item : ls) {
            if (item.matches("\\d+")) {//匹配的是多位数
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}





