package com.example.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/demo")
public class GlobalController {

    @Autowired
    private ChromeDriver driver;


    private final static String MAIN_MENU_IMG = "https://eaassets-a.akamaihd.net/cncalliancesgame/cdn/data/0b20ac201bb69582eabd507ff0b0383e.png";


    @RequestMapping(method = RequestMethod.GET, path = "/installScripts")
    public void installScripts() throws InterruptedException {
        driver.get("http://chertosha.com/Allscripts/cctascripts.html");
        driver.findElementByLinkText("API_wrapper").click();
        Thread.sleep(2000);

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElementByClassName("install").click();
        driver.switchTo().window(tabs2.get(0));
        driver.findElementByLinkText("MaelstromTools_Dev").click();
        Thread.sleep(2000);

        tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElementByClassName("install").click();
        driver.switchTo().window(tabs2.get(0));

        driver.findElementByLinkText("Basescanner_41CP_Mod").click();
        Thread.sleep(2000);
        tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElementByClassName("install").click();
        driver.switchTo().window(tabs2.get(0));

    }


    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public void login() throws InterruptedException {
        driver.get("http://tiberiumalliances.com/ru/home");
        Thread.sleep(3000);
        driver.findElement(By.className("playnow-btn")).click();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/start")
    public void start() throws InterruptedException {
        driver.getWindowHandles();
//        driver.findElementByXPath("/html/body/div[3]/div[1]/div[1]/div/div[13]").click();
//        driver.findElementByXPath("/html/body/div[3]/div[6]/div[7]").click();
//        driver.findElementByXPath("/html/body/div[3]/div[4]/div[2]/div[2]/div[1]/div[9]").click();

        driver.findElementByXPath("//text()[.='Scan']//..").click();
        Actions actions = new Actions(driver);
        List<WebElement> foundCamps = driver.findElementsByXPath("//div[text()[.='Лагерь']]");

        for (WebElement camp: foundCamps) {
            actions.doubleClick(camp).perform();
            driver.findElementByXPath("//img[@src = 'https://eaassets-a.akamaihd.net/cncalliancesgame/cdn/data/ee9b5cff48f3c05aa0275266ff72b1ff.png']//..").click();
            List<WebElement> fightResult = driver.findElementsByXPath("//div[contains(text(), \"Полная победа\")]");

            if (0 == fightResult.size()) {
                System.out.println("-------");
            } else {
                System.out.println("Полная победа");
            }

        }


    }


}
