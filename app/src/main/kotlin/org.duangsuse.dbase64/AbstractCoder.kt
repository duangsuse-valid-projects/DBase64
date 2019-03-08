package org.duangsuse.dbase64

import java.lang.String

abstract class AbstractCoder {
  var mode: Int = 0

  abstract fun encode(cs: CharSequence): String
  abstract fun decode(cs: CharSequence): String

  fun decodeFile(cs: CharSequence): ByteArray {
    return decode(cs).getBytes()
  }

  fun encodeFile(f: ByteArray): String {
    val str = String(f)
    return encode(str)
  }
}
