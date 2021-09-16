package com.advanced.functions


fun main(args: Array<String>) {
    val html = html {
        body {
            div { "this is my div" }
            div { "this is my div" }
            p { "this is something else" }
        }
    }
    println(html)
}


class HTML(var body: Body) {
    fun body(init: Body.() -> Unit) {
        val newBody = Body()
        newBody.init()
        body = newBody
    }
}

class Body {
    fun div(init: Div.() -> Unit) {
        val div = Div()
        div.init()
        // children.add(div)
    }

    fun p(init: P.() -> Unit) {

    }
}

class Div(var content: String = "") {
   operator fun invoke(string: String) {
       content = string
   }
}
data class P (var content: String)

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML(Body())
    html.init()
    return html
}