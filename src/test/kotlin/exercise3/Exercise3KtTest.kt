package exercise3

import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

class Exercise3KtTest : StringSpec() {
    init {
        "Todo class is declared properly" {
            Todo::class.isData shouldBe true

            // make sure all the properties are read-only
            Todo::class.memberProperties.none { it is KMutableProperty1 } shouldBe true
        }

        "adding a todo to the state" {
            val state = State(todos = emptyList())

            val newTodo = Todo(id = 1, text = "first", done = false)
            val action = AddTodo(newTodo)

            val newState = reduce(state, action)

            newState.todos shouldContainExactly listOf(newTodo)
        }

        "deleting a todo" {
            val todoToDelete = Todo(id = 1, text = "testing", done = false)
            val otherTodo = Todo(id = 2, text = "something else", done = false)
            val state = State(todos = listOf(otherTodo, todoToDelete))

            val action = DeleteTodo(id = todoToDelete.id)

            val newState = reduce(state, action)

            newState.todos shouldContainExactly listOf(otherTodo)
        }

        // 💯 set enabled to true (or remove) if attempting the bonus
        "completing a todo".config(enabled = true) {
            val todoToUpdate = Todo(id = 1, text = "testing", done = false)
            val otherTodo = Todo(id = 2, text = "something else", done = false)
            val state = State(todos = listOf(todoToUpdate, otherTodo))

            val action = CompleteTodo(id = 1)

            val newState = reduce(state, action)

            newState.todos.first().done shouldBe true
            newState.todos.last() shouldBe otherTodo
        }

        "making Person class serializable to JSON" {
            val person = Person(name = "Bob", age = 30)

            person.toJson() shouldBe """{"name":"Bob","age":30}"""
        }
    }
}
