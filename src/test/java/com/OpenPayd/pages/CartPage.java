package com.OpenPayd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    public List<WebElement> CartProducts;

    public List ListOfCartProductc(){
        List<String> list=new ArrayList<>();
        for (int a=CartProducts.size()-1;a>=0;a--){
            list.add(CartProducts.get(a).getText());

        }
        return list;
    }


}
