package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class CollectResources {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    public List<Integer> villages;

    @Steps
    public EndUserSteps steps;

    // this method runs continuously and calls the method collect_once from 10 to ten minutes
    @Test
    public void collect(){
        while (true){
            collect_once();
            waitForIt(60*10);
        }
    }
    private void collect_once() {
        steps.openPage();
        // here you add your credentials- username and password
        steps.login("Apocalypto","sebastian95");
        waitForIt(1);
        steps.select_world();
        waitForIt(1);
        steps.hover(webdriver);
        // Here you add the indexes of the villages you want to collect resources from.
        // ATTENTION the islands are counting also to the indexing(first island is at index 1)
        villages = List.of(2,4);
        steps.collect(villages, webdriver);
        webdriver.close();
    }
    // this methods waits for a given amount of seconds
    private void waitForIt(int secondsToWait)
    {
        try {
            TimeUnit.SECONDS.sleep(secondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 