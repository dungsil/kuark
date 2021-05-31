/*!
 * Kuark
 *
 * Copyright (c) 2021. Kim Younggeon
 * SPDX-License-Identifier: MIT
 * License-Filename: LICENSE
 */
package io.kuark.text

import kotlin.test.Test
import kotlin.test.assertEquals

class StringTest {

  @Test
  fun addPrefixIfNotEmpty() {
    assertEquals("123ABC", "ABC".addPrefixIfNotEmpty("123"))
    assertEquals("", "".addPrefixIfNotEmpty("123"))
  }

  @Test
  fun addSuffixIfNotEmpty() {
    assertEquals("ABC123", "ABC".addSuffixIfNotEmpty("123"))
    assertEquals("", "".addSuffixIfNotEmpty("123"))
  }
}
