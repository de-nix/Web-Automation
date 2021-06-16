package examSelenium.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.thedelite.com/best-songs-of-all-time-according-to-critics-and-fans")
public class BestSongsOfAllTimePage extends PageObject {

    public List<String> getSongsName() {
        List<String> songs = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            songs.add(find(By.cssSelector("#header-slide-" + i)).getText());
        }
        return songs;
    }

}
