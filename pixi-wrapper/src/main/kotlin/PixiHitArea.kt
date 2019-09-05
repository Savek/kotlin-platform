@file:JsQualifier("PIXI")

package pl.com.kmazur

external interface HitArea {
    fun contains(x: Number, y: Number): Boolean
}

external class Rectangle(x: Number? = definedExternally,
                         y: Number? = definedExternally,
                         width: Number? = definedExternally,
                         height: Number? = definedExternally) : HitArea {

    val x: Number
    val y: Number
    val width: Number
    val height: Number
    val type: Number
    val left: Number
    val right: Number
    val top: Number
    val bottom: Number

    companion object {
        val EMPTY: Rectangle
    }

    fun clone(): Rectangle
    fun ceil(resolution: Number? = definedExternally, eps: Number = definedExternally)
    fun copy(rectangle: Rectangle): Rectangle
    override fun contains(x: Number, y: Number): Boolean
    fun pad(paddingX: Number, paddingY: Number)
    fun fit(rectangle: Rectangle)
    fun enlarge(rectangle: Rectangle)
}