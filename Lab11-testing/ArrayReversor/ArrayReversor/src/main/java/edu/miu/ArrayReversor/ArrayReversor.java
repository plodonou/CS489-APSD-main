package edu.miu.ArrayReversor;

import edu.miu.ArrayReversor.service.ArrayFlattenerService;

public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] input) {
        if (input == null) {
            return new int[0];
        }

        int[] flattenedArray = arrayFlattenerService.flattenArray(input);

        int length = flattenedArray.length;
        int[] reversedArray = new int[length];

        for (int i = 0; i < length; i++) {
            reversedArray[i] = flattenedArray[length - i - 1];
        }

        return reversedArray;
    }
}
