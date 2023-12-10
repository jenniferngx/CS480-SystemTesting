//Nikoloz Bujiashvili and Jennifer Nguyen do ha 

// package project.system;

// public class AddUserFlowTest {
    
// }

package project.system.pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class AddTODOFlowTest  {

    @Test
    void firstSeleniumTest() {
        // select which driver to use
        WebDriver browser = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));


        // visit a page
        browser.get("http://localhost:8080");


        // add user
        WebElement button = browser.findElement(By.id("add-user-btn"));
        WebElement usernameField = browser.findElement(By.id("username"));
        usernameField.sendKeys("Nikoloz");
        button.click();

        // choose user to add todo
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement addTodoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        usernameField2.sendKeys("Nikoloz");
        addTodoButton.click();


        // add todo
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        description.sendKeys("Todo 1");
        WebElement addTodoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        addTodoButton2.click();
        


        


        // check add todo outcome
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));
        assertThat(success.getText()).isEqualTo("Success: Nikoloz exists and added todo -> Todo 1");


        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-btn")));
        backButton.click();




        browser.quit();
    }

    
}


