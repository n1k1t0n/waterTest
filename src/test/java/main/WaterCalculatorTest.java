package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterCalculatorTest {

    private final WaterCalculator waterCalculator = new WaterCalculator();
    private static Stream<Arguments> calculateWater() {
        return Stream.of(
                Arguments.of(new int[]{}, 0L),
                Arguments.of(new int[]{1}, 0L),
                Arguments.of(new int[]{3, 2}, 0L),
                Arguments.of(new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}, 9L),
                Arguments.of(new int[]{5, 2, 3, 4, 4, 3, 2, 3, 1}, 4L),
                Arguments.of(new int[]{2, 5, 3, 4, 2, 0, 0, 3, 1}, 8L),
                Arguments.of(new int[]{5, 4, 3, 2, 1, 2, 3, 4, 5}, 16L),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 0L),
                Arguments.of(new int[]{5, 4, 3, 2, 1, 0}, 0L),
                Arguments.of(new int[]{1, 2, 3, 2, 1, 0}, 0L),
                Arguments.of(new int[]{1, 0, 1, 0, 1, 0}, 2L),
                Arguments.of(new int[]{1, 0, 1, 0, 1}, 2L),
                Arguments.of(new int[]{1, 0, 1, 0}, 1L),
                Arguments.of(new int[]{1, 0, 1}, 1L),
                Arguments.of(new int[]{0, 0, 0}, 0L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 12, 3, 2, 1, 5, 3, 2, 1, 0}, 48L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 6, 3, 9, 1, 5, 3, 2, 1, 0}, 52L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 6, 3, 7, 1, 5, 3, 2, 1, 0}, 30L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 6, 3, 6, 1, 5, 3, 2, 1, 0}, 27L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 12, 3, 2, 1, 5, 3, 2, 1, 0, 10, 14, 4, 8, 3, 12, 5, 11, 9, 0, 4, 2, 7, 5, 3, 4, 3, 1, 1, 1, 5, 13, 8, 7, 11, 2, 4, 8, 13, 0, 2, 9}, 333L),
                Arguments.of(new int[]{9, 6, 5, 4, 4, 4, 5, 7, 7, 0, 6, 3, 2, 1, 5, 3, 2, 1, 0, 4, 4, 4, 4, 3, 4, 4, 3, 3, 0, 3, 2, 3, 3, 3, 3, 3, 1, 1, 1, 3, 3, 3, 3, 3, 2, 3, 3, 3, 0, 2, 3}, 55L),
                Arguments.of(new int[]{2, 4, 4, 0, 6, 0, 10, 0, 1, 9, 6, 8, 9, 8, 12, 10, 12, 9, 1, 7, 9, 4, 7, 1, 12, 13, 9, 6, 8, 10, 4, 7, 13, 3, 12, 2, 12, 9, 9, 11, 1, 1, 9, 11, 9, 6, 12, 4, 3, 11}, 197L)
        );
    }
    @ParameterizedTest
    @MethodSource("calculateWater")
    void calculateWaterAmount(int[] landscape, long expected) {
        assertEquals(expected, waterCalculator.calculateWaterAmount(landscape));
    }

}