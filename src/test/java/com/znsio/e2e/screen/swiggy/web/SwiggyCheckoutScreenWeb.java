package com.znsio.e2e.screen.swiggy.web;

import com.znsio.e2e.screen.swiggy.SwiggyCheckoutScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SwiggyCheckoutScreenWeb extends SwiggyCheckoutScreen {
    private static final Logger LOGGER = Logger.getLogger(SwiggyCheckoutScreenWeb.class.getName());
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = SwiggyCheckoutScreenWeb.class.getSimpleName();
    private final By textBox_EnterLocation = By.id("location");

    public SwiggyCheckoutScreenWeb(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }
}
