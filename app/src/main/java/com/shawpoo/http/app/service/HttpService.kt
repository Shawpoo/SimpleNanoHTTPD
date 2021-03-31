package com.shawpoo.http.app.service

import android.content.Context
import fi.iki.elonen.NanoHTTPD

/**
 * @author: wuxiaopeng
 * @date: 2021/3/30
 * @desc:
 */
class HttpService(private val context: Context, port: Int) : NanoHTTPD(port) {

    override fun serve(session: IHTTPSession): Response {
        print("$session")
        if (session.parms["aaa"] == "111") {
            return newFixedLengthResponse(
                Response.Status.OK,
                MIME_HTML,
                HtmlManager.getHtmlContent(context, "test2.html")
            )
        }
        if (HtmlManager.params == "111") {
            return newFixedLengthResponse(
                Response.Status.OK,
                MIME_HTML,
                HtmlManager.getHtmlContent(context, "test0.html")
            )
        }
        return newFixedLengthResponse(
            Response.Status.OK,
            MIME_HTML,
            HtmlManager.getHtmlContent(context, "test.html")
        )
    }

}