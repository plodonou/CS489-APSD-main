package edu.miu.ArrayFlattener.util;

public class ArrayFlattener {
    public int[] flattenArray(int[][] input) {
        if (input == null) {
            return new int[0];
        }

        int totalLength = 0;
        for (int[] arr : input) {
            totalLength += arr.length;
        }

        int[] result = new int[totalLength];
        int index = 0;

        for (int[] arr : input) {
            for (int num : arr) {
                result[index] = num;
                index++;
            }
        }

        return result;
    }
}
