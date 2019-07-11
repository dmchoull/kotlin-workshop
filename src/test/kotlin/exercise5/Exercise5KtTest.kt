package exercise5

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Exercise5KtTest : StringSpec() {
    init {
        "generates mars rovers input" {
            val roverInput = mission {
                plateau(width = 5, length = 6)

                rover(x = 1, y = 2, direction = "N", commands = "MMRML")

                rover(x = 3, y = 4, direction = "E", commands = "MRMRM")
            }

            roverInput shouldBe """
                5 6
                1 2 N
                MMRML
                3 4 E
                MRMRM
            """.trimIndent()
        }
    }
}
