package com.znsio.e2e.screen.swiggy.web;

import com.znsio.e2e.screen.swiggy.SwiggyLocationScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.znsio.e2e.tools.Wait.waitFor;


public class SwiggyLocationScreenWeb extends SwiggyLocationScreen {
        private static final Logger LOGGER = Logger.getLogger(SwiggyLocationScreenWeb.class.getName());
        private final Driver driver;
        private final Visual visually;
        private final String SCREEN_NAME = SwiggyLocationScreenWeb.class.getSimpleName();
        private final By LocationPage_textBox_EnterLocation = By.id("location");
    private final By LocationPa = By.className("_2BJMh");
        private final By LocationPage_findFoodButton = By.xpath("//span[contains(text(),'FIND FOOD')]");
        private final By LocationPage_ChooseLocationFromDropdown = By.xpath("//span[contains(text(),'Bangalore Railway Station Back Gate, M.G. Railway ')]");

        public SwiggyLocationScreenWeb(Driver driver, Visual visually) {
            this.driver = driver;
            this.visually = visually;
        }

        @Override
        public SwiggyLocationScreen openSwiggyLocationPage() {

            driver.findElement(LocationPage_findFoodButton).isDisplayed();
            return this;

        }

    @Override
    public SwiggyLocationScreen enterLocationOnLocationPage(String location) {
        driver.findElement(LocationPage_textBox_EnterLocation).sendKeys(location);
        waitFor(5);
        LOGGER.info(driver.findElement(LocationPage_textBox_EnterLocation).isDisplayed());
        driver.findElement(LocationPage_ChooseLocationFromDropdown).click();
        return this;
    }


}

