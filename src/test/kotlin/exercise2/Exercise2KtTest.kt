package exercise2

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Exercise2KtTest : StringSpec() {
    init {
        "add function adds two integers" {
            add(1, 2) shouldBe 3
        }

        "negate function negates an integer" {
            negate(1) shouldBe -1
            negate(0) shouldBe 0
            negate(-1) shouldBe 1
        }

        "map returns a new list resulting from applying a function to each element of the original list" {
            map(listOf(1, 2, 3)) { it * 2 } shouldBe listOf(2, 4, 6)

            map(listOf(1, 2, 3), negate) shouldBe listOf(-1, -2, -3)
        }

        "addN returns a function that adds n to its argument" {
            val addOne = addN(1)
            addOne(2) shouldBe 3
        }

        "buildString accepts a lambda argument that can be used to build up a String" {
            val products = listOf(
                Product(1, "Shoes", 79.99),
                Product(2, "Bluetooth Speaker", 249.0),
                Product(3, "4K TV", 1999.99)
            )

            val csv = buildString {
                append("id,product_name,price")
                append("\n")

                products.map {
                    append("${it.id},${it.name},${it.price}")
                    append("\n")
                }
            }

            csv.trim() shouldBe """
                id,product_name,price
                1,Shoes,79.99
                2,Bluetooth Speaker,249.0
                3,4K TV,1999.99
            """.trimIndent()
        }
    }
}

data class Product(val id: Int, val name: String, val price: Double)
