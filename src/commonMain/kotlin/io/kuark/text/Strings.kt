/*!
 * Kuark
 *
 * Copyright (c) 2021. Kim Younggeon
 * SPDX-License-Identifier: MIT
 * License-Filename: LICENSE
 */
package io.kuark.text

/**
 * Returns append [prefix], if char sequence is not empty.
 */
public fun CharSequence.addPrefixIfNotEmpty(prefix: CharSequence): CharSequence {
  return if (this.isNotEmpty()) {
    "$prefix$this"
  } else {
    this
  }
}

/**
 * Returns append [suffix], if char sequence is not empty.
 */
public fun CharSequence.addSuffixIfNotEmpty(suffix: CharSequence): CharSequence {
  return if (this.isNotEmpty()) {
    "$this$suffix"
  } else {
    this
  }
}
