package com.micatechnologies.micautils_j8.data;

import com.micatechnologies.micautils_j8.types.ByteBased;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * A trie data structure that uses bytes as keys, allowing for efficient storage and retrieval of
 * values based on {@link ByteBased} keys. Each node in the trie corresponds to a byte, and the path
 * from the root to a node represents the key for the value stored in that node.
 *
 * @param <T> the type of values stored in the trie
 *
 * @version 1.0.1
 * @since 1.0.0
 */
public class ByteBasedTrie<T> implements Iterable<T> {

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
   * Returns an iterator over elements in the {@link ByteBasedTrie} of type {@code T}.
   *
   * @return an Iterator over elements of type {@code T} in the {@link ByteBasedTrie}
   *
   * @since 1.0.1
   */
  @Override
  public Iterator<T> iterator() {
    return new TrieIterator();
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

  /**
   * An iterator for the {@link ByteBasedTrie} that traverses the trie in a depth-first manner,
   * visiting each node that has a value.
   *
   * @version 1.0.0
   * @since 1.0.1
   */
  private class TrieIterator implements Iterator<T> {

    /**
     * A stack used to facilitate depth-first traversal of the trie.
     *
     * @since 1.0.0
     */
    private final Stack<Node> stack = new Stack<>();

    /**
     * The next value to be returned by the iterator. This is pre-fetched to allow the
     * {@link #hasNext()} method to determine if there are more values to iterate over.
     *
     * @since 1.0.0
     */
    private T nextValue;

    /**
     * Constructs a new {@link TrieIterator}, initializing the traversal starting from the root of
     * the trie.
     *
     * @since 1.0.0
     */
    public TrieIterator() {
      pushNodes(root);
      findNext();
    }

    /**
     * Pushes the children of the given node onto the stack, facilitating depth-first traversal.
     *
     * @param node the node whose children are to be pushed onto the stack
     *
     * @since 1.0.0
     */
    private void pushNodes(Node node) {
      for (Node child : node.children) {
        if (child != null) {
          stack.push(child);
        }
      }
    }

    /**
     * Finds the next value in the trie that the iterator will return. This method updates the
     * {@link #nextValue} field with the next value, or sets it to {@code null} if there are no more
     * values.
     *
     * @since 1.0.0
     */
    private void findNext() {
      nextValue = null;
      while (!stack.isEmpty()) {
        Node currentNode = stack.pop();
        if (currentNode.value != null) {
          nextValue = currentNode.value;
          break;
        }
        pushNodes(currentNode);
      }
    }

    /**
     * Determines if the iterator has more values to return.
     *
     * @return {@code true} if there are more values to return, {@code false} otherwise
     *
     * @since 1.0.0
     */
    @Override
    public boolean hasNext() {
      return nextValue != null;
    }

    /**
     * Returns the next value in the iteration.
     *
     * @return the next value
     *
     * @since 1.0.0
     */
    @Override
    public T next() {
      T currentValue = nextValue;
      findNext();
      return currentValue;
    }
  }

}
