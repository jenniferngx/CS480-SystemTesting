package project.system.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWebPage extends TODOParentPage{
     public HomeWebPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isReady() {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("todos")));
    }
    public void retrieveTodos(String name) {

        driver.findElement(By.id("username")).sendKeys(name);
        WebElement retrieveButton = driver.findElement(By.id("retrieve-btn"));
        retrieveButton.click();

        // this.isReady();
    }

    public List<String> retrieveTodos() {
        List<String> todos = new ArrayList<>();

        WebElement table = driver.findElement(By.id("todos"));
        List<WebElement> rows = table.findElements(By.tagName("li"));
        System.out.println(rows.size());

        for (WebElement row : rows) {

            String todo = row.findElement(By.tagName("div")).getText().trim();
            todos.add(todo);
        }

        return todos;
    }
    public void visit() {
       super.visit("");
    }
}