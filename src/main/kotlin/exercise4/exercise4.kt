package exercise4

// Exercise 4: Generics
// https://kotlinlang.org/docs/reference/generics.html

// In exercise 2 we wrote a map function that could only map lists of integers. In this exercise, we will write a more
// generically useful find function that can be used on lists of any type. Our first attempt will do this by using the
// Any type

// 🧠 implement the findAny function by iterating through the list and returning the first element for which the
// predicate function returns true, or null if there is no such element.

fun List<Any>.findAny(predicate: (Any) -> Boolean): Any? {
    TODO("remove this and implement findAny")
}

// Our second attempt at making a find function will use generic types to allow our function to be used on lists of any
// type without losing type information and having to resort to casting

// ℹ️ In order to use a generic type parameter in your function definition, it must be declared after the "fun" keyword
// for example, here is a generic identity function:

fun <T> identity(thing: T): T {
    return thing
}

// ℹ️ https://kotlinlang.org/docs/reference/generics.html#generic-functions

// 🧠 define a function "findGeneric", which for some generic type T, can be called on any List of T, takes a predicate
// function that accepts an argument of type T, and returns a nullable T



// Maybe is a data type that represents the result of an operation that might fail. For example, attempting to extract
// text from a web page given some CSS selector or find a specific element in a list may or may not succeed.
// Such a function could use the Maybe type like so: fun extractText(selector: String): Maybe<String>

// In the case where the selector is found it would return the "Some" type of Maybe containing
// the extracted value: Some("extracted text")

// In the case where the selector is not found it would return None, which is a type of Maybe representing the absence
// of a value

// 🧠 implement the two subclasses of the Maybe type: Some and None by implementing the two operations getOrElse and map
// getOrElse returns the value of a Some or the default value if called on a None
// map on a Some applies a transformation function to its value and wraps the result back into another Some. The result
// of mapping a None should just propagate the None. See the tests for usage examples.

sealed class Maybe<T> {
    abstract fun getOrElse(defaultValue: T): T

    abstract fun <R> map(transform: (T) -> R): Maybe<R>
}

class Some<T>(private val value: T) : Maybe<T>()

class None<T> : Maybe<T>()
