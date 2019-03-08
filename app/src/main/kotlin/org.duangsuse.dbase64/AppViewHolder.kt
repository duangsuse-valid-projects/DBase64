package org.duangsuse.dbase64

import android.support.design.widget.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*

import android.view.*
import android.widget.*
import android.widget.FrameLayout.*

import org.duangsuse.dbase64.R.id.*
import org.duangsuse.dbase64.coders.*

class AppViewHolder(val cont: FrameLayout, val text: EditText, val fab: FloatingActionButton, val app: App) {
  var isEncode: Boolean = true
  var coder: AbstractCoder = Base64Coder()
  var storage: PersistenceStorage = PersistenceStorage(app)

  fun handleMenu(id: Int) {
    val dispatch: Function0<Unit> = when (id) {
      s_encode -> ::code
      s_decode -> ::decode
      s_encode_file -> ::encodeFile
      s_decode_file -> ::decodeFile
      s_mode -> ::modeDialog
      s_opts -> ::optionsDialog
      s_showbar -> ::updateBar
      s_about -> ::about
      s_exit -> ::exit
      else -> { -> toast("Unknown operation") }
    }

    dispatch()
  }

  fun invert() {
    toast(app.getString(R.string.status_changed))
    isEncode = ! isEncode
  }
  fun doOperation() { if (isEncode) code() else decode() }

  fun handleFabClick(fab: FloatingActionButton) {
    assert (fab == this.fab)
    doOperation()
  }

  fun handleFabLongClick(fab: FloatingActionButton) {
    assert (fab == this.fab)
    invert()
  }

  fun code() {
    codeUpdateView()

    text.setText(coder.encode(text.text.toString()))
  }

  fun decode() {
    decodeUpdateView()

    lateinit var result: String
    try {
      result = coder.decode(text.text.toString())
    } catch (e: Exception) {
      e.message?.let(::toast)
      decodeErrorView()
      return
    }

    text.setText(result)
  }

  fun resetView() {
    app.titleColor = storage.scolor
  }

  fun codeUpdateView() {
    resetView()
    text.hint = app.getString(R.string.hint_code)
  }

  fun decodeUpdateView() {
    resetView()
    text.hint = app.getString(R.string.hint_decode)
  }

  fun decodeErrorView() {
    app.titleColor = 0xee0000
  }

  fun encodeFile() {}
  fun decodeFile() {}
  fun modeDialog() {}
  fun optionsDialog() {}
  fun updateBar() {}
  fun about() {}

  fun exit() = app.finish()

  fun toast(o: Any) = Toast.makeText(app, o.toString(), Toast.LENGTH_SHORT).show()
}
