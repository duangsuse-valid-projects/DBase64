package org.duangsuse.dbase64

import android.R

object IconResolver {
  var androidRDrawable = R.drawable::class.java

  fun hasIcon(name: String): Boolean {
    try {
      androidRDrawable.getField(name)
      return true
    } catch (_: NoSuchFieldException) {
      return false
    }
  }

  fun icon(name: String): Int {
    return androidRDrawable.getField(name).get(androidRDrawable) as Int
  }

  fun listIcon(): List<String> {
    return androidRDrawable.getFields().map { it.name }
  }
}
