package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.sign

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

//fun declOfNum(number: Int, titles: List<String>)
//{
//    val cases = listOf(2, 0, 1, 1, 1, 2)
//    return titles[ (number%100&gt;4 && number%100&lt;20)? 2 : cases[(number%10&lt;5)?number%10:5] ];
//}

fun Date.humanizeDiff(): String {

    val diffDate: Long = kotlin.math.abs(Date().time - this.time)
    val sign = Date().time - this.time <= 0

    val text = when {
        (diffDate >= 0L) and (diffDate < SECOND) -> "только что"
        (diffDate >= 1) and (diffDate < 45 * SECOND) -> "${if (sign) "через " else ""}несколько секунд${if (!sign) " назад " else ""}"
        (diffDate >= 45 * SECOND) and (diffDate < 75 * SECOND) -> "${if (sign) "через " else ""}минуту${if (!sign) " назад " else ""}"
        (diffDate >= 75 * SECOND) and (diffDate < 45 * MINUTE) -> "${if (sign) "через " else ""}${diffDate/ MINUTE} ${if (diffDate/ MINUTE % 100 >= 11 && diffDate/MINUTE <= 19 || diffDate/MINUTE % 10 >= 5 || diffDate/ MINUTE == 0L) "минут" else if (diffDate/MINUTE == 1L) "минуту" else "минут"}${if (!sign) " назад " else ""}"
        (diffDate >= 45 * MINUTE) and (diffDate < 75 * MINUTE) -> "${if (sign) "через " else ""}час${if (!sign) " назад " else ""}"
        (diffDate >= 75 * MINUTE) and (diffDate < 22 * HOUR) -> "${if (sign) "через " else ""}${diffDate/ HOUR} ${if (diffDate/HOUR % 100 >= 11 && diffDate/HOUR <= 19 || diffDate/HOUR % 10 >= 5 || diffDate/ HOUR == 0L) "часов" else if (diffDate/ HOUR == 1L) "час" else "часа"}${if (!sign) " назад " else ""}"
        (diffDate >= 22 * HOUR) and (diffDate < 26 * HOUR) -> "${if (sign) "через " else ""}день${if (!sign) " назад " else ""}"
        (diffDate >= 26 * HOUR) and (diffDate < 365 * DAY) -> "${if (sign) "через " else ""}${diffDate/ DAY} ${if (diffDate/DAY % 100 >= 11 && diffDate/DAY <= 19 || diffDate/DAY % 10 >= 5 || diffDate/ DAY == 0L) "дней" else if (diffDate/DAY == 1L) "день" else "дня"}${if (!sign) " назад " else ""}"
        else -> {
            if (sign) "более чем через год" else "более года назад"
        }
    }

    return text
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}