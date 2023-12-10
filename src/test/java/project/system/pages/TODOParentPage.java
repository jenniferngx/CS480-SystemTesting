//Nikoloz Bujiashvili and Jennifer Nguyen do ha 
package project.system.pages;

import org.openqa.selenium.WebDriver;
public abstract class TODOParentPage {
    
    protected final WebDriver driver;

    public TODOParentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        throw new RuntimeException("This page does not have a visit link");
    }

    protected void visit(String url) {
        driver.get("http://localhost:8080" + url);
        isReady();
    }

    public abstract void isReady();
}
