package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class JavaTestClassNegative extends JavaTestClass{
        @Test
        public void loginNegative () throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("http://flibusta.is" + "/");
            driver.findElement(By.id("edit-name")).clear();
            driver.findElement(By.id("edit-name")).sendKeys("negative23");
            driver.findElement(By.id("edit-pass")).clear();
            driver.findElement(By.id("edit-pass")).sendKeys("wrongPass");
            driver.findElement(By.id("edit-submit")).click();

                Thread.sleep(2000);
            Assert.assertEquals("Вход в систему", driver.findElement(By.cssSelector("#block-user-0 > div.blockinner > h2.title")).getText());
           //Assert.assertEquals("Извините, это имя пользователя или пароль неверны", driver.findElement(By.xpath("//div[@id='main']/div[3]")).getText());


           //Assert.assertTrue(driver.findElement(By.cssSelector("div.messages.error")).getText().matches("^exact:Извините, это имя пользователя или пароль неверны."));

            driver.close();
        }



        @Test
        public void searchNegative ()
        {
            System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            login();

            driver.get("http://flibusta.is" + "/node");
            driver.findElement(By.name("ask")).clear();
            driver.findElement(By.name("ask")).sendKeys("qw!%$# 1");
            driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='main']/p[2]")).getText(), "Ничего не найдено. Введите фамилию автора или название книги для поиска");

            driver.close();
        }

    }


