package com.haulmont.masquerade

import com.haulmont.masquerade.composite.GroovyLoginWindow
import org.junit.Test

import static com.codeborne.selenide.Selenide.open
import static com.haulmont.masquerade.Components.wire
import static org.junit.Assert.assertNotNull

class GroovyLoginTest {
    @Test
    void login() {
        open("http://localhost:8080/app")

        def loginWindow = wire(GroovyLoginWindow, 'loginMainBox')

        assertNotNull(loginWindow.loginField)
        assertNotNull(loginWindow.passwordField)

        loginWindow.loginField.value = "masquerade"
        loginWindow.passwordField.value = "rulezzz"
        loginWindow.loginButton.click()
    }
}