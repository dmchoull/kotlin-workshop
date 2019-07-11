package exercise1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Exercise1KtTest : StringSpec() {
    init {
        "defines the correct answer" {
            theAnswer shouldBe 42
        }

        "returns a greeting message for the given name" {
            greet("World") shouldBe "Hello, World!"
        }

        "adds two numbers together" {
            add(1, 2) shouldBe 3
        }

        "calculates the sum of a list of integers" {
            sum(listOf(1, 2, 3, 4)) shouldBe 10

            sum(1, 2, 3, 4) shouldBe 10
        }

        "checks the parity of a number (even/odd)" {
            1.even() shouldBe false
            1.odd() shouldBe true

            2.even() shouldBe true
            2.odd() shouldBe false
        }

        "calculates the median of a list of integers" {
            listOf(1).median() shouldBe 1.0
            listOf(1, 1).median() shouldBe 1.0
            listOf(3, 1, 2).median() shouldBe 2.0
            listOf(4, 1, 2, 1).median() shouldBe 1.5
            listOf(5, 0, 2, 9, 8, 6, 9).median() shouldBe 6.0
        }
    }
}
