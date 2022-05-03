package com.znsio.e2e.businessLayer.swiggy;

import com.context.TestExecutionContext;
import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.screen.swiggy.SwiggyLocationScreen;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;


public class SwiggyLocationBL {

    private final Logger LOGGER = Logger.getLogger(SwiggyLocationBL.class.getName());
    private final TestExecutionContext context;
    private final SoftAssertions softly;
    private final Platform currentPlatform;
    private final String currentUserPersona;

    public SwiggyLocationBL(String userPersona, Platform forPlatform) {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = userPersona;
        this.currentPlatform = forPlatform;
        Runner.setCurrentDriverForUser(userPersona, forPlatform, context);
    }

    public SwiggyLocationBL() {
        long threadId = Thread.currentThread().getId();
        this.context = Runner.getTestExecutionContext(threadId);
        softly = Runner.getSoftAssertion(threadId);
        this.currentUserPersona = SAMPLE_TEST_CONTEXT.ME;
        this.currentPlatform = Runner.platform;
    }

    public void goToSwiggyLocationPage() {
        assertThat(SwiggyLocationScreen.get().openSwiggyLocationPage());

    }

    public void setLocationOnLocationPage(String location) {
        SwiggyLocationScreen.get().enterLocationOnLocationPage(location);
    }


}
