package com.micatechnologies.micautils_j8.types;

import com.micatechnologies.micautils_j8.data.ByteBasedTrie;

/**
 * Interface for objects that are backed by a byte array or can be converted to a byte array.
 * <p>
 * Consideration should be given to the fact that conversion to a byte array may be an expensive
 * operation. For data types that are backed by a byte array, the {@link #toBytes()} method should
 * return a reference to the backing byte array. Otherwise, the {@link #toBytes()} method should
 * return a new byte array representation of the object.
 * </p>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ByteBased {

  /**
   * Converts the object to a byte array.
   *
   * @return the byte array representation of the object.
   */
  byte[] toBytes();

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
   */
  byte[] toBytesReversed();
}
