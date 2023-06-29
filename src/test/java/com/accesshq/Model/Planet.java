package com.accesshq.Model;

import groovy.transform.Final;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private final WebElement planetElement;

    public Planet(WebElement planetElement){
        this.planetElement = planetElement;
    }

    public String getName(){
        return planetElement.findElement(By.className("name")).getText();
    }

    public void clickExplore(){
        planetElement.findElement(By.tagName("button")).click();
    }

    public float getDistance(){
     // return Float.parseFloat( planetElement.findElement(By.className("distance")).getText());
    String cleanDistanceNumber = this.planetElement.findElement(By.className("distance"))
            .getText().replace("km", "").replaceAll(",", "").replaceAll(" ", "");
    return Float.parseFloat(cleanDistanceNumber);
    }
}
