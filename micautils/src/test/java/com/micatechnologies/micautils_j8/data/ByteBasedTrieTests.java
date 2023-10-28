package com.micatechnologies.micautils_j8.data;

import static org.junit.jupiter.api.Assertions.*;

import com.micatechnologies.micautils_j8.types.ByteBasedInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ByteBasedTrieTests {

  private static final int NUM_TESTS = 10000; // Number of random values to test
  private static final int MAX_STRING_LENGTH = 10;
  private final Random random = new Random();
  private ByteBasedTrie<String> trie;

  @BeforeEach
  public void setUp() {
    trie = new ByteBasedTrie<>();
  }

  @Test
  public void testInsertAndRetrieve() {
    ByteBasedInteger key = generateRandomKey();
    String value = generateRandomValue();

    trie.setValue(key, value);
    assertEquals(value, trie.getValue(key));
  }

  private ByteBasedInteger generateRandomKey() {
    return new ByteBasedInteger(random.nextInt());
  }

  private String generateRandomValue() {
    int length = random.nextInt(MAX_STRING_LENGTH) + 1;
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      char c = (char) (random.nextInt(26) + 'a');
      sb.append(c);
    }
    return sb.toString();
  }

  @Test
  public void testIterationOverEmptyTrie() {
    Iterator<String> iterator = trie.iterator();
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testIterationAfterClearingTrie() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    // Clear the trie using the keys from the reference map
    for (ByteBasedInteger key : referenceMap.keySet()) {
      trie.remove(key);
    }

    Iterator<String> iterator = trie.iterator();
    assertFalse(iterator.hasNext());
  }

  private Map<ByteBasedInteger, String> populateTrieAndReferenceMap() {
    Map<ByteBasedInteger, String> referenceMap = new HashMap<>();
    for (int i = 0; i < NUM_TESTS; i++) {
      ByteBasedInteger key = generateRandomKey();
      String value = generateRandomValue();

      trie.setValue(key, value);
      referenceMap.put(key, value);
    }
    return referenceMap;
  }

  @Test
  public void testIterationOverSingleElementTrie() {
    ByteBasedInteger key = generateRandomKey();
    String value = "singleValue";
    trie.setValue(key, value);

    int count = 0;
    for (String trieValue : trie) {
      assertEquals(value, trieValue);
      count++;
    }
    assertEquals(1, count);
  }

  @Test
  public void testMultipleValuesForSingleKey() {
    ByteBasedInteger key = generateRandomKey();
    String value1 = "firstValue";
    String value2 = "secondValue";

    trie.setValue(key, value1);
    trie.setValue(key, value2);

    int count = 0;
    for (String trieValue : trie) {
      assertEquals(value2, trieValue);
      count++;
    }
    assertEquals(1, count);
  }

  @Test
  public void testIterationWithSharedPrefixes() {
    // Let's use two integers that, when reversed, share a common prefix in their byte representation.
    // For simplicity, let's use 1 and 256. When reversed, they become 256 and 65536 respectively.
    // In byte form, 256 is 0x0001 and 65536 is 0x0100. They share a common prefix of 0x00.
    ByteBasedInteger key1 = new ByteBasedInteger(1);
    ByteBasedInteger key2 = new ByteBasedInteger(256);

    trie.setValue(key1, "valueFor1");
    trie.setValue(key2, "valueFor256");

    List<String> values = new ArrayList<>();
    for (String value : trie) {
      values.add(value);
    }

    assertTrue(values.contains("valueFor1"));
    assertTrue(values.contains("valueFor256"));
    assertEquals(2, values.size());
  }


  @Test
  public void testIterationAfterRandomRemovals() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    List<ByteBasedInteger> keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    int removalCount = keys.size() / 2;
    for (int i = 0; i < removalCount; i++) {
      ByteBasedInteger key = keys.get(i);
      trie.remove(key);
      referenceMap.remove(key);
    }

    List<String> values = new ArrayList<>();
    for (String value : trie) {
      values.add(value);
    }

    assertEquals(referenceMap.values().size(), values.size());
    assertTrue(values.containsAll(referenceMap.values()));
  }

  @Test
  public void testIterationWithLongestPossibleKey() {
    // Use the maximum value of an integer as the key.
    ByteBasedInteger key = new ByteBasedInteger(Integer.MAX_VALUE);
    String value = "valueForMaxInt";

    trie.setValue(key, value);

    List<String> values = new ArrayList<>();
    for (String v : trie) {
      values.add(v);
    }

    assertTrue(values.contains(value));
    assertEquals(1, values.size());
  }

  @Test
  public void testIterationWithShortestPossibleKey() {
    // Use the smallest positive integer value as the key.
    ByteBasedInteger key = new ByteBasedInteger(1);
    String value = "valueFor1";

    trie.setValue(key, value);

    List<String> values = new ArrayList<>();
    for (String v : trie) {
      values.add(v);
    }

    assertTrue(values.contains(value));
    assertEquals(1, values.size());
  }


  @Test
  public void testIterationOverTrieWithSingleEntry() {
    ByteBasedInteger key = generateRandomKey();
    String value = generateRandomValue();

    trie.setValue(key, value);

    Iterator<String> iterator = trie.iterator();
    assertTrue(iterator.hasNext());
    assertEquals(value, iterator.next());
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testOverwriteValue() {
    ByteBasedInteger key = generateRandomKey();
    String value1 = generateRandomValue();
    String value2 = generateRandomValue();

    trie.setValue(key, value1);
    assertEquals(value1, trie.getValue(key));

    trie.setValue(key, value2);
    assertEquals(value2, trie.getValue(key));
  }

  @Test
  public void testRemoveValue() {
    ByteBasedInteger key = generateRandomKey();
    String value = generateRandomValue();

    trie.setValue(key, value);
    assertEquals(value, trie.getValue(key));

    trie.remove(key);
    assertNull(trie.getValue(key));
  }

  @Test
  public void testRandomInsertRetrieve() {
    for (int i = 0; i < NUM_TESTS; i++) {
      ByteBasedInteger key = generateRandomKey();
      String value = generateRandomValue();

      trie.setValue(key, value);
      assertEquals(value, trie.getValue(key));
    }
  }

  @Test
  public void testRandomInsertRemove() {
    for (int i = 0; i < NUM_TESTS; i++) {
      ByteBasedInteger key = generateRandomKey();
      String value = generateRandomValue();

      trie.setValue(key, value);
      assertEquals(value, trie.getValue(key));

      trie.remove(key);
      assertNull(trie.getValue(key));
    }
  }

  @Test
  public void testIntegrityAfterRandomOperations() {
    Map<ByteBasedInteger, String> referenceMap = new HashMap<>();

    // Insertion and Verification
    for (int i = 0; i < NUM_TESTS; i++) {
      ByteBasedInteger key = generateRandomKey();
      String value = generateRandomValue();

      trie.setValue(key, value);
      referenceMap.put(key, value);
    }
    verifyTrieMatchesReferenceMap(referenceMap);

    // Random Removal and Verification
    List<ByteBasedInteger> keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    for (int i = 0; i < keys.size() / 2; i++) { // remove half of the entries
      ByteBasedInteger key = keys.get(i);
      trie.remove(key);
      referenceMap.remove(key);
    }
    verifyTrieMatchesReferenceMap(referenceMap);

    // Random Updates and Verification
    keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    for (int i = 0; i < keys.size() / 2; i++) { // update half of the remaining entries
      ByteBasedInteger key = keys.get(i);
      String newValue = generateRandomValue();

      trie.setValue(key, newValue);
      referenceMap.put(key, newValue);
    }
    verifyTrieMatchesReferenceMap(referenceMap);

    // Final Cleanup and Verification
    for (ByteBasedInteger key : referenceMap.keySet()) {
      trie.remove(key);
    }
    referenceMap.clear();
    verifyTrieMatchesReferenceMap(referenceMap);
  }

  private void verifyTrieMatchesReferenceMap(Map<ByteBasedInteger, String> referenceMap) {
    for (Map.Entry<ByteBasedInteger, String> entry : referenceMap.entrySet()) {
      assertEquals(entry.getValue(), trie.getValue(entry.getKey()));
    }
  }

  @Test
  public void testInsertionAndVerification() {
    Map<ByteBasedInteger, String> referenceMap = new HashMap<>();

    // Insertion
    for (int i = 0; i < NUM_TESTS; i++) {
      ByteBasedInteger key = generateRandomKey();
      String value = generateRandomValue();

      trie.setValue(key, value);
      referenceMap.put(key, value);
    }

    // Verification
    verifyTrieMatchesReferenceMap(referenceMap);
  }

  @Test
  public void testRandomRemovalAndVerification() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    // Random Removal
    List<ByteBasedInteger> keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    for (int i = 0; i < keys.size() / 2; i++) { // remove half of the entries
      ByteBasedInteger key = keys.get(i);
      trie.remove(key);
      referenceMap.remove(key);
    }

    // Verification
    verifyTrieMatchesReferenceMap(referenceMap);
  }

  @Test
  public void testIterationOverTrieValues() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();
    List<String> iteratedValues = new ArrayList<>();

    Iterator<String> iterator = trie.iterator();
    while (iterator.hasNext()) {
      iteratedValues.add(iterator.next());
    }

    for (String value : referenceMap.values()) {
      assertTrue(iteratedValues.contains(value));
    }
  }

  @Test
  public void testForeachLoopOverTrie() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();
    List<String> iteratedValues = new ArrayList<>();

    for (String value : trie) {
      iteratedValues.add(value);
    }

    for (String value : referenceMap.values()) {
      assertTrue(iteratedValues.contains(value));
    }
  }

  @Test
  public void testIteratorAfterTrieModifications() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    // Remove half of the entries
    List<ByteBasedInteger> keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    for (int i = 0; i < keys.size() / 2; i++) {
      ByteBasedInteger key = keys.get(i);
      trie.remove(key);
      referenceMap.remove(key);
    }

    List<String> iteratedValues = new ArrayList<>();
    for (String value : trie) {
      iteratedValues.add(value);
    }

    for (String value : referenceMap.values()) {
      assertTrue(iteratedValues.contains(value));
    }
  }

  @Test
  public void testRandomUpdatesAndVerification() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    // Random Updates
    List<ByteBasedInteger> keys = new ArrayList<>(referenceMap.keySet());
    Collections.shuffle(keys);
    for (int i = 0; i < keys.size() / 2; i++) { // update half of the remaining entries
      ByteBasedInteger key = keys.get(i);
      String newValue = generateRandomValue();

      trie.setValue(key, newValue);
      referenceMap.put(key, newValue);
    }

    // Verification
    verifyTrieMatchesReferenceMap(referenceMap);
  }

  @Test
  public void testFinalCleanupAndVerification() {
    Map<ByteBasedInteger, String> referenceMap = populateTrieAndReferenceMap();

    // Cleanup
    for (ByteBasedInteger key : referenceMap.keySet()) {
      trie.remove(key);
    }
    referenceMap.clear();

    // Verification
    verifyTrieMatchesReferenceMap(referenceMap);
  }
}
