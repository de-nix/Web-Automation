package examSelenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://playback.fm/birthday-song")
public class BrithdaySongPage extends PageObject {
    @FindBy(name = "month")
    private WebElementFacade monthDropdown;

    @FindBy(name = "day")
    private WebElementFacade dayDropdown;

    @FindBy(name = "year")
    private WebElementFacade yearDropdown;

    @FindBy(xpath = "//*[@id=\"datePicker\"]/input")
    private WebElementFacade searchButton;

    public void inputBirthdayDate(int inputDay, int inputMonth, int inputYear) {

        WebElementFacade month = find(By.cssSelector("#month > option:nth-child(" + (inputMonth + 1) + ")"));
        WebElementFacade day = find(By.cssSelector("#day > option:nth-child(" + (inputDay + 1) + ")"));
        WebElementFacade year = find(By.cssSelector("#year > option:nth-child(" + (2021 - inputYear + 1) + ")"));

        this.monthDropdown.click();
        month.click();
        this.dayDropdown.click();
        day.click();
        this.yearDropdown.click();
        year.click();
        this.searchButton.click();
    }

    public String getSongName() {
        String songName = find(By.xpath("//*[@id=\"id01\"]/strong")).getText();
        int index = songName.indexOf(" by");
        return songName.substring(0,index);
    }
}
