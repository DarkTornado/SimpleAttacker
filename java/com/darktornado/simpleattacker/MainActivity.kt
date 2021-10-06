package com.darktornado.simpleattacker

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import com.darktornado.library.BottomNavigationLayout


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.enableDefaults()
        val udp = UdpSenderUI(this)
        val http = HttpRequesterUI(this)
        val layout = BottomNavigationLayout(this)
        layout.addView(udp.view)
        layout.setBottomBackgroundColor(Color.parseColor("#EEEEEE"));
        layout.addBottomButton("UDP", android.R.drawable.ic_menu_send, getRipple()) {
            layout.replace(udp.view)
        }
        layout.addBottomButton("HTTP", android.R.drawable.ic_menu_send, getRipple()) {
            layout.replace(http.view)
        }
        layout.setBackgroundColor(Color.WHITE);
        setContentView(layout);
    }

    fun getRipple(): Drawable {
        val color: Int = Color.parseColor("#EEEEEE")
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable(ColorStateList.valueOf(Color.WHITE), ColorDrawable(color), null)
        } else {
            ColorDrawable(color)
        }
    }

}