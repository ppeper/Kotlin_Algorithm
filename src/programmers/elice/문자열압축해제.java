package programmers.elice;

import java.util.*;
import java.io.*;

class 문자열압축해제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == ')') {
                StringBuilder str = new StringBuilder();
                while (!stack.isEmpty()) {
                    String c1 = stack.pop();
                    if (c1.equals("(")) {
                        // 다음 문자의 숫자와 곱
                        int count = Integer.parseInt(stack.pop());
                        String result = (str.toString()).repeat(count);
                        stack.push(result);
                        break;
                    } else {
                        str.append(c1);
                    }
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += String.valueOf(stack.pop()).length();
        }
        System.out.println(answer);
    }
}
