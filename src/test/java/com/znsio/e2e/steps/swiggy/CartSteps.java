package com.znsio.e2e.steps.swiggy;


import com.context.SessionContext;
import com.context.TestExecutionContext;
import com.znsio.e2e.businessLayer.swiggy.SwiggyCheckoutBL;
import com.znsio.e2e.businessLayer.swiggy.SwiggyHomeBL;
import com.znsio.e2e.businessLayer.swiggy.SwiggyLocationBL;
import com.znsio.e2e.businessLayer.swiggy.SwiggyRestaurantAndCartBL;
import com.znsio.e2e.entities.SAMPLE_TEST_CONTEXT;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class CartSteps {
    private static final Logger LOGGER = Logger.getLogger(com.znsio.e2e.steps.CalculatorSteps.class.getName());
    private final TestExecutionContext context;
    private final Drivers allDrivers;

    public CartSteps() {
        context = SessionContext.getTestExecutionContext(Thread.currentThread().getId());
        LOGGER.info("context: " + context.getTestName());
        allDrivers = (Drivers) context.getTestState(SAMPLE_TEST_CONTEXT.ALL_DRIVERS);
        LOGGER.info("allDrivers: " + (null == allDrivers));
    }

    @Given("I am on Home Page")
    public void iAmOnHomePage() {
        allDrivers.createDriverFor(SAMPLE_TEST_CONTEXT.ME, Runner.platform, context);
        new SwiggyLocationBL(SAMPLE_TEST_CONTEXT.ME, Runner.platform).goToSwiggyLocationPage();
        LOGGER.info(System.out.printf("I am on Home Page"));
    }

    @When("I set the location to {string}")
    public void iSetTheLocationTo(String location) {
        new SwiggyLocationBL().setLocationOnLocationPage(location);
    }

    @Then("I should see the list of restaurants on Swiggy Home Page")
    public void iShouldSeeTheListOfRestaurants() {
        new SwiggyHomeBL().getRestaurantListPage();
    }

    @When("I sort the restaurants by Rating and select {string} in restaurants list")
    public void iSortTheRestaurantsByRatingAndSelectInRestaurantsList(String restaurantName) {
        new SwiggyHomeBL().sortByRatings().selectRestaurantByName(restaurantName);
    }

    @And("I select the Food Item with Quantity as")
    public void iSelectTheFoodItemWithQuantityAs(String foodItem, int foodItemQuantity) {
        SwiggyRestaurantAndCartBL swiggyRestaurantAndCartBL = new SwiggyRestaurantAndCartBL();
        swiggyRestaurantAndCartBL.selectFoodItem(foodItem);
        swiggyRestaurantAndCartBL.selectFoodQuantity(foodItemQuantity);
    }

    @Then("I should be able to validate the cart details on listing page and checkout page")
    public void iShouldBeAbleToValidateTheCartDetailsOnListingPageAndCheckoutPage(String foodItem, int foodItemQuantity, float foodItemPrice) {
        new SwiggyRestaurantAndCartBL().validateItemsDisplayedInCart(foodItem).validateDetailsOfItemsDisplayedInCart(foodItem, foodItemQuantity, foodItemPrice);
        SwiggyCheckoutBL swiggyCheckoutBL = new SwiggyCheckoutBL();
        swiggyCheckoutBL.validateItemsDisplayedOnCheckoutPage();
        swiggyCheckoutBL.verifyDetailsOfItemsDisplayedOnCheckoutPage(foodItem, foodItemQuantity, foodItemPrice);
    }
}




