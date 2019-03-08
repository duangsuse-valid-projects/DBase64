package org.duangsuse.dbase64.coders

import org.duangsuse.dbase64.AbstractCoder

import android.util.Base64

class Base64Coder: AbstractCoder() {
  object Mode {
    const val DEFAULT = 0
    const val NO_PADDING = 1
    const val NO_WARP = 2
    const val CRLF = 4
    const val URL_SAFE = 8
    const val NO_CLOSE = 16

    const val NWD = NO_WARP or DEFAULT
    const val NWCRLF = NO_WARP or CRLF
    const val NWURLS = NO_WARP or URL_SAFE
  }

  val hashie= mapOf("Default" to 0, "No Padding" to 1, "No Wrap" to 2, "CRLF" to 4,
    "URL Safe" to 8, "NoWrap&Default" to Mode.NWD, "NoWrap&CRLF" to Mode.NWCRLF, "NoWrap&URL" to Mode.NWURLS)

  override fun modes(): Set<String> = hashie.keys.toSet()
  override fun getMode(name: String): Int? = hashie[name]

  override fun encode(cs: CharSequence): String {
    val bytes = Base64.encode((cs.toString() as java.lang.String).getBytes(), mode)
    return java.lang.String(bytes) as String
  }

  override fun decode(cs: CharSequence): String {
    val bytes = Base64.decode(cs.toString(), mode)
    return java.lang.String(bytes) as String
  }
}
