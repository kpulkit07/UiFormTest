package com.accesshq.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {
    private WebDriver driver;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void selectState(String state) {
        driver.findElement(By.className("v-input__append-inner")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("[role=option]")));
        for (WebElement selectState: driver.findElements(By.cssSelector("[role=option]"))) {
            if (selectState.getText().equalsIgnoreCase(state)) {
                selectState.click();
            }
          //throw new NotFoundException("could not find" + state);
        }
    }

    public void agree() {
        driver.findElement(By.cssSelector("[for='agree']")).click();
    }

    public void submit() {
        for (WebElement button: driver.findElements(By.cssSelector("[type=button]"))) {
            if(button.getText().equalsIgnoreCase("submit")){
                button.click();
                break;
            }
        }
    }
}
