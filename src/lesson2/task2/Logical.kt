@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    var digit = number
    val firstDigit = digit / 1000
    digit %= 1000
    val secondDigit = digit / 100
    digit %= 100
    val thirdDigit = digit / 10
    val forthDigit = digit % 10
    if (firstDigit + secondDigit == thirdDigit + forthDigit) {
        return true
    }
    return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val horizontalThreaten: Boolean = x1 == x2
    val verticalThreaten: Boolean = y1 == y2
    val diagonalThreaten: Boolean = (x1 - x2).absoluteValue == (y1 - y2).absoluteValue
    if (horizontalThreaten || verticalThreaten || diagonalThreaten) return true
    return false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month % 2 > 0 || month == 8) {
        return 31
    } else {
        if (year % 4 == 0 && month == 2) {
            return 29
        } else if (year % 4 > 0 && month == 2) {
            return 28
        }
        return 30
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 * Расстояние между двумя точками равно квадратному корню из суммы квадратов разностей координат по каждой оси.
 * Расстояние между центрами меньше разности радиусов:
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val distance = sqrt((x1-x2).pow(2) + (y1-y2).pow(2))
    if (distance <= ((r1 - r2).absoluteValue)) {
        return true
    }
    return false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    if (r >= a || r >= b || r >= c && s >= a || s >= b || s >= c) {
        return true
    }
    return false
}
