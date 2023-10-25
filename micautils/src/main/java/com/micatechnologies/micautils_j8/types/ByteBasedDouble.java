package com.micatechnologies.micautils_j8.types;

import com.micatechnologies.micautils_j8.ByteArrayTool;
import com.micatechnologies.micautils_j8.data.ByteBasedTrie;

/**
 * Double wrapper class that implements the {@link ByteBased} interface.
 * <p>
 * This class is used to wrap an double value and convert it to a byte array.
 * </p>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ByteBasedDouble implements ByteBased {

  /**
   * The double value.
   *
   * @since 1.0.0
   */
  private final double value;

  /**
   * Constructor for a new {@link ByteBasedDouble} object.
   *
   * @param value the double value.
   *
   * @since 1.0.0
   */
  public ByteBasedDouble(double value) {
    this.value = value;
  }

  /**
   * Creates a new {@link ByteBasedDouble} object with the specified value.
   *
   * @param value the double value.
   *
   * @return the new {@link ByteBasedDouble} object.
   *
   * @since 1.0.0
   */
  public static ByteBasedDouble of(double value) {
    return new ByteBasedDouble(value);
  }

  /**
   * Gets the double value.
   *
   * @return the double value.
   *
   * @since 1.0.0
   */
  public double getValue() {
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
    return ByteArrayTool.fromDouble(value);
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
    return ByteArrayTool.fromDoubleReversed(value);
  }
}
