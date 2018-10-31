package com.laibao.kotlin.servletstack

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author laibao wang
 */
@WebServlet("/hello")
class HelloWorldController : HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        this.doGet(req,resp)
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.writer.write("Hello, World!")
    }
}