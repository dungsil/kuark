package kuark.text

import kotlin.test.Test
import kotlin.test.assertEquals

class StringExtensionTest {

  @Test
  fun prefixIf() {
    assertEquals("HelloWorld", "World".prefixIf("Hello") { true })
    assertEquals("World", "World".prefixIf("Hello") { false })
    assertEquals("TestText", "Text".prefixIf("Test") { true })
    assertEquals("Text", "Text".prefixIf("Test") { false })
  }

  @Test
  fun prefixIfNot() {
    assertEquals("HelloWorld", "HelloWorld".prefixIfNot("Hello"))
    assertEquals("PrefixText", "Text".prefixIfNot("Prefix"))
    assertEquals("Prefix", "".prefixIfNot("Prefix"))
  }

  @Test
  fun testSuffixIf() {
    assertEquals("HelloWorld", "Hello".suffixIf("World") { true })
    assertEquals("Hello", "Hello".suffixIf("World") { false })
    assertEquals("TextTest", "Text".suffixIf("Test") { true })
    assertEquals("Text", "Text".suffixIf("Test") { false })
  }

  @Test
  fun testSuffixIfNot() {
    assertEquals("HelloWorld", "HelloWorld".suffixIfNot("World"))
    assertEquals("HelloWorld", "HelloWorld".suffixIfNot("HelloWorld"))
    assertEquals("TextSuffix", "Text".suffixIfNot("Suffix"))
  }
}
