package com.shawpoo.http.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shawpoo.http.app.service.HtmlManager
import com.shawpoo.http.app.service.HttpService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val service = HttpService(this, 6868)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            try {
                service.start()
                println("服务开启成功")
            } catch (e: Exception) {
                println("服务开启失败，$e")
            }
        }

        btn_change.setOnClickListener {
            HtmlManager.params = "111"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        service?.stop()
    }

}