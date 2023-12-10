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
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrieveTODOsFlowTest {
    @Test
    void retrieveTODOTest() {
        //select driver, visit page
        WebDriver browser = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.get("http://localhost:8080"); 


        // add user
        WebElement button = browser.findElement(By.id("add-user-btn"));
        WebElement usernameField = browser.findElement(By.id("username"));
        usernameField.sendKeys("Jennifer");
        button.click();

        //Completing all todos just in case
        WebElement completeButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("complete-btn")));
        WebElement username3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username3.sendKeys("Jennifer");
        completeButton2.click();


        // retrieveTODO, check that outcome is "No TODOs" (new user has no task)
        WebElement retrieveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("retrieve-btn")));
        WebElement username = browser.findElement(By.id("username"));
        username.sendKeys("Jennifer");
        retrieveButton.click();
        WebElement todo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-th")));
        assertThat(todo.getText()).isEqualTo("No TODOs for Jennifer");



         // choose user to addTODO
         WebElement username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
         WebElement addTodoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
         username2.sendKeys("Jennifer");
         addTodoButton.click();
 
 
 
         // addTODO, check that todo is added, return to main page
         WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
         description.sendKeys("Todo 1");
         WebElement addTodoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
         addTodoButton2.click();
 
 
 
         WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));
         assertThat(success.getText()).isEqualTo("Success: Jennifer exists and added todo -> Todo 1");


         WebElement description2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        description2.sendKeys("Todo 2");
        WebElement addTodoButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        addTodoButton3.click();

         WebElement success2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));
        assertThat(success2.getText()).isEqualTo("Success: Jennifer exists and added todo -> Todo 2");


         WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-btn")));
         backButton.click();
 
 
         // completeTODOs, check that outcome is two todos that we added
         WebElement retrieveButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("retrieve-btn")));
         WebElement username4 = browser.findElement(By.id("username"));
         username4.sendKeys("Jennifer");
         retrieveButton2.click();
         WebElement todo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("todos")));
         assertThat(todo2.getText()).contains("Todo 1");
         assertThat(todo2.getText()).contains("Todo 2");
        //  assertThat(todo2.getText()).contains("Todo 2");
         



        browser.quit();

    }


}
