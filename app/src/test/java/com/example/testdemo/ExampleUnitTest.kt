package com.example.testdemo

import com.example.testdemo.Utility.EmailValidator
import com.example.testdemo.Utility.isValidEmail
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(isValidEmail("name@email.com"))
    }
}