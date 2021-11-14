package com.OpenPayd.pages;

import com.OpenPayd.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "(//div/span)[16]")
    public WebElement result;

    @FindBy(xpath = "//div[@class='a-section']//h2//a" )
    public List<WebElement> Products;


    @FindBy(xpath = "//span[@data-a-color='secondary']")
    public WebElement DisCountedProduct;




    public WebElement AllProducts(int product){
        String xpath="(//div[@class='a-section']//h2//a)["+product+"]";

        return Driver.get().findElement(By.xpath(xpath));
    }



}
