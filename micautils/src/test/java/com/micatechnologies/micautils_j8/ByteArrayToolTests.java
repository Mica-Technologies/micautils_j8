package com.micatechnologies.micautils_j8;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.nio.ByteBuffer;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class ByteArrayToolTests {

  private static final int NUM_TESTS = 10000; // Number of random values to test
  private final Random random = new Random();

  @Test
  public void testFromChar() {
    for (int i = 0; i < NUM_TESTS; i++) {
      char testChar = (char) random.nextInt(Character.MAX_VALUE + 1);
      byte[] expectedBytes = ByteBuffer.allocate(2).putChar(testChar).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromChar(testChar));
    }
  }

  @Test
  public void testFromCharReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      char testChar = (char) random.nextInt(Character.MAX_VALUE + 1);
      byte[] expectedBytes = ByteBuffer.allocate(2).putChar(testChar).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromCharReversed(testChar));
    }
  }

  @Test
  public void testFromShort() {
    for (int i = 0; i < NUM_TESTS; i++) {
      short testShort = (short) random.nextInt(Short.MAX_VALUE + 1);
      byte[] expectedBytes = ByteBuffer.allocate(2).putShort(testShort).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromShort(testShort));
    }
  }

  @Test
  public void testFromShortReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      short testShort = (short) random.nextInt(Short.MAX_VALUE + 1);
      byte[] expectedBytes = ByteBuffer.allocate(2).putShort(testShort).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromShortReversed(testShort));
    }
  }

  @Test
  public void testFromInt() {
    for (int i = 0; i < NUM_TESTS; i++) {
      int testInt = random.nextInt();
      byte[] expectedBytes = ByteBuffer.allocate(4).putInt(testInt).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromInt(testInt));
    }
  }

  @Test
  public void testFromIntReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      int testInt = random.nextInt();
      byte[] expectedBytes = ByteBuffer.allocate(4).putInt(testInt).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromIntReversed(testInt));
    }
  }

  @Test
  public void testFromFloat() {
    for (int i = 0; i < NUM_TESTS; i++) {
      float testFloat = random.nextFloat();
      byte[] expectedBytes = ByteBuffer.allocate(4).putFloat(testFloat).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromFloat(testFloat));
    }
  }

  @Test
  public void testFromFloatReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      float testFloat = random.nextFloat();
      byte[] expectedBytes = ByteBuffer.allocate(4).putFloat(testFloat).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromFloatReversed(testFloat));
    }
  }

  @Test
  public void testFromLong() {
    for (int i = 0; i < NUM_TESTS; i++) {
      long testLong = random.nextLong();
      byte[] expectedBytes = ByteBuffer.allocate(8).putLong(testLong).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromLong(testLong));
    }
  }

  @Test
  public void testFromLongReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      long testLong = random.nextLong();
      byte[] expectedBytes = ByteBuffer.allocate(8).putLong(testLong).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromLongReversed(testLong));
    }
  }

  @Test
  public void testFromDouble() {
    for (int i = 0; i < NUM_TESTS; i++) {
      double testDouble = random.nextDouble();
      byte[] expectedBytes = ByteBuffer.allocate(8).putDouble(testDouble).array();
      assertArrayEquals(expectedBytes, ByteArrayTool.fromDouble(testDouble));
    }
  }

  @Test
  public void testFromDoubleReversed() {
    for (int i = 0; i < NUM_TESTS; i++) {
      double testDouble = random.nextDouble();
      byte[] expectedBytes = ByteBuffer.allocate(8).putDouble(testDouble).array();
      assertArrayEquals(ByteArrayTool.reverseBytes(expectedBytes),
          ByteArrayTool.fromDoubleReversed(testDouble));
    }
  }
}
