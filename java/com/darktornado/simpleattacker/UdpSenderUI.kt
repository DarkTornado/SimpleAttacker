package com.darktornado.simpleattacker

import android.content.Context
import android.view.View
import android.widget.*

class UdpSenderUI (val ctx: Context) {

    var view: View? = null

    init {
        val layout = LinearLayout(ctx)
        layout.orientation = 1
        val txt1 = TextView(ctx)
        txt1.text = "IP : "
        txt1.textSize = 18f
        layout.addView(txt1)
        val txt2 = EditText(ctx)
        txt2.hint = "Input IP..."
        layout.addView(txt2)
        val txt3 = TextView(ctx)
        txt3.text = "\nPort : "
        txt3.textSize = 18f
        layout.addView(txt3)
        val txt4 = EditText(ctx)
        txt4.hint = "Input Port..."
        layout.addView(txt4)
        val txt5 = TextView(ctx)
        txt5.text = "\nValue : "
        txt5.textSize = 18f
        layout.addView(txt5)
        val txt6 = EditText(ctx)
        txt6.hint = "Input Value..."
        layout.addView(txt6)
        val txt7 = TextView(ctx)
        txt7.text = "\nCount : "
        txt7.textSize = 18f
        layout.addView(txt7)
        val txt8 = EditText(ctx)
        txt8.hint = "Input Count..."
        layout.addView(txt8)
        val txt9 = TextView(ctx)
        txt9.text = "\nDelay : "
        txt9.textSize = 18f
        layout.addView(txt9)
        val txt10 = EditText(ctx)
        txt10.hint = "Input Delay..."
        layout.addView(txt10)
        val send = Button(ctx);
        send.text = "Start";
        send.transformationMethod = null
        layout.addView(send)

        val pad = dip2px(16)
        layout.setPadding(pad, pad, pad, pad)
        val scroll = ScrollView(ctx)
        scroll.addView(layout)
        view = scroll
    }

    fun dip2px(dips: Int) = Math.ceil((dips * ctx.getResources().getDisplayMetrics().density).toDouble()).toInt()

}