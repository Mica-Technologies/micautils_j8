package com.micatechnologies.micautils_j8.types;

import com.micatechnologies.micautils_j8.ByteArrayTool;
import com.micatechnologies.micautils_j8.data.ByteBasedTrie;

/**
 * Integer wrapper class that implements the {@link ByteBased} interface.
 * <p>
 * This class is used to wrap an integer value and convert it to a byte array.
 * </p>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ByteBasedInteger implements ByteBased {

  /**
   * The integer value.
   *
   * @since 1.0.0
   */
  private final int value;

  /**
   * Constructor for a new {@link ByteBasedInteger} object.
   *
   * @param value the integer value.
   *
   * @since 1.0.0
   */
  public ByteBasedInteger(int value) {
    this.value = value;
  }

  /**
   * Creates a new {@link ByteBasedInteger} object with the specified value.
   *
   * @param value the integer value.
   *
   * @return the new {@link ByteBasedInteger} object.
   *
   * @since 1.0.0
   */
  public static ByteBasedInteger of(int value) {
    return new ByteBasedInteger(value);
  }

  /**
   * Gets the integer value.
   *
   * @return the integer value.
   *
   * @since 1.0.0
   */
  public int getValue() {
    return value;
  }

  /**
   * Converts the object to a byte array.
   *
   * @return the byte array representation of the object.
   *
   * @since 1.0.0
   */
  @Override
  public byte[] toBytes() {
    return ByteArrayTool.fromInt(value);
  }

  /**
   * Converts the object to a reversed byte array.
   * <p>
   * The resulting reversed byte array should be the same as the byte array returned by the
   * {@link #toBytes()} method, but with the bytes in reverse order.
   * <br>
   * The reversed byte array is useful for reducing memory usage when using a byte based data type
   * as a key in a {@link ByteBasedTrie}.
   * <br>
   * When applicable, it is recommended to directly read the backing byte array in reverse order
   * instead of converting the standard byte array to a reversed byte array. This will reduce memory
   * usage and improve performance.
   * </p>
   *
   * @return the reversed byte array representation of the object.
   *
   * @since 1.0.0
   */
  @Override
  public byte[] toBytesReversed() {
    return ByteArrayTool.fromIntReversed(value);
  }
}
