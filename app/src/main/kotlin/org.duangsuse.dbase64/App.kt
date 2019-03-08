package org.duangsuse.dbase64

import android.os.Bundle
import android.support.design.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*

import android.view.*

class App: AppCompatActivity() {
  override fun onCreate(oldInstanceStat: Bundle?) {
    super.onCreate(oldInstanceStat)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    //menuInflater.inflate(R.menu.main_menu, menu)
    menu.let(::setupMenu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId

    return super.onOptionsItemSelected(item)
  }

  companion object {
    fun setupMenu(m: Menu) {
      m.addItem("a")
    }
  }
}
