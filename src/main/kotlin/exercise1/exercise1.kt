package exercise1

// Exercise 1: Basics
// https://kotlinlang.org/docs/reference/basic-types.html
// https://kotlinlang.org/docs/reference/functions.html
// https://kotlinlang.org/docs/reference/extensions.html

// 🧠 define a variable named "theAnswer" with the value 42
const val theAnswer = 42

// 🧠 define a function "greet" that returns the string "Hello, [insert name here]!", given a name
fun greet(name: String) = "Hello, $name!"

// 🧠 define a function "add" which calculates the sum of two integers
fun add(a: Int, b: Int) = a + b

// 🧠 define a function "sum" which calculates the sum of a list of integers
// without using the sum function from the kotlin standard library (ℹ️ i.e. write a for( ... in ...) loop)
// bonus: reuse the code between both versions

// 🧠 version one: accept an argument of type List<Int>
fun sum(numbers: List<Int>): Int {
    var sum = 0
    for (element in numbers) {
        sum += element
    }
    return sum
}

// 🧠 version two: accept a vararg Int argument
// https://kotlinlang.org/docs/reference/functions.html#variable-number-of-arguments-varargs
fun sum(vararg numbers: Int) = sum(numbers.toList())

// 🧠 extend the Int type with even and odd functions
fun Int.even() = this % 2 == 0

fun Int.odd() = this % 2 != 0

// 🧠 write a function "median" that can be called on any list of integers to calculate the median

// Definition: The median of a set of data is the middlemost number in the set. The median is also
// the number that is halfway into the set. To find the median, the data should first be arranged
// in order from least to greatest.

// If there are an odd number of elements then it is the middle element. Otherwise it is calculated
// by taking the average of the two middle numbers.

fun List<Int>.median(): Double {
    val sortedList = sorted()

    return if (size.even()) {
        (sortedList[size / 2 - 1] + sortedList[size / 2]) / 2.0
    } else {
        sortedList[size / 2].toDouble()
    }
}
