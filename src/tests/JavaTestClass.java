package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestClass {


    public void login ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/");
        driver.findElement(By.id("edit-name")).clear();
        //driver.findElement(By.id("edit-name")).clear();
        driver.findElement(By.id("edit-name")).sendKeys("xls2802");

        driver.findElement(By.id("edit-pass")).clear();
        driver.findElement(By.id("edit-pass")).sendKeys("xls2802");
        driver.findElement(By.id("edit-submit")).click();
        //Assert.assertEquals(driver.findElement(By.cssSelector("#block-user-1 > div.blockinner > h2.title")).getText(), "xls2802");
        Assert.assertEquals(driver.findElement(By.cssSelector("#block-user-1 > div.blockinner > h2.title")).getText(), "xls2802");


        driver.close();
    }

    @Test
    public void login1 (){
    login();
    }

    @Test
    public void logout ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/");
        driver.findElement(By.id("edit-name")).clear();
        //driver.findElement(By.id("edit-name")).clear();
        driver.findElement(By.id("edit-name")).sendKeys("xls2802");

        driver.findElement(By.id("edit-pass")).clear();
        driver.findElement(By.id("edit-pass")).sendKeys("xls2802");
        driver.findElement(By.id("edit-submit")).click();



        driver.get("http://flibusta.is" + "/node");
        driver.findElement(By.linkText("Выйти")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#block-user-0 > div.blockinner > h2.title")).getText(), "Вход в систему");

        driver.close();
    }
    @Test
    public void searchBy_A ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/node");
        driver.findElement(By.linkText("[А]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.title")).getText(), "Авторы, фамилия которых начинается на букву А");

        driver.close();
    }
    @Test
    public void searchByField ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/node");
        driver.findElement(By.name("ask")).clear();
        driver.findElement(By.name("ask")).sendKeys("Акунин");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='main']/li[4]/h3")).getText(), "Найденные писатели:");
        driver.findElement(By.linkText("Борис Акунин")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.title")).getText(), "Борис Акунин");
        Assert.assertEquals(driver.findElement(By.cssSelector("span")).getText(), "Григорий Шалвович Чхартишвили");

        driver.close();
    }
    @Test
    public void extendedSearch ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/node");
        driver.findElement(By.linkText("Расширенный поиск")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("th")).getText(), "Название");
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='tt']/tbody/tr/th[2]")).getText(), "Фамилия");
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='tt']/tbody/tr/th[3]")).getText(), "Имя");
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='tt']/tbody/tr/th[4]")).getText(), "Отчество");
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='tt']/tbody/tr/th[5]")).getText(), "Жанр (выбрать)");
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='tt']/tbody/tr/th[7]")).getText(), "Год издания");

        driver.close();
    }
    @Test
    public void genreLink ()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//Администратор//IdeaProjects//TestGavr//lib//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://flibusta.is" + "/node");
        driver.findElement(By.linkText("Жанры")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.title")).getText(), "Список жанров");

        driver.close();
    }
}

