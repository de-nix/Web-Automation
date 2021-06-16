package examSelenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaPage extends PageObject {
    @FindBy(name = "search")
    private WebElementFacade searchInputField;
    @FindBy(name = "go")
    private WebElementFacade searchButton;

    public void accessLink(String song) {
        searchInputField.type(song);
        searchButton.click();
        List<WebElementFacade> link = findAll(cssSelector("#mw-content-text > div.mw-parser-output a[href]"));
        link.get(0).click();
    }

}
