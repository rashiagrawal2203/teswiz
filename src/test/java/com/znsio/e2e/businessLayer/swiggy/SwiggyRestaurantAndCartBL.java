package com.znsio.e2e.businessLayer.swiggy;

import com.context.TestExecutionContext;
import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.screen.swiggy.SwiggyRestaurantAndCartScreen;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class SwiggyRestaurantAndCartBL {

    private final Logger LOGGER = Logger.getLogger(SwiggyRestaurantAndCartBL.class.getName());
    private final TestExecutionContext context;
    private final SoftAssertions softly;
    private final Platform currentPlatform;
    private final String currentUserPersona;


    public SwiggyRestaurantAndCartBL(String userPersona, Platform forPlatform) {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = userPersona;
        this.currentPlatform = forPlatform;
        Runner.setCurrentDriverForUser(userPersona, forPlatform, context);
    }

    public SwiggyRestaurantAndCartBL() {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = SAMPLE_TEST_CONTEXT.ME;
        this.currentPlatform = Runner.platform;
    }



    public SwiggyRestaurantAndCartBL selectFoodItem(String foodItem) {
        SwiggyRestaurantAndCartScreen.get().selectFoodItemName(foodItem);
        return new SwiggyRestaurantAndCartBL();
    }

    public void selectFoodQuantity(int foodItemQuantity) {
        SwiggyRestaurantAndCartScreen.get().selectFoodItemQuantity(foodItemQuantity);
        new SwiggyRestaurantAndCartBL();
    }
    public SwiggyRestaurantAndCartBL validateItemsDisplayedInCart(String foodItem) {
        SwiggyRestaurantAndCartScreen.get().validateItemsDisplayingInCart(foodItem);
        return new SwiggyRestaurantAndCartBL();
    }

    public void validateDetailsOfItemsDisplayedInCart(String foodItem, int foodItemQuantity, float foodItemPrice) {
        SwiggyRestaurantAndCartScreen.get().validateItemsDetailsDisplayedInCart(foodItem, foodItemQuantity, foodItemPrice);
    }
}




