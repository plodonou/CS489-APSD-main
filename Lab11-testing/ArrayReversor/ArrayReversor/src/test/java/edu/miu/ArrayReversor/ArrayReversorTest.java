package edu.miu.ArrayReversor;

import edu.miu.ArrayReversor.service.ArrayFlattenerService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ArrayReversorTest {

    private ArrayReversor arrayReversor;

//    @Mock
    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

    @BeforeEach
    void setUp() {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        this.arrayReversor = null;
    }

    @Test
    void testReverseArrayWithLegitInput() {
        when(arrayFlattenerService
                .flattenArray(new int[][]{{1, 3}, {0}, {4, 5, 9}}))
                .thenReturn(new int[]{1, 3, 0, 4, 5, 9});

        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerService);
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {9, 5, 4, 0, 3, 1};
        int[] actual = arrayReversor.reverseArray(input);
        MatcherAssert.assertThat(actual, CoreMatchers.is(expected));
    }

    @Test
    void testReverseArrayWithNullInput() {
        when(arrayFlattenerService.flattenArray(new int[][]{{1, 3}, {0}, {4, 5, 9}}))
                .thenReturn(new int[0]);

        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerService);
        int[] expected = {};
        int[] actual = arrayReversor.reverseArray(null);
        MatcherAssert.assertThat(actual, CoreMatchers.is(expected));
    }
}