package se.reky.janaina.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {

    ChromeDriver driver;
    private final String url = "http://localhost:8080/players";

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
        driver.get(url);

        List<WebElement> players = driver.findElements(By.cssSelector("ul li"));
        assertEquals(3, players.size());
    }

    @Test
    public void verifyFirstNameInListIsCorrect() {
        driver.get(url);

        WebElement firstPlayerNameElement = driver.findElement(By.cssSelector("ul li:first-child .player-name"));
        assertTrue(firstPlayerNameElement.isDisplayed());
        assertEquals("J", firstPlayerNameElement.getText());
    }

    @Test
    public void verifyPageTitleAsExpected() {
        driver.get(url);

        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void verifyLoginButtonTextIsDisplayed() {
        driver.get(url);

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        assertTrue(loginBtn.isDisplayed());
        assertEquals("Logga in", loginBtn.getText());
    }

    @Test
    public void verifyPlayerDetailsPageDisplaysCorrectData() {
        driver.get(url);

        WebElement firstPlayerLink = driver.findElement(By.cssSelector("ul li:first-child a"));
        String playerLinkText = firstPlayerLink.getText();

        firstPlayerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Player Details"));

        WebElement playerNameElement = driver.findElement(By.xpath("//p[contains(text(),'Name:')]"));
        String playerNameText = playerNameElement.getText();
        assertTrue(playerNameText.contains(playerLinkText), "Player name on the details page matches the link text");
    }


}
