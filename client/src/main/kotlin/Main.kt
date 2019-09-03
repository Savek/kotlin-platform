package pl.com.kmazur

import sample.OpcodeServer
import kotlin.browser.document

fun main() {

    document.addEventListener("DOMContentLoaded", {
        dynamic()
    })

}

fun dynamic() {
    document.getElementById("foo")
            ?.appendChild(document.createTextNode(OpcodeServer.ENUM_1.value))
}