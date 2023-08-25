package kuark.text.collection.map

import kuark.collection.map.HashMultiValueMap
import kuark.collection.map.MultiValueMap
import kotlin.test.*

/**
 * @since 0.1.0
 */
class HashMultiValueMapTest {
  private lateinit var multiValueMap: MultiValueMap<String, Int>

  @BeforeTest
  fun setup() {
    multiValueMap = HashMultiValueMap()
  }

  @Test
  fun `test getOne`() {
    multiValueMap.add("key1", 1)
    multiValueMap.add("key1", 2)
    assertEquals(1, multiValueMap.getOne("key1"))
  }

  @Test
  fun `test add`() {
    multiValueMap.add("key1", 1)
    assertEquals(mutableListOf(1), multiValueMap["key1"])
  }

  @Test
  fun `test get with multiple values`() {
    multiValueMap.add("key1", 1)
    multiValueMap.add("key1", 2)
    assertEquals(mutableListOf(1, 2), multiValueMap["key1"])
  }

  @Test
  fun `test get key not exist`() {
    assertNull(multiValueMap.getOne("key1"))
  }

  @Test
  fun `test putAll`() {
    val newMap: Map<String, MutableList<Int>> = hashMapOf(
      "key1" to mutableListOf(1, 2, 3),
      "key2" to mutableListOf(4, 5, 6)
    )
    multiValueMap.putAll(newMap)
    assertEquals(mutableListOf(1, 2, 3), multiValueMap["key1"])
    assertEquals(mutableListOf(4, 5, 6), multiValueMap["key2"])
  }

  @Test
  fun `test remove`() {
    multiValueMap.add("key1", 1)
    multiValueMap.add("key2", 2)
    multiValueMap.remove("key1")
    assertNull(multiValueMap["key1"])
    assertEquals(mutableListOf(2), multiValueMap["key2"])
  }

  @Test
  fun `test clear`() {
    multiValueMap.add("key1", 1)
    multiValueMap.add("key2", 2)
    multiValueMap.clear()
    assertEquals(0, multiValueMap.size)

    multiValueMap.add("key3", 3)
    assertEquals(1, multiValueMap.size)
  }
}
