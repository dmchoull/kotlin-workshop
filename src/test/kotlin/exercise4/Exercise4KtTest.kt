package exercise4

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Exercise4KtTest : StringSpec() {
    init {
        val intList = listOf(1, 2, 3)
        val stringList = listOf("banana", "apple", "apricot")

        "findAny returns null when the item is not found" {
            val found = intList.findAny { item -> item as Int > 4 }
            found shouldBe null
        }

        "findAny returns the first item for which the predicate returns true" {
            val found = stringList.findAny { item -> (item as String).startsWith("a") }
            found shouldBe "apple"
        }

        "findGeneric returns null when the item is not found" {
            val found = intList.findGeneric { item -> item > 4 }
            found shouldBe null
        }

        "findGeneric returns the first item for which the predicate returns true" {
            val found = stringList.findGeneric { item -> item.startsWith("a") }
            found shouldBe "apple"
        }

        "Some - getOrElse returns its wrapped value" {
            Some(1).getOrElse(0) shouldBe 1
        }

        "None - getOrElse returns the default value" {
            None<Int>().getOrElse(0) shouldBe 0
        }

        "Some - map applies the transformation function to its value and returns a Some containing the new value" {
            Some(1).map { it.toString() }.map { it shouldBe "1" }
        }

        "None - map does not apply the transformation" {
            (None<Int>().map { it.toString() } is None) shouldBe true
        }

        "combined Maybe usage example" {
            fun <T> List<T>.findMaybe(item: T): Maybe<T> {
                val result = this.find { it == item }

                return result?.let { foundItem -> Some(foundItem) } ?: None()
            }

            listOf(1, 2, 3)
                .findMaybe(2)
                .map { it * 100 }
                .map { it.toString() }
                .getOrElse("not found") shouldBe "200"

            // we can safely attempt to apply our transformations to a None with no effect
            listOf(1, 2, 3)
                .findMaybe(5)
                .map { it * 100 }
                .map { it.toString() }
                .getOrElse("not found") shouldBe "not found"
        }
    }
}
