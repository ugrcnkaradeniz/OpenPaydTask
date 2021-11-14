package com.OpenPayd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ProductDetailPage extends BasePage {

    @FindBy(id = "add-to-cart-button")
    public WebElement AddToCart;

    @FindBy(id = "productTitle")
    public WebElement ProductTitle;


}
