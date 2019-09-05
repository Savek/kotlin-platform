package pl.com.kmazur

import sample.OpcodeServer
import kotlin.browser.document
import kotlin.js.Math
import kotlin.math.floor

external fun require(module: String): dynamic

fun main() {

    document.addEventListener("DOMContentLoaded", {
        dynamic()
        pixi()
    })

}

fun dynamic() {
    document.getElementById("foo")
            ?.appendChild(document.createTextNode(OpcodeServer.ENUM_1.value))
}


fun pixi() {

    val app = Application(
            width = 700,
            height = 600,
            options = applicationOptions(0x1099bb))

    val canvas = document.getElementById("webglCanvas")
    console.log(canvas)
    canvas?.appendChild(app.view)

    val container = Container()
    app.stage.addChild(container)

    val texture = Texture.from("assets/bunny.png")

    for (i in 0 until 25) {
        val bunny = Sprite(texture)
        bunny.anchor.set(0.5)
        bunny.x = (i % 5) * 40
        bunny.y = floor(i / 5.0) * 40
        container.addChild(bunny)
    }

    container.x = app.screen.width.toInt() / 2
    container.y = app.screen.height.toInt() / 2

    container.pivot.x = container.width.toInt() / 2
    container.pivot.y = container.height.toInt() / 2

    app.ticker.add({
        delta -> container.rotation = container.rotation.toDouble() - (0.01 * delta.toDouble())
    })
}