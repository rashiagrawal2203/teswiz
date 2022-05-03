package com.znsio.e2e.businessLayer.swiggy;

import com.context.TestExecutionContext;
import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.screen.swiggy.SwiggyHomeScreen;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class SwiggyHomeBL {

    private final Logger LOGGER = Logger.getLogger(SwiggyHomeBL.class.getName());
    private final TestExecutionContext context;
    private final SoftAssertions softly;
    private final Platform currentPlatform;
    private final String currentUserPersona;


    public SwiggyHomeBL(String userPersona, Platform forPlatform) {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = userPersona;
        this.currentPlatform = forPlatform;
        Runner.setCurrentDriverForUser(userPersona, forPlatform, context);
    }

    public SwiggyHomeBL() {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = SAMPLE_TEST_CONTEXT.ME;
        this.currentPlatform = Runner.platform;
    }

    public void getRestaurantListPage() {

        SwiggyHomeScreen.get().getListOfRestaurantsPage();
        new SwiggyHomeBL();

    }
    public SwiggyHomeBL sortByRatings() {
        SwiggyHomeScreen.get().sortRestaurantByRatings();
        return new SwiggyHomeBL();
    }

    public SwiggyRestaurantAndCartBL selectRestaurantByName(String restaurantName) {
        SwiggyHomeScreen.get().selectRestaurantName(restaurantName);
        return new SwiggyRestaurantAndCartBL();

    }


}

