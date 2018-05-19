package com.example.lenovo.statusbarnotif

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener{
            showNotfn()
        }
    }

    fun showNotfn(){
        val mgr=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
       val ntfn= if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O  ) {
            Notification
                    .Builder(this,"5678" )
                    .build()
        }else{
            Notification
                    .Builder(this)
                    .setTicker("This is Sample")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setWhen(System.currentTimeMillis())
                    .setDefaults(Notification.DEFAULT_ALL)
                    .build()
        }
        mgr.notify(1234,ntfn)
    }
}


