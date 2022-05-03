package com.znsio.e2e.screen.swiggy.web;

import com.znsio.e2e.screen.swiggy.SwiggyHomeScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.znsio.e2e.tools.Wait.waitFor;

public class SwiggyHomeScreenWeb extends SwiggyHomeScreen {
    private static final Logger LOGGER = Logger.getLogger(SwiggyHomeScreenWeb.class.getName());
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = SwiggyHomeScreenWeb.class.getSimpleName();
    private final By HomePage_RestaurantListingPageHeading = By.xpath("//div[@id='all_restaurants']");
    private final By HomePage_SortRestaurantByRatingButton = By.xpath("//div[contains(text(),'Rating')]");
    private final By HomePage_SearchButton = By.xpath("//span[contains(text(),'Search')]");
    private final By SearchPage_TextBox = By.xpath("//input[@class='_2BJMh']");
    private final By SearchResult_Domino = By.xpath("//b[contains(text(),'Domino')]");
    private final By RestaurantName_Domino = By.xpath("//div[contains(text(),'Domino's Pizza')]");

    public SwiggyHomeScreenWeb(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public void getListOfRestaurantsPage() {
        waitFor(5);
     if(driver.findElement(HomePage_RestaurantListingPageHeading).isDisplayed()){
         LOGGER.info("I am on Home Page and Restaurant Listing are available");
     }
     else {
         LOGGER.info("Can Not Find Home Page");
     }

    }
    @Override
    public void sortRestaurantByRatings() {
        List<WebElement> beforeSorting = driver.findElements(By.className("_9uwBC wY0my"));
        List<Float> beforeSortingRating = new ArrayList<>();
        for(WebElement r : beforeSorting){
            beforeSortingRating.add(Float.valueOf(r.getText()));
        }

        driver.findElement(HomePage_SortRestaurantByRatingButton).click();

        List<WebElement> afterSorting = driver.findElements(By.className("_9uwBC wY0my"));
        List<Float> afterSortingRating = new ArrayList<>();
        for(WebElement r : afterSorting){
            afterSortingRating.add(Float.valueOf(r.getText()));
        }

        Collections.sort(beforeSortingRating);
        if(afterSortingRating.equals(beforeSortingRating)){
            LOGGER.info("Restaurant List is sorted");
        }
        else {
            LOGGER.info("Restaurant List is sorted");
        }


    }

    @Override
    public void selectRestaurantName(String restaurantName) {
        driver.findElement(HomePage_SearchButton).click();
        waitFor(5);
        driver.findElement(SearchPage_TextBox).sendKeys(restaurantName);
        driver.waitTillElementIsPresent(SearchResult_Domino);
        driver.findElement(SearchResult_Domino).click();
        driver.waitTillElementIsPresent(RestaurantName_Domino);
        driver.findElement(RestaurantName_Domino).click();

    }
}
