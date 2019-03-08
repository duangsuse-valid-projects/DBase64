package org.duangsuse.dbase64

import android.os.Bundle
import android.support.design.widget.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*

import android.view.*
import android.widget.*
import android.widget.FrameLayout.*

class App: AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
  lateinit var av: AppViewHolder

  // TODO support for decode/encode intent from File Manager
  // TODO color appbar
  // TODO animation

  override fun onCreate(oldInstanceStat: Bundle?) {
    super.onCreate(oldInstanceStat)

    av = setupUi(this)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId

    av.handleMenu(id)

    return super.onOptionsItemSelected(item)
  }

  override fun onClick(v: View) {
    (v as? FloatingActionButton)?.let { av.handleFabClick(it) }
  }

  override fun onLongClick(v: View): Boolean {
    (v as? FloatingActionButton)?.let { av.handleFabLongClick(it) }
    return false
  }

  companion object {
    // bad practice
    fun setupUi(app: App): AppViewHolder {
      val main = FrameLayout(app)

      val text = EditText(app)
      text.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
      text.setGravity(Gravity.TOP)
      text.hint = app.getString(R.string.hint_code)

      main.addView(text)

      val fab = FloatingActionButton(app)
      val fabLayoutFmt = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
      fabLayoutFmt.gravity = Gravity.BOTTOM or Gravity.END

      fab.layoutParams = fabLayoutFmt
      fab.setOnClickListener(app)
      fab.setOnLongClickListener(app)

      main.addView(fab)

      app.setContentView(main)

      return AppViewHolder(main, text, fab, app)
    }
  }
}
