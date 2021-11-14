package com.OpenPayd.pages;

import com.OpenPayd.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    @FindBy(xpath = "//input[@type='text']")
    public WebElement SearchBox;

    @FindBy(css = "#nav-cart")
    public WebElement Cart;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    } //I put PageFacrory for using weblemets
}
