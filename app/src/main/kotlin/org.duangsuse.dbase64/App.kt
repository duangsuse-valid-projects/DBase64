package org.duangsuse.dbase64

import android.os.Bundle
import android.support.design.widget.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*

import android.view.*
import android.widget.*
import android.widget.FrameLayout.*

class App: AppCompatActivity() {
  override fun onCreate(oldInstanceStat: Bundle?) {
    super.onCreate(oldInstanceStat)

    setupUi(this)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId

    return super.onOptionsItemSelected(item)
  }

  companion object {
    // bad practice
    fun setupUi(app: App) {
      val main = FrameLayout(app)

      val text = EditText(app)
      text.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

      main.addView(text)

      val fab = FloatingActionButton(app)
      val fabLayoutFmt = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
      fabLayoutFmt.gravity = Gravity.BOTTOM or Gravity.END

      fab.layoutParams = fabLayoutFmt

      main.addView(fab)

      app.setContentView(main)
    }
  }
}
