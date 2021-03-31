package com.shawpoo.http.app.service

import android.content.Context

/**
 * @author: wuxiaopeng
 * @date: 2021/3/30
 * @desc:
 */
object HtmlManager {

    var params: String? = null

    fun getHtmlContent(context: Context, name: String): String {
        val input = context.assets.open(name)
        val buffer = ByteArray(input.available())
        input.read(buffer)
        input.close()
        return String(buffer)
    }

}