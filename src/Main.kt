import kotlin.math.sqrt

// Класс Точка
class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        return sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y))
    }
}

// Класс Треугольник
class Triangle(private val a: Point, private val b: Point, private val c: Point) {
    // Метод для вычисления координат центра описанной окружности
    fun getCircumcenter(): Point {
        // Используем формулы из геометрии:
        val aX = a.x
        val aY = a.y
        val bX = b.x
        val bY = b.y
        val cX = c.x
        val cY = c.y
        val D = 2 * ((bX - aX) * (cY - aY) - (bY - aY) * (cX - aX))
        val circumcenterX = ((aX * aX + aY * aY) * (bY - cY) + (bX * bX + bY * bY) * (cY - aY) + (cX * cX + cY * cY) * (aY - bY)) / D
        val circumcenterY = ((aX * aX + aY * aY) * (cX - bX) + (bX * bX + bY * bY) * (aX - cX) + (cX * cX + cY * cY) * (bX - aX)) / D
        return Point(circumcenterX, circumcenterY)
    }

    // Метод для вычисления радиуса описанной окружности
    fun getCircumradius(): Double {
        val circumcenter = getCircumcenter()
        return a.distanceTo(circumcenter)
    }
}

fun main() {
    println("Задача 4: Треугольник в окружности")
    print("Введите координаты вершины A треугольника (x, y): ")
    val aX = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val aY = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val a = Point(aX, aY)

    print("Введите координаты вершины B треугольника (x, y): ")
    val bX = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val bY = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val b = Point(bX, bY)

    print("Введите координаты вершины C треугольника (x, y): ")
    val cX = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val cY = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    val c = Point(cX, cY)

    val triangle = Triangle(a, b, c)

    val circumcenter = triangle.getCircumcenter()
    val circumradius = triangle.getCircumradius()

    println("Координаты центра описанной окружности: (${circumcenter.x}, ${circumcenter.y})")
    println("Радиус описанной окружности: $circumradius")
}
