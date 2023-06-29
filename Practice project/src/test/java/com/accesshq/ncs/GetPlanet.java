package com.accesshq.ncs;

import Model.Planet;
import Model.SolarPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetPlanet {
 private WebDriver driver;

    
    @BeforeEach
    public void openWindow(){
        driver = getDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/planets");
    }

    @Test
    public void explorePlanet(){
     // new ToolBar(driver).clickMenu("planets");
        SolarPanel solarPanel = new SolarPanel(driver);
        Planet planet = solarPanel.getAllPlanet("Earth");
        planet.clickExplore();
    }

    @AfterEach
    public void closeWindow(){
       // driver.quit();
    }
    private WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        return driver;
    }
}
