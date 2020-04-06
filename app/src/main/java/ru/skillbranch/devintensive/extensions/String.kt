package ru.skillbranch.devintensive.extensions

private val ALPHABET_TRANSLIT = hashMapOf<String, String>(
    "а" to "a",
    "б" to "b",
    "в" to "v",
    "г" to "g",
    "д" to "d",
    "е" to "e",
    "ё" to "yo",
    "ж" to "zh",
    "з" to "z",
    "и" to "i",
    "ӣ" to "i",
    "к" to "k",
    "л" to "l",
    "м" to "m",
    "н" to "n",
    "о" to "o",
    "п" to "p",
    "р" to "r",
    "с" to "s",
    "т" to "t",
    "у" to "u",
    "ф" to "f",
    "х" to "h",
    "ц" to "c",
    "ч" to "ch",
    "ш" to "sh",
    "щ" to "sh",
    "ъ" to "",
    "ы" to "i",
    "ь" to "",
    "э" to "e",
    "ю" to "yu",
    "я" to "ya"
)

fun String.translitChar(char: Char) = if ("${char.toLowerCase()}" in ALPHABET_TRANSLIT.keys) ALPHABET_TRANSLIT["${char.toLowerCase()}"] else "${char.toLowerCase()}"