package com.micatechnologies.micautils_j8.data;

import com.micatechnologies.micautils_j8.types.ByteBased;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A trie data structure that uses bytes as keys, allowing for efficient storage and retrieval of
 * values based on {@link ByteBased} keys. Each node in the trie corresponds to a byte, and the path
 * from the root to a node represents the key for the value stored in that node.
 *
 * @param <T> the type of values stored in the trie
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ByteBasedTrie<T> {

  /**
   * The root node of the trie.
   *
   * @since 1.0.0
   */
  private final Node root = new Node();

  /**
   * Retrieves the value associated with the given {@link ByteBased} key.
   *
   * @param key the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public T getValue(ByteBased key) {
    Node current = root;
    for (byte b : key.toBytes()) {
      if (current.children.get(b & 0xFF) == null) {
        return null;
      }
      current = current.children.get(b & 0xFF);
    }
    return current.value;
  }

  /**
   * Associates the specified value with the given {@link ByteBased} key in the trie. If the trie
   * previously contained a mapping for the key, the old value is replaced by the specified value.
   *
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public T setValue(ByteBased key, T value) {
    Node current = root;
    for (byte b : key.toBytes()) {
      if (current.children.get(b & 0xFF) == null) {
        current.children.set(b & 0xFF, new Node());
      }
      current = current.children.get(b & 0xFF);
    }
    current.value = value;
    return value;
  }

  /**
   * Removes the mapping for the specified {@link ByteBased} key from the trie if present.
   *
   * @param key the key whose mapping is to be removed from the trie
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public T remove(ByteBased key) {
    return remove(root, key.toBytes(), 0);
  }

  /**
   * Recursively removes the mapping for the specified byte array key from the trie if present. This
   * method cleans up nodes that become unnecessary after the removal.
   *
   * @param current the current node being inspected
   * @param key     the byte array representation of the key
   * @param index   the current index within the key
   *
   * @return the value that was associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  private T remove(Node current, byte[] key, int index) {
    if (index == key.length) {
      if (current.value == null) {
        return null;
      }
      T oldValue = current.value;
      current.value = null;
      return oldValue;
    }

    byte b = key[index];
    Node child = current.children.get(b & 0xFF);
    if (child == null) {
      return null;
    }

    T oldValue = remove(child, key, index + 1);
    if (child.isEmpty()) {
      current.children.set(b & 0xFF, null);
    }
    return oldValue;
  }

  /**
   * Represents a node in the {@link ByteBasedTrie}. Each node can have up to 256
   * ({@code Byte.MAX_VALUE - Byte.MIN_VALUE + 1}) children, one for each possible byte value. The
   * node also stores a value, which is the value associated with the key represented by the path
   * from the root to this node.
   *
   * @since 1.0.0
   */
  private class Node {

    /**
     * The children of the node, indexed by byte value.
     * <p>
     * The {@link ArrayList} is pre-populated with {@code null} values to avoid the possibility of
     * {@link IndexOutOfBoundsException}s when checking for children.
     * </p>
     *
     * @since 1.0.0
     */
    private final ArrayList<Node> children =
        new ArrayList<>(Collections.nCopies(Byte.MAX_VALUE - Byte.MIN_VALUE + 1, null));

    /**
     * The value associated with the node.
     *
     * @since 1.0.0
     */
    private T value;

    /**
     * Determines if the node is empty, i.e., it has no children and no value.
     *
     * @return {@code true} if the node is empty, {@code false} otherwise
     *
     * @since 1.0.0
     */
    private boolean isEmpty() {
      if (value != null) {
        return false;
      }
      for (Node child : children) {
        if (child != null) {
          return false;
        }
      }
      return true;
    }
  }

}
