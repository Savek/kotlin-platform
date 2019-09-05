package pl.com.kmazur

import org.w3c.dom.HTMLElement
import kotlin.browser.document

@JsName("TextInput")
class TextInput : Container {

    var domInput: HTMLElement
    var surogateHitBox: Graphics
    var surogateText: Text

    constructor(placeholder: String,
                styles: InputStyles = InputStyles(emptyMap(), emptyMap())) {
        val input = document.createElement("input") as HTMLElement

        styles.input.forEach { entry ->
            input.style.setProperty(entry.key, entry.value)
        }

        domInput = input
        println(domInput)

        surogateHitBox = Graphics()
        surogateHitBox.alpha = 0
        surogateHitBox.interactive = true
        surogateHitBox.cursor = "text"

        surogateHitBox.text = placeholder
        surogateHitBox.beginFill(0xfffffff)
        surogateHitBox.drawRect(0, 0, 500, 20)
        surogateHitBox.endFill()

        surogateText = Text(placeholder)
        this.addChild(surogateText)
        this.addChild(surogateHitBox)
    }

}

data class InputStyles(val input: Map<String, String>,
                       val box: Map<String, String>)