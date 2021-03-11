package ru.geekbrains.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class HW3_DiarySignIn {

    public static final String SIGN_IN_PAGE_URL = "https://diary.ru/";
    public static final String USER_LOGIN = "chapeau_claque";
    public static final String USER_PASSWORD = "#Password";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.get(SIGN_IN_PAGE_URL);
        driver.manage().window().setSize(new Dimension(1125, 804));

        // нажать кнопку "Вход"
        WebElement signInForm = driver.findElement(By.xpath("//*[@id=\"drop-login\"]"));
        signInForm.click();
        Thread.sleep(1500);

        // поставить курсор в поле "Логин"
        WebElement signInField = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/div[1]"));
        signInField.click();
        Thread.sleep(1500);

        //ввести  логин
        WebElement signInTextInput = driver.findElement(By.xpath("//*[@id='usrlog2']"));
        signInTextInput.sendKeys(USER_LOGIN);
        Thread.sleep(1500);

        // поставить курсор в поле "Пароль"
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/div[2]"));
        passwordField.click();
        Thread.sleep(1500);

        //ввести пароль
        WebElement passwordTextInput = driver.findElement(By.xpath("//*[@id=\"usrpass2\"]"));
        passwordTextInput.sendKeys(USER_PASSWORD);
        Thread.sleep(1500);

        // нажать кнопку "Войти"
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"signin_btn\"]"));
        signInButton.click();
        Thread.sleep(1500);

        // вывести в консоль имя авторизовавшегося пользователя - "chapeau claque"
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/ul[2]/li[9]/a"));
        System.out.println("userName: " + userName.getText());

        Thread.sleep(3000);

        driver.quit();

    }
}