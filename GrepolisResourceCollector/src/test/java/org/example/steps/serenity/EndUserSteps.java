package org.example.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.example.pages.GrepolisPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    GrepolisPage grepolisPage;

    @Step
    public void login(String username, String password) {
        grepolisPage.login(username, password);
    }

    @Step
    public void select_world() {
        grepolisPage.selectWorld();
    }

    @Step
    public void openPage() {
        grepolisPage.open();
    }

    public void hover(WebDriver driver) {
        grepolisPage.hover(driver);
    }

    public void collect(List<Integer> villages, WebDriver driver) {
        grepolisPage.collect(villages, driver);
    }
}