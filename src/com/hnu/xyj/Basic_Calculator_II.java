package com.hnu.xyj;

import java.util.Stack;

/**
 * Created by xyj on 15/7/8.
 * Implement a basic calculator to evaluate a simple expression string.
 * 该答案综合解答了basic calculator(||)
 */
public class Basic_Calculator_II {

    //保存符号的栈
    private Stack<Character> symbolStack = new Stack<Character>();
    //保存数值的栈
    private Stack<Integer> numberStack = new Stack<Integer>();

    public int calculate(String s) {

        if (s == null || s.length() == 0) return 0;

        char[] tokens = s.trim().toCharArray();
        for (int i = 0; i < tokens.length; i++) {

            char c = tokens[i];
            if (c == ' ') continue;
            else if (c <= '9' && c >= '0') {
                int result = 0;

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    //(tokens[i]-'0')ASC||码
                    result = result * 10 + (tokens[i]-'0');
                    i++;
                }
                i--;
                numberStack.push(result);
            }
            else if (c == '(')
                symbolStack.push(c);
            else if (c == ')') {
                if (!symbolStack.empty() && symbolStack.peek() != '(') {
                    numberStack.push(calculateValues(symbolStack.pop(), numberStack.pop(), numberStack.pop()));
                }
                //弹出‘（’
                symbolStack.pop();
            } else {

                //符号栈中不为空并且栈顶不是左括号并且栈顶符号优先级大于c
                while (!symbolStack.isEmpty() && isLeftBracket(symbolStack.peek())&&isPrior(symbolStack.peek(),c)) {
                    numberStack.push(calculateValues(symbolStack.pop(), numberStack.pop(), numberStack.pop()));
                }
                symbolStack.push(c);
            }
        }

        while (!symbolStack.isEmpty()) {
            numberStack.push(calculateValues(symbolStack.pop(), numberStack.pop(), numberStack.pop()));
        }
        return numberStack.pop();
    }


    /**
     * 判断符号优先级
     * @param symbol1 栈顶符号
     * @param symbol2 c
     * @return
     */
    public boolean isPrior(char symbol1,char symbol2){
        boolean result = true;
        if (symbol1=='*'||symbol1=='/')
            result = true;
        else if (symbol2=='*'||symbol2=='/')
            result=false;
        return result;
    }

    /**
     * 判断是否是左括号
     * @param symbol
     * @return
     */
    public static boolean isLeftBracket(char symbol) {
        return symbol == '(' ? false : true;
    }

    /**
     * 计算两个数运算后的值
     *
     * @param symbol
     * @param value1
     * @param value2
     * @return
     */
    public static int calculateValues(char symbol, int value1, int value2) {
        switch (symbol) {
            case '+':
                return value1 + value2;
            case '-':
                return value2 - value1;
            case '*':
                return value1*value2;
            case '/':
                return value2/value1;
        }
        return 0;
    }

}
