@file:JsQualifier("PIXI")

package pl.com.kmazur

@JsName("PIXI")
external class PIXI

open external class DisplayObject {
    var x: Number
    var y: Number
    var pivot: Point
    var rotation: Number
}

@JsName("Container")
open external class Container : DisplayObject {

    var width: Number
    var height: Number

    fun addChild(child: DisplayObject)
}

external class DisplayObjectContainer : Container

@JsName("Text")
external class Text(text: String) : DisplayObject

external class Graphics : Container {

    var alpha: Number
    var interactive: Boolean
    var cursor: String
    var text: String

    fun beginFill(color: Number, alpha: Number? = definedExternally): Graphics
    fun drawRect(x: Number, y: Number, width: Number, height: Number): Graphics
    fun endFill(): Graphics
}