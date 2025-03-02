package com.AndreaPop.Automation.pages;

import com.AndreaPop.Automation.base.BasePage;
import com.AndreaPop.Automation.utils.CaptchaHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerFeedbackPage extends BasePage {
    @FindBy(id = "comment")
    private WebElement commentInput;

    @FindBy(id = "captchaControl")
    private WebElement captchaControl;

    @FindBy(id = "captcha")
    private WebElement captcha;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    public  CustomerFeedbackPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeComment(String comment) {
        commentInput.sendKeys(comment);
    }

    public void solveCapcha() {
        int result = CaptchaHelper.solveCapcha(captcha.getText());
        captchaControl.sendKeys(Integer.toString(result));
    }

    public void submit(){
        submitButton.click();
    }

    // I can't move the slider and ChatGPT is failing to provide a viable solution.
    public void setRating(){
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"rating\"]/div/div[3]/div[2]"));
        slider.click();
    }
}
