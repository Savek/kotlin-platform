package pl.com.kmazur

inline fun applicationOptions(backgroundColor: Int?): ApplicationOptions {
    val jsonObject = js("({})")

    jsonObject["backgroundColor"] = backgroundColor

    return jsonObject
}
