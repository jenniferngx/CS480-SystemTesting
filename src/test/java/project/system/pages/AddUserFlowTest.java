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

public class AddUserFlowTest  {

    @Test
    void addUserTest() {
        // select which driver to use
        WebDriver browser = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));


        // visit a page
        browser.get("http://localhost:8080");


        //check whether user already exist by trying to addTODO
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement addTodoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        user.sendKeys("Leo");
        addTodoButton.click();

        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        description.sendKeys("Todo 1");
        WebElement addTodoButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-todo-btn")));
        addTodoButton2.click();


        // check add todo outcome to see if user already exists
        WebElement outcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));
        boolean userExists = true;
        if (outcome.getText().equals("Error: Leo username does not exist!")){
            userExists = false;
        }
        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-btn")));
        backButton.click();


        // add user and assert appropriate result
        WebElement addUserButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-user-btn")));
        WebElement user2 = browser.findElement(By.id("username"));
        user2.sendKeys("Leo");
        addUserButton.click();
        WebElement output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outcome-th")));

        if (!userExists) {
            assertThat(output.getText()).isEqualTo("Success: Leo username was added!");
        } else {
            assertThat(output.getText()).isEqualTo("Error: Leo username already exists!");
        }


        // close the browser and the selenium session
        browser.quit();
        // browser.close();
        
    }

    
}

