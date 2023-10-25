package com.micatechnologies.micautils_j8.types;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteBasedTypeTests {

    private static final int NUM_TESTS = 10000; // Number of random values to test
    private final Random random = new Random();

    @Test
    public void testByteConvertibleChar() {
        for (int i = 0; i < NUM_TESTS; i++) {
            char testChar = (char) random.nextInt(Character.MAX_VALUE + 1);
            ByteBasedChar byteConvertibleChar = new ByteBasedChar(testChar);
            assertEquals(testChar, byteConvertibleChar.getValue());

            byte[] expectedBytes = ByteBuffer.allocate(2).putChar(testChar).array();
            assertArrayEquals(expectedBytes, byteConvertibleChar.toBytes());
        }
    }

    @Test
    public void testByteConvertibleInteger() {
        for (int i = 0; i < NUM_TESTS; i++) {
            int testInt = random.nextInt();
            ByteBasedInteger byteConvertibleInteger = new ByteBasedInteger(testInt);
            assertEquals(testInt, byteConvertibleInteger.getValue());

            byte[] expectedBytes = ByteBuffer.allocate(4).putInt(testInt).array();
            assertArrayEquals(expectedBytes, byteConvertibleInteger.toBytes());
        }
    }

    @Test
    public void testByteConvertibleLong() {
        for (int i = 0; i < NUM_TESTS; i++) {
            long testLong = random.nextLong();
            ByteBasedLong byteConvertibleLong = new ByteBasedLong(testLong);
            assertEquals(testLong, byteConvertibleLong.getValue());

            byte[] expectedBytes = ByteBuffer.allocate(8).putLong(testLong).array();
            assertArrayEquals(expectedBytes, byteConvertibleLong.toBytes());
        }
    }
}