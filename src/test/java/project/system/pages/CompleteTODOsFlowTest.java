//Nikoloz Bujiashvili and Jennifer Nguyen do ha 

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

public class CompleteTODOsFlowTest {
    @Test
    void completeTODosTest(){
        WebDriver browser = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        browser.get("http://localhost:8080"); 


        // add user
        WebElement button = browser.findElement(By.id("add-user-btn"));
        WebElement usernameField = browser.findElement(By.id("username"));
        usernameField.sendKeys("Zul");
        button.click();



        // choose user to completeTODOs

        WebElement completeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("complete-btn")));
        WebElement username = browser.findElement(By.id("username"));
        username.sendKeys("Zul");



        // completeTODOs, check that outcome is "No TODOs" (user has no task)
        completeButton.click();
        WebElement todo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-th")));
        assertThat(todo.getText()).isEqualTo("No TODOs for Zul");



        // choose user to addTODO
        WebElement username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement addTodoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        username2.sendKeys("Zul");
        addTodoButton.click();



        // addTODO, check that todo is added, return to main page
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        description.sendKeys("Todo 1");
        WebElement addTodoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        addTodoButton2.click();




        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));
        assertThat(success.getText()).isEqualTo("Success: Zul exists and added todo -> Todo 1");
        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-btn")));
        backButton.click();


        // completeTODOs, check that outcome is "No TODOs" (because new user has no task)
        WebElement completeButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("complete-btn")));
        WebElement username3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username3.sendKeys("Zul");
        completeButton2.click();
        WebElement todo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-th")));
        assertThat(todo2.getText()).isEqualTo("Completed TODOs for Zul");


        browser.quit();

    }
}
