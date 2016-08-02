package ru.sbt.bodya.cw3.collectionsMethodsUsage;

import java.util.Arrays;

public class ArraysUsage {

    public static void main(String[] args) {

        ArraysUsage test = new ArraysUsage();
        String[] arr = {"String 1", "String 4", "String 2", "String 3"};
        test.dumpArray(arr);
        Arrays.sort(arr);
        test.dumpArray(arr);
        int ind = Arrays.binarySearch(arr, "String 4");
        System.out.println("\nIndex of \"String 4\" = " + ind);
    }

    void dumpArray(String arr[]) {
        System.out.println();
        for (int cnt = 0; cnt < arr.length; cnt++) {
            System.out.println(arr[cnt]);
        }
    }
}