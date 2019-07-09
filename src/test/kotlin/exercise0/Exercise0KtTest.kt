package exercise0

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

// Run this test by putting your cursor here and pressing control + shift + R or clicking on the green button in the
// margin to the left of the class declaration below.

// Re-run it from anywhere by pressing control + R

// Not using IntelliJ? 😱
// Run ./gradlew test --tests "*Exercise0*" from the command line if you must
// You really should get the Community edition (https://www.jetbrains.com/idea/download) though or you will
// struggle needlessly on things like manually typing in import statements and lack of code completion

class Exercise0KtTest : StringSpec() {
    init {
        "increments 1 to 2" {
            increment(1) shouldBe 2
        }
    }
}
