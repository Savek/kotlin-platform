@file:JsQualifier("PIXI")

package pl.com.kmazur

import org.w3c.dom.HTMLCanvasElement

external interface StageOptions {
    val children: Boolean?
    val texture: Boolean?
    val baseTexture: Boolean?
}

external class Application {
    constructor(options: ApplicationOptions? = definedExternally)
    constructor(
            width: Number? = definedExternally,
            height: Number? = definedExternally,
            options: ApplicationOptions? = definedExternally,
            noWebGL: Boolean? = definedExternally,
            sharedTicker: Boolean? = definedExternally,
            sharedLoader: Boolean? = definedExternally
    )

    val _ticker: Ticker

    val renderer: Any
    val stage: Container
    val ticker: Ticker
    val loader: Any
    val screen: Rectangle

    fun stop()
    fun start()
    fun render()
    fun destroy(removeView: Boolean?, stageOptions: StageOptions?)

    val view: HTMLCanvasElement
}

external interface ApplicationOptions : RendererOptions {
    val sharedTicker: Boolean?
        get() = definedExternally
    val sharedLoader: Boolean?
        get() = definedExternally
    val autoStart: Boolean?
        get() = definedExternally
}

external interface RendererOptions {
    var backgroundColor: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external class Texture {
    companion object {
        fun from(source: Any): Texture
    }
}

external class Sprite(texture: Texture) : Container {
    val anchor: ObservablePoint = definedExternally
}

external class ObservablePoint(cb: () -> Unit, scope: Any? = definedExternally, x: Number? = definedExternally, y: Number? = definedExternally) : PointLike {

    fun clone(cb: (Any) -> Any, scope: Any? = definedExternally): ObservablePoint
    fun equals(p: PointLike): Boolean

    var cb: () -> Any
    var scope: Any
}

open external class PointLike {
    var x: Number = definedExternally
    var y: Number = definedExternally

    fun set(x: Number? = definedExternally, y: Number? = definedExternally)
    fun copy(point: PointLike)
}

external class Point(x: Number? = definedExternally, y: Number? = definedExternally) : PointLike {
    fun clone(): Point
    fun equals(p: PointLike): Boolean
}

//external interface RendererOptions {
//    val width: Number? get() = definedExternally
//    val height: Number? get() = definedExternally
//    val view: HTMLCanvasElement? get() = definedExternally
//    val transparent: Boolean? get() = definedExternally
//    val antialias: Boolean? get() = definedExternally
//    val preserveDrawingBuffer: Boolean? get() = definedExternally
//    val resolution: Number? get() = definedExternally
//    val forceCanvas: Boolean? get() = definedExternally
//    var backgroundColor: Number
//    val clearBeforeRender: Boolean? get() = definedExternally
//    val roundPixels: Boolean? get() = definedExternally
//    val forceFXAA: Boolean? get() = definedExternally
//    val legacy: Boolean? get() = definedExternally
//    val context: WebGLRenderingContext? get() = definedExternally
//    val autoResize: Boolean? get() = definedExternally
//    val powerPreference: String? get() = definedExternally
//}
