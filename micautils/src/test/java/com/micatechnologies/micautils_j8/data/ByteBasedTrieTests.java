package com.micatechnologies.micautils_j8.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.micatechnologies.micautils_j8.types.ByteBasedInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
