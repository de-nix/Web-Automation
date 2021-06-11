package org.example.pages;

import io.cucumber.java.bs.A;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.*;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DefaultUrl("https://ro.grepolis.com/")
public class GrepolisPage extends PageObject {

    @FindBy(id="login_userid")
    private WebElementFacade usernameInput;
    @FindBy(id="login_password")
    private WebElementFacade passwordInput;
    @FindBy(id="login_Login")
    private WebElementFacade lookupButton;
    @FindBy(css = "#worlds > div > ul > li.world_name.end_game_type_world_wonder > div")
    private WebElementFacade world;

    public void login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        lookupButton.click();
    }

    public void selectWorld(){
        world.click();
    }

    public void hover(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui_box\"]/div[14]/div[3]/div")))
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"overviews_link_hover_menu\"]/div[2]/div/div/ul/li[2]/ul/li[2]/a")))
                .click().build().perform();
    }

    public void collect(List<Integer> villages, WebDriver driver){
        // select all the checkboxes corresponding to the villages you want to take resources for
        for (int x: villages) {
            driver.findElement(By.xpath("//*[@id=\"fto_town_list\"]/li["+x+"]/a[2]")).click();
        }
        waitForIt(2);
        //clicks the collect button
        driver.findElement(By.cssSelector("#fto_claim_button > div.caption.js-caption")).click();
        waitForIt(4);
        try{
            //clicks yes button is it exists
            WebElement element2 = driver.findElement(By.xpath("/html/body/div[13]/div/div[11]/div/div[2]/div[1]/div[3]"));
            element2.click();
        }catch (Exception ignore){

        }
    }

    // waits for a given amount of seconds
    private void waitForIt(int secondsToWait)
    {
        try {
            TimeUnit.SECONDS.sleep(secondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}