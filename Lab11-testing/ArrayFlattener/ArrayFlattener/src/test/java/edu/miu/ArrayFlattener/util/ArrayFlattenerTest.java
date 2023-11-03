package edu.miu.ArrayFlattener.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {

    private ArrayFlattener flattener;
    private int[][] input;

    @BeforeEach
    void setUp() {
        flattener = new ArrayFlattener();
        input = new int[][]{{1, 3}, {0}, {4, 5, 9}};
    }

    @AfterEach
    void tearDown() {
        flattener = null;
        input = null;
    }

    @Test
    public void testFlattenArrayWithLegitInput() {
        ArrayFlattener flattener = new ArrayFlattener();
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] result = flattener.flattenArray(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        ArrayFlattener flattener = new ArrayFlattener();
        int[][] input = null;
        int[] expected = {};
        int[] result = flattener.flattenArray(input);
        assertArrayEquals(expected, result);
    }
}