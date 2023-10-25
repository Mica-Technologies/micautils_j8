package micautils_j8.extensions.com.micatechnologies.micautils_j8.data.ByteBasedTrie;

import com.micatechnologies.micautils_j8.data.ByteBasedTrie;
import com.micatechnologies.micautils_j8.types.ByteBased;
import com.micatechnologies.micautils_j8.types.ByteBasedChar;
import com.micatechnologies.micautils_j8.types.ByteBasedDouble;
import com.micatechnologies.micautils_j8.types.ByteBasedFloat;
import com.micatechnologies.micautils_j8.types.ByteBasedInteger;
import com.micatechnologies.micautils_j8.types.ByteBasedLong;
import com.micatechnologies.micautils_j8.types.ByteBasedShort;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

/**
 * Provides Manifold extension methods for the {@link ByteBasedTrie} class to support operator
 * overloading. Specifically, this extension class enables the use of the {@code []} operator for
 * getting and setting values in a {@link ByteBasedTrie} instance.
 * <p>
 * With this extension, you can use syntax like:
 * <pre>
 * ByteBasedTrie&lt;String&gt; trie = ...;
 * String value = trie[someByteBasedKey];
 * trie[someByteBasedKey] = "newValue";
 * </pre>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Extension
public class ByteBasedTrieExtension {

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, ByteBased key) {
    return thiz.getValue(key);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, ByteBased key, T value) {
    return thiz.setValue(key, value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, int key) {
    return thiz.getValue(ByteBasedInteger.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, int key, T value) {
    return thiz.setValue(ByteBasedInteger.of(key), value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, char key) {
    return thiz.getValue(ByteBasedChar.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, char key, T value) {
    return thiz.setValue(ByteBasedChar.of(key), value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, double key) {
    return thiz.getValue(ByteBasedDouble.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, double key, T value) {
    return thiz.setValue(ByteBasedDouble.of(key), value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, float key) {
    return thiz.getValue(ByteBasedFloat.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, float key, T value) {
    return thiz.setValue(ByteBasedFloat.of(key), value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, long key) {
    return thiz.getValue(ByteBasedLong.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, long key, T value) {
    return thiz.setValue(ByteBasedLong.of(key), value);
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#getValue(ByteBased)} which facilitates the
   * overloading of the {@code []} operator.
   *
   * @param <T>  the type of the value to be retrieved/returned
   * @param thiz the {@link ByteBasedTrie} instance on which this method is called
   * @param key  the key whose associated value is to be returned
   *
   * @return the value associated with the given key, or {@code null} if the trie contains no
   *     mapping for the key
   *
   * @since 1.0.0
   */
  public static <T> T get(
      @This
      ByteBasedTrie<T> thiz, short key) {
    return thiz.getValue(ByteBasedShort.of(key));
  }

  /**
   * Manifold extension method for {@link ByteBasedTrie#setValue(ByteBased, Object)} which
   * facilitates the overloading of the {@code []} operator.
   *
   * @param <T>   the type of the value to be set
   * @param thiz  the {@link ByteBasedTrie} instance on which this method is called
   * @param key   the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   *
   * @return the previous value associated with the key, or {@code null} if there was no mapping for
   *     the key
   *
   * @since 1.0.0
   */
  public static <T> T set(
      @This
      ByteBasedTrie<T> thiz, short key, T value) {
    return thiz.setValue(ByteBasedShort.of(key), value);
  }

}