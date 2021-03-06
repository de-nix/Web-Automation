package examSelenium.steps;

import examSelenium.pages.BestSongsOfAllTimePage;
import examSelenium.pages.BrithdaySongPage;
import examSelenium.pages.WikipediaPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    BrithdaySongPage birthdaySongPage;
    BestSongsOfAllTimePage bestSongsOfAllTimePage;
    WikipediaPage wikipediaPage;

    @Step
    public void open_birthday_songs_page() {
        birthdaySongPage.open();
    }

    @Step
    public void inputBirthday() {
        birthdaySongPage.inputBirthdayDate(15, 7, 1999);
    }

    @Step
    public void open_best_songs_of_all_time_page() {
        bestSongsOfAllTimePage.open();
    }


    @Step
    public void open_wikipedia_page() {
        wikipediaPage.open();
    }

    @Step
    public String getSong() {
        return birthdaySongPage.getSongName();
    }

    @Step
    public List<String> getSongs() {
        return bestSongsOfAllTimePage.getSongsName();
    }

    @Step
    public void accessLink(String song) {
        wikipediaPage.accessLink(song);
    }
}
