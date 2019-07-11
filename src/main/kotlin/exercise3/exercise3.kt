package exercise3

// Exercise 3: Classes and Interfaces
// https://kotlinlang.org/docs/reference/classes.html
// https://kotlinlang.org/docs/reference/data-classes.html
// https://kotlinlang.org/docs/reference/sealed-classes.html

// ℹ️ Here is a simple data class that contains a list of Todos. This line of code defines the class, its primary
// constructor which takes a List of Todos, and a class property called todos that has a getter only. Declaring class
// properties with var instead of val results in a setter being defined as well. Using the data keyword results in
// a bunch of methods being defined for us but adds a few constraints to our class as well, such as not being able to
// sub-class it.

data class State(val todos: List<Todo>)

// 🧠 define a data class called Todo
// it should have three read-only (val) properties:
//   * id of type Int
//   * text of type String
//   * done of type Boolean

data class Todo(val id: Int, val text: String, val done: Boolean)

// We have an abstract Action class and one currently supported action, AddTodo, for our todo app

sealed class Action

data class AddTodo(val todo: Todo) : Action()

// 🧠 add another Action sub-class DeleteTodo that has a read-only property "id" of type Int

data class DeleteTodo(val id: Int) : Action()

data class CompleteTodo(val id: Int) : Action()

// 🧠 implement another case in the reduce function below to handle DeleteTodo
// DeleteTodo should remove the Todo with the given id from the state
// ℹ️ Your implementation should be similar to the AddTodo case, but look for ways to filter the list to contain
// only the desired items

fun reduce(state: State, action: Action): State {
    return when (action) {
        is AddTodo -> state.copy(todos = state.todos + action.todo)

        is DeleteTodo -> state.copy(todos = state.todos.filterNot { it.id == action.id })

        is CompleteTodo -> {
            val updatedTodos = state.todos.map { if (it.id == action.id) it.copy(done = true) else it }
            return state.copy(todos = updatedTodos)
        }
    }
}

// 💯 Bonus: add another Action sub-class CompleteTodo(val id: Int) and implement the reducer case to update
// the Todo with that id to be marked as done


// 🧠 make the class Person below implement the JsonSerializable interface

interface JsonSerializable {
    fun toJson(): String
}

class Person(val name: String, val age: Int) : JsonSerializable {
    override fun toJson(): String {
        return """{"name":"$name","age":$age}"""
    }
}
