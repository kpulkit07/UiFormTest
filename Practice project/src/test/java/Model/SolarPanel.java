package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Predicate;

public class SolarPanel {

    WebDriver driver;

    public SolarPanel(WebDriver driver){
        this.driver = driver;
    }

  public Planet getAllPlanet(String planetName){
      for (WebElement planetElement:driver.findElements(By.className("planet"))) {
            var planets = new Planet(planetElement);
            if(planets.getName().equals(planetName)){
                return planets;
            }
      }
      throw new NotFoundException("planet not found");
  }

  public Planet getPlanet(Predicate<Planet> Strategy){
      for (Planet planet: getAllPlanet(\)) {
          
      }
  }
}
