package se.reky.janaina.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {

    ChromeDriver driver;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyCorrectAmountOfPlayersIsDisplayed() {
        driver.get("http://localhost:8080/players");

        List<WebElement> players = driver.findElements(By.cssSelector("ul li"));
        assertEquals(3, players.size());
    }

    @Test
    public void verifyFirstNameInListIsCorrect() {
        driver.get("http://localhost:8080/players");

        WebElement firstPlayerNameElement = driver.findElement(By.cssSelector("ul li:first-child .player-name"));
        assertTrue(firstPlayerNameElement.isDisplayed());
        assertEquals("J", firstPlayerNameElement.getText());
    }

    @Test
    public void verifyPageTitleAsExpected() {
        driver.get("http://localhost:8080/players");

        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void verifyLoginButtonTextIsDisplayed() {
        driver.get("http://localhost:8080/players");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        assertTrue(loginButton.isDisplayed());
        assertEquals("Logga in", loginButton.getText());
    }


}
