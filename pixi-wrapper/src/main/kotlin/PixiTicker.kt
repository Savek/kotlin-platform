@file:JsQualifier("PIXI")

package pl.com.kmazur

open external class TickerListener(fn: (deltaTime: Number) -> Unit,
                                   context: Any? = definedExternally,
                                   priority: Number? = definedExternally,
                                   once: Boolean? = definedExternally) {

    var fn: (deltaTime: Number) -> Unit
    var context: Any
    var priority: Number
    var once: Boolean
    var next: TickerListener
    var previous: TickerListener

    protected var _destroyed: Boolean
    fun match(fn: (deltaTime: Number) -> Unit, context: Any? = definedExternally): Boolean
    fun emit(deltaTime: Number): TickerListener
    fun connect(previous: TickerListener)
    fun destroy(hard: Boolean?)
}

open external class Ticker {
    protected var _tick: (time: Number) -> Unit
    protected var _head: TickerListener
    protected var _requestId: Number
    protected var _maxElapsedMS: Number

    var autoStart: Boolean
    var deltaTime: Number
    var elapsedMS: Number
    var lastTime: Number
    var speed: Number
    var started: Boolean

    protected fun _requestIfNeeded()
    protected fun _cancelIfNeeded()
    protected fun _startIfPossible()

    fun add(fn: (deltaTime: Number) -> Unit, context: Any? = definedExternally, priority: Number? = definedExternally): Ticker
    fun addOnce(fn: (deltaTime: Number) -> Unit, context: Any? = definedExternally, priority: Number? = definedExternally): Ticker
    fun remove(fn: (Any) -> Any, context: Any? = definedExternally, priority: Number? = definedExternally): Ticker

    protected fun _addListener(listener: TickerListener): Ticker

    val FPS: Number
    var minFPS: Number

    fun start()
    fun stop()
    fun destroy()
    fun update(currentTime: Number? = definedExternally)
}