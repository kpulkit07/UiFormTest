package com.accesshq.Model;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {

    WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<Planet> getAllPlanets() {
        List<WebElement> planetElements = driver.findElements(By.className("planet"));
        ArrayList<Planet> planets = new ArrayList<Planet>();

        for (WebElement planeElement : planetElements) {
            planets.add(new Planet(planeElement));
        }

        return planets;

    }
    public Planet getPlanet(Predicate<Planet> strategy) {
        for (Planet planet : getAllPlanets()) {
            if (strategy.test(planet)){
                return planet;
            }
        }
        return null;
    }
    public Planet getPlanetByName(String planetName, ArrayList<Planet> allPlanets) {
        for (Planet exploringPlanet : allPlanets) {
            if (exploringPlanet.getName().equalsIgnoreCase(planetName)) {
                return exploringPlanet;
            }
        }
        return null;
    }

    public Planet getPlanetByDistance(Float distance, ArrayList<Planet> allPlanets) {
        for (Planet planet : allPlanets) {
            if (planet.getDistance() == distance) {
                return planet;
            }
        }
        return null;
    }
}
