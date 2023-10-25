package com.micatechnologies.micautils_j8;

/**
 * Tool/utility class for working with byte arrays.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ByteArrayTool {

  /**
   * Gets the byte array representation (2 bytes) of a char value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the char value to be converted.
   *
   * @return the byte array representation (2 bytes) of the char value.
   *
   * @since 1.0.0
   */
  public static byte[] fromChar(char value) {
    return new byte[]{
        (byte) (value >>> 8),
        (byte) value
    };
  }

  /**
   * Gets the byte array representation (2 bytes) of a char value in reversed (little-endian)
   * order.
   *
   * @param value the char value to be converted.
   *
   * @return the byte array representation (2 bytes) of the char value.
   *
   * @since 1.0.0
   */
  public static byte[] fromCharReversed(char value) {
    return new byte[]{
        (byte) value,
        (byte) (value >>> 8)
    };
  }

  /**
   * Gets the byte array representation (2 bytes) of a short value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the short value to be converted.
   *
   * @return the byte array representation (2 bytes) of the short value.
   *
   * @since 1.0.0
   */
  public static byte[] fromShort(short value) {
    return new byte[]{
        (byte) (value >>> 8),
        (byte) value
    };
  }

  /**
   * Gets the byte array representation (2 bytes) of a short value in reversed (little-endian)
   * order.
   *
   * @param value the short value to be converted.
   *
   * @return the byte array representation (2 bytes) of the short value.
   *
   * @since 1.0.0
   */
  public static byte[] fromShortReversed(short value) {
    return new byte[]{
        (byte) value,
        (byte) (value >>> 8)
    };
  }

  /**
   * Gets the byte array representation (4 bytes) of a float value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the float value to be converted.
   *
   * @return the byte array representation (4 bytes) of the float value.
   *
   * @since 1.0.0
   */
  public static byte[] fromFloat(float value) {
    return fromInt(Float.floatToIntBits(value));
  }

  /**
   * Gets the byte array representation (4 bytes) of an int value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the int value to be converted.
   *
   * @return the byte array representation (4 bytes) of the int value.
   *
   * @since 1.0.0
   */
  public static byte[] fromInt(int value) {
    return new byte[]{
        (byte) (value >>> 24),
        (byte) (value >>> 16),
        (byte) (value >>> 8),
        (byte) value
    };
  }

  /**
   * Gets the byte array representation (4 bytes) of a float value in reversed (little-endian)
   * order.
   *
   * @param value the float value to be converted.
   *
   * @return the byte array representation (4 bytes) of the float value.
   *
   * @since 1.0.0
   */
  public static byte[] fromFloatReversed(float value) {
    return fromIntReversed(Float.floatToIntBits(value));
  }

  /**
   * Gets the byte array representation (4 bytes) of an int value in reversed (little-endian)
   * order.
   *
   * @param value the int value to be converted.
   *
   * @return the byte array representation (4 bytes) of the int value.
   *
   * @since 1.0.0
   */
  public static byte[] fromIntReversed(int value) {
    return new byte[]{
        (byte) value,
        (byte) (value >>> 8),
        (byte) (value >>> 16),
        (byte) (value >>> 24)
    };
  }

  /**
   * Gets the byte array representation (8 bytes) of a double value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the double value to be converted.
   *
   * @return the byte array representation (8 bytes) of the double value.
   *
   * @since 1.0.0
   */
  public static byte[] fromDouble(double value) {
    return fromLong(Double.doubleToLongBits(value));
  }

  /**
   * Gets the byte array representation (8 bytes) of a long value in standard
   * (non-reversed/big-endian) order.
   *
   * @param value the long value to be converted.
   *
   * @return the byte array representation (8 bytes) of the long value.
   *
   * @since 1.0.0
   */
  public static byte[] fromLong(long value) {
    return new byte[]{
        (byte) (value >>> 56),
        (byte) (value >>> 48),
        (byte) (value >>> 40),
        (byte) (value >>> 32),
        (byte) (value >>> 24),
        (byte) (value >>> 16),
        (byte) (value >>> 8),
        (byte) value
    };
  }

  /**
   * Gets the byte array representation (8 bytes) of a double value in reversed (little-endian)
   * order.
   *
   * @param value the double value to be converted.
   *
   * @return the byte array representation (8 bytes) of the double value.
   *
   * @since 1.0.0
   */
  public static byte[] fromDoubleReversed(double value) {
    return fromLongReversed(Double.doubleToLongBits(value));
  }

  /**
   * Gets the byte array representation (8 bytes) of a long value in reversed (little-endian)
   * order.
   *
   * @param value the long value to be converted.
   *
   * @return the byte array representation (8 bytes) of the long value.
   *
   * @since 1.0.0
   */
  public static byte[] fromLongReversed(long value) {
    return new byte[]{
        (byte) value,
        (byte) (value >>> 8),
        (byte) (value >>> 16),
        (byte) (value >>> 24),
        (byte) (value >>> 32),
        (byte) (value >>> 40),
        (byte) (value >>> 48),
        (byte) (value >>> 56)
    };
  }

  /**
   * Gets the reversed representation of a byte array.
   *
   * @param bytes the byte array to be reversed
   *
   * @return the reversed byte array
   *
   * @since 1.0.0
   */
  public static byte[] reverseBytes(byte[] bytes) {
    byte[] reversed = new byte[bytes.length];
    for (int i = 0; i < bytes.length; i++) {
      reversed[i] = bytes[bytes.length - 1 - i];
    }
    return reversed;
  }
}
