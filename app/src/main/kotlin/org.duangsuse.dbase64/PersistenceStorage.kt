package org.duangsuse.dbase64

import android.content.*

class PersistenceStorage(val app: App) {
  val p = app.getPreferences(android.content.Context.MODE_WORLD_READABLE)

  var kolorBar
    get() = p.getBoolean(KBAR, true)
    set(pr: Boolean) { p.edit().putBoolean(KBAR, pr).commit() }

  var doAnim
    get() = p.getBoolean(ANIM, false)
    set(pr: Boolean) { p.edit().putBoolean(ANIM, pr).commit() }

  var coder
    get() = p.getString(CODER, "Base64")
    set(name: String) { p.edit().putString(CODER, name).commit() }

  var scolor
    get() = p.getInt(SCOLOR, 0xf2fced)
    set(k: Int) { p.edit().putInt(SCOLOR, k).commit() }

  var sicon
    get() = p.getString(SICON, "ic_lock_idle_lock")
    set(id: String) { p.edit().putString(SICON, id).commit() }

  var fcolor
    get() = p.getInt(FCOLOR, 0x8fb3c4)
    set(k: Int) { p.edit().putInt(FCOLOR, k).commit() }

  var ficon
    get() = p.getString(FICON, "ic_lock_lock")
    set(id: String) { p.edit().putString(FICON, id).commit() }

  companion object {
    const val KBAR = "KolorBar"
    const val ANIM = "Animations"
    const val CODER = "CoderName"
    const val ABAR = "ActionBar"
    const val SCOLOR = "StatusBarColor"
    const val SICON = "StatusBarIcon"
    const val FCOLOR = "FabColor"
    const val FICON = "FabIcon"
  }
}
