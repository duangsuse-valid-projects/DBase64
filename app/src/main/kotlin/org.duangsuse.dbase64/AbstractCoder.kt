package org.duangsuse.dbase64

abstract class AbstractCoder {
  var mode: Int = 0

  abstract fun modes(): Set<String>
  abstract fun getMode(name: String): Int?

  abstract fun encode(cs: CharSequence): String
  abstract fun decode(cs: CharSequence): String

  fun decodeFile(cs: CharSequence): ByteArray {
    return (decode(cs) as java.lang.String).getBytes()
  }

  fun encodeFile(f: ByteArray): String {
    val str = String(f)
    return encode(str)
  }
}
