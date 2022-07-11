package com.example.app.pages;

import static com.example.app.drivers.AndroidDriverInit.driver;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePageObject {

  public String getTitle() {
//    By locator = MobileBy.xpath(
//        "//android.view.ViewGroup[@resource-id='com.isl.simpleapp:id/toolbar']//android.widget.TextView");
//    AndroidElement labelTitle = driver.findElement(locator);
//    return labelTitle.getText();
    return getText(MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.isl.simpleapp:id/toolbar']//android.widget.TextView"));
  }

  public boolean checkHamburgerBtnAppear() {
//    By locator = MobileBy.AccessibilityId("Open navigation drawer");
//    AndroidElement hamburgerBtn = driver.findElement(locator);
//    return hamburgerBtn.isDisplayed();

    //explicit wait
    By locator = MobileBy.AccessibilityId("Open navigation drawer");
    WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
    AndroidElement hamburgerBtn = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    return hamburgerBtn.isDisplayed();
  }

  public void InputNumb1(int Value1){
    type(MobileBy.id("et_1"), String.valueOf(Value1));
  }

  public void clickDropdownBtn() {
    click(MobileBy.id("spinner_1"));
  }
  public void clickOpBtn(String operator){
    click(MobileBy.xpath("//*[@text=\""+operator+"\"]"));
  }
  public void InputNumb2(int Value2){
    type(MobileBy.id("et_2"), String.valueOf(Value2));
  }

  public void clickOp2(){
    click(MobileBy.id("acb_calculate"));
  }

  public String getResult(){
    return getText(MobileBy.id("tv_result"));
  }

  public void InputNumb1Spchar(String spchar){
    type(MobileBy.id("et_1"), String.valueOf(spchar));
  }

  public void InputNumb2char(String Angka) {
    type(MobileBy.id("et_2"),Angka);
  }
}
