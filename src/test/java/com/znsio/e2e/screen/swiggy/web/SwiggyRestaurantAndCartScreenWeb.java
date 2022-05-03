package com.znsio.e2e.screen.swiggy.web;

import com.znsio.e2e.screen.swiggy.SwiggyRestaurantAndCartScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SwiggyRestaurantAndCartScreenWeb extends SwiggyRestaurantAndCartScreen {
    private static final Logger LOGGER = Logger.getLogger(SwiggyRestaurantAndCartScreenWeb.class.getName());
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = SwiggyRestaurantAndCartScreenWeb.class.getSimpleName();
    private final By SwiggyRestaurantAndCartScreen_SearchBox = By.tagName("//input[@placeholder='Search for dishes...']");
    private final By ItemName_PepsiBlackCan = By.xpath("//h3[contains(text(),\"Pepsi Black Can\")]");




    public SwiggyRestaurantAndCartScreenWeb(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public void selectFoodItemName(String foodItem) {
        driver.findElement(SwiggyRestaurantAndCartScreen_SearchBox).sendKeys(foodItem);
    }

    @Override
    public void selectFoodItemQuantity(int foodItemQuantity) {

    }

    @Override
    public void validateItemsDisplayingInCart(String foodItem) {

    }

    @Override
    public void validateItemsDetailsDisplayedInCart(String foodItem, int foodItemQuantity, float foodItemPrice) {

    }
}
