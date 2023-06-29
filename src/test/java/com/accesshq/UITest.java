package com.accesshq;

import com.accesshq.Model.Form;
import com.accesshq.Model.Planet;
import com.accesshq.Model.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//public class UITest {
    /*  @Test
     public void uiPageTest() throws InterruptedException {
        //do not repeat
        WebDriver driver = getWebDriver();

         driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

                 driver.findElement(By.id("forename")).sendKeys("Pulkit");
                 driver.findElement(By.id("submit")).click();
                 String page = driver.findElement(By.tagName("H1")).getText();

                 if(page.equals("Web Playground")){
                     System.out.println("Heading Found");
                 }else {
                     System.out.println("no heading found");
                 }
           driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div/div[3]/div[2]/div[2]/a")).click();
             Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div/div[3]/div[2]/div[2]/a")).click();
         Thread.sleep(3000);

         driver.quit();
             }
 */
    public class UITest {
    private WebDriver driver;

    @BeforeEach
    public void openWindow() {
           driver = getWebDriver();
           driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
           driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofMillis(350));
    }

    @Test
    public void explorePlanet(){


        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
        PlanetPage planetPage = new PlanetPage(driver);
        planetPage.getPlanet(planet -> planet.getName().equalsIgnoreCase("Earth"));
        Assertions.assertEquals("Earth", );

        /*PlanetPage planetPage = new PlanetPage(driver);
        ArrayList<Planet> allPlanets = planetPage.getAllPlanets();
      //  Planet planet = planetPage.getPlanetByName("Earth", allPlanets);
        Planet planet = planetPage.getPlanetByDistance(4495000f, allPlanets);
        planet.clickExplore();
        //Assertions.assertEquals("Earth", planet.getName());

       /* for (WebElement planeElement: driver.findElements(By.className("planet"))){

            Planet planet = new Planet(planeElement);

            if(planeElement.findElement(By.tagName("h2")).getText().equalsIgnoreCase("jupiter")){
                planeElement.findElement(By.tagName("button")).click();
                break;
            }
        }*/

        }

  /*  @Test
    public void clickForms(){
        driver.findElement(By.cssSelector("[aria-label='forms']")).click();
        Form form = new Form(driver);
        form.enterName("Pulkit");
        form.email("plktkhatri@gmail.com");
        form.selectState("NSW");
        form.agree();
        form.submit();

        By ByPopUpMessage = By.className("popup-message");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(ByPopUpMessage));

        Assertions.assertEquals("Thanks for your feedback Pulkit", driver.findElement(ByPopUpMessage).getText());



      //  new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlMatches("https://d18u5zoaatmpxx.cloudfront.net/#/forms"));



      //  driver.findElement(By.id("list-item-99-0")).click();

       // driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div/div[2]/div/div/div[2]/div/div/div/div/form/button[1]")).click();
/*driver.findElement(By.cssSelector(".v-select__selections")).click();
        List<WebElement> states = driver.findElements(By.cssSelector("div[role=option]"));
        System.out.println(states);

        for (WebElement state: states){
            if (state.getText().equals("NSW"))
                state.click();

        }*/
        //Select state = new Select(driver.findElement(By.className("v-select__slot")));
        //state.selectByVisibleText("NSW");
        //state.selectByIndex(1);*/

/*
    @Test
    public void clickMeUpToDownButton(){
    By buttonby = By.cssSelector("[role='button']");

    driver.findElement(buttonby).click();
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.
            textToBe(buttonby, "CLICK ME UP!"));

    //Action
    driver.findElement(buttonby).click();
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.
            textToBe(buttonby, "CLICK ME DOWN!"));

    //Assert
    Assertions.assertEquals("CLICK ME DOWN!",driver.findElement(buttonby).getText());
    }*/
    @AfterEach
    public void clear(){
       //driver.quit();
    }
    private WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        return driver;
    }

      /*  @Test
        public void playgroundTest(){
         String headText =  driver.findElement(By.cssSelector("h1.mb-3")).getText();
            Assertions.assertEquals("Web Playground", headText);
        }
        @Test
        public void clickDown() throws InterruptedException {
        driver.findElement(By.cssSelector("div a.anibtn")).click();
        Thread.sleep(3000);
        String textDown = driver.findElement(By.cssSelector("div a.anibtn.transition-y")).getText();
        System.out.println(textDown);
        }*/
}
