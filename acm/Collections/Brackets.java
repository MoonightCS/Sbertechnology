package Strings;

import java.util.*;

public class Brackets {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int numberOpen = 0, numberClosed = 0;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {

                stack.push(i + 1);

            } else if (arr[i] == ')') {

                numberOpen = stack.pop();
                numberClosed = i + 1;
                treeMap.put(numberOpen, numberClosed);

            }
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {

            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());

        }

    }

}
