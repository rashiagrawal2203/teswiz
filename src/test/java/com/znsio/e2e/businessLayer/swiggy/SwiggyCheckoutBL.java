package com.znsio.e2e.businessLayer.swiggy;

import com.context.TestExecutionContext;
import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class SwiggyCheckoutBL {

        private final Logger LOGGER = Logger.getLogger(SwiggyCheckoutBL.class.getName());
        private final TestExecutionContext context;
        private final SoftAssertions softly;
        private final String currentUserPersona;
        private final Platform currentPlatform;


    public SwiggyCheckoutBL(String userPersona, Platform forPlatform) {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = userPersona;
        this.currentPlatform = forPlatform;
        Runner.setCurrentDriverForUser(userPersona, forPlatform, context);
    }

    public SwiggyCheckoutBL() {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = SAMPLE_TEST_CONTEXT.ME;
        this.currentPlatform = Runner.platform;
    }

    public SwiggyCheckoutBL validateItemsDisplayedOnCheckoutPage() {
            return new SwiggyCheckoutBL();
    }

    public void verifyDetailsOfItemsDisplayedOnCheckoutPage(String foodItem, int foodItemQuantity, float foodItemPrice) {


    }
}

