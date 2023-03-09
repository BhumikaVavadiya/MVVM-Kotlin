package com.example.testdemo.Ui

import com.example.testdemo.Utility.EmailValidator
import com.example.testdemo.Utility.isValidEmail
import org.junit.Assert
import org.junit.Test


internal class LoginActivityTest{

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        Assert.assertTrue(isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_CorrectFirstLastEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(isValidEmail("firstname.lastname@email.com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        Assert.assertFalse(isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        Assert.assertFalse(isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        Assert.assertFalse(isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        Assert.assertFalse(isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        Assert.assertFalse(isValidEmail(null))
    }

    @Test
    fun emailValidator_DashEmail_ReturnsFalse() {
        Assert.assertFalse(isValidEmail("name@-email.com"))
    }

    @Test
    fun emailValidator_MissAtTheRateEmail_ReturnsFalse() {
        Assert.assertFalse(isValidEmail("name.email.com"))
    }

    @Test
    fun onSucess() {
    }

    @Test
    fun onFailure() {

    }

}