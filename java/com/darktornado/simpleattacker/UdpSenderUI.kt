package com.darktornado.simpleattacker

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

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
        txt4.inputType = InputType.TYPE_CLASS_NUMBER
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
        txt8.inputType = InputType.TYPE_CLASS_NUMBER
        layout.addView(txt8)
        val txt9 = TextView(ctx)
        txt9.text = "\nDelay : "
        txt9.textSize = 18f
        layout.addView(txt9)
        val txt10 = EditText(ctx)
        txt10.hint = "Input Delay..."
        txt10.inputType = InputType.TYPE_CLASS_NUMBER
        layout.addView(txt10)
        val send = Button(ctx)
        send.text = "Start"
        send.transformationMethod = null
        send.setOnClickListener {
            val ip = txt2.text.toString()
            val port = txt4.text.toString().toInt()
            val value = txt6.text.toString()
            val count = txt8.text.toString().toInt()
            val delay = txt10.text.toString().toLong()
            val sent = sendPacket(ip, port, value)
            if (sent) toast("Maybe it was sent?")
        }
        layout.addView(send)

        val pad = dip2px(16)
        layout.setPadding(pad, pad, pad, pad)
        val scroll = ScrollView(ctx)
        scroll.addView(layout)
        view = scroll
    }

    fun sendPacket(ip: String, port: Int, value: String): Boolean {
        try {
            val socket = DatagramSocket()
            val buf: ByteArray = value.toByteArray()
            socket.send(DatagramPacket(buf, buf.size, InetAddress.getByName(ip), port))
            socket.close()
            return true
        } catch (e: Exception) {
            toast(e.toString())
            return false
        }
    }

    fun toast(msg: String) = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()

    fun dip2px(dips: Int) = Math.ceil((dips * ctx.getResources().getDisplayMetrics().density).toDouble()).toInt()

}