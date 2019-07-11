package exercise2

// Exercise 2: Lambdas
// https://kotlinlang.org/docs/reference/lambdas.html

// 🧠 define a lambda "add" that adds two integers
// ℹ️ lambda syntax is: { arg1: Type, arg2: Type -> [body with last line as implicit return value] }

val add = TODO("define the lambda expression here")

// 🧠 define a lambda "negate" that negates an integer



// 🧠 define a function "map" that takes two arguments: a List<Int> and a function of type (Int) -> Int.
// It should return the list that results from applying the function to each element of the given list
// ℹ️ You can call mutableListOf<Int>() to create an empty list that is ready to have things added to it



// 🧠 define a function "addN" that takes an Int "n" and returns a function that takes another Int and adds n to it
// example usage:
//      val addOne = addN(1)
//      val three = addOne(2)



// 🧠 define a function "buildString" that takes as its argument a lambda with receiver type. It should provide the caller
// access to an instance of the StringBuilder class to build up a string within the lambda and then return the result.
// ℹ️ StringBuilder is a Java class that allows for building up a String iteratively in a more efficient way then simple
// concatenation. The final result can be obtained from the StringBuilder by calling its "toString" method.

// ℹ️ A lambda with a receiver type can be defined in the form A.(B) -> C
// This means the lambda can be invoked on instances of type A and that within the lambda the instance of A that it
// was invoked on will be implicitly bound to "this". See the test case for example usage.


