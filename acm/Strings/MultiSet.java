package Strings;

import java.util.*;

public class MultiSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<Integer> treeSet = new TreeSet<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int command, number, min;

        List<Integer> answer = new LinkedList<>();

        int n = scanner.nextInt();


        for (int i = 0; i < n; i++) {

            command = scanner.nextInt();

            if (command == 1) {

                number = scanner.nextInt();

                treeSet.add(number);

                if (!hashMap.containsKey(number)) {
                    hashMap.put(number,1);
                } else {
                    hashMap.put(number,hashMap.get(number) + 1);
                }

            } else if (command == 2) {

                min = treeSet.first();

                if (hashMap.get(min) == 1) {

                    treeSet.remove(min);

                }

                hashMap.put(min,hashMap.get(min) - 1);
                answer.add(min);

            }
        }

        for (Integer ans : answer) {
            System.out.println(ans);
        }


    }

}
