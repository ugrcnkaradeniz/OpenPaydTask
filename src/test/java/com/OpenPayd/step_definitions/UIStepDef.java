package com.OpenPayd.step_definitions;

import com.OpenPayd.pages.CartPage;
import com.OpenPayd.pages.DashBoardPage;
import com.OpenPayd.pages.ProductDetailPage;
import com.OpenPayd.pages.SearchResultsPage;
import com.OpenPayd.utilities.BrowserUtils;
import com.OpenPayd.utilities.ConfigurationReader;
import com.OpenPayd.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;


public class UIStepDef {

    List<String> listProduct=new ArrayList<>();
    String ProductUrl;
    @Given("the user go to url")
    public void theUserGoToUrl() {
        Driver.get().get(ConfigurationReader.get("url"));
        String expected="Amazon.com";
        Assert.assertTrue(Driver.get().getTitle().contains(expected));
    }

    @And("user send {string} keyword to search input")
    public void userSendKeywordToSearchInput(String product) {
      new DashBoardPage().SearchBox.sendKeys(product+ Keys.ENTER);

    }

    @And("verify {string} found")
    public void verifyFound(String product) {
        ProductUrl=Driver.get().getCurrentUrl();
        String expectedKeyword="\""+product+"\"";
        String actualKeyword=new SearchResultsPage().result.getText();
        Assert.assertEquals(expectedKeyword,actualKeyword);

    }
    @And("add non-discounted products on the first page")
    public void addNonDiscountedProductsOnThePage() throws InterruptedException {

        for (int a=1;a<new SearchResultsPage().Products.size();a++){

            BrowserUtils.scrollToElement(new SearchResultsPage().AllProducts(a));
            new SearchResultsPage().AllProducts(a).click();
            try {
                new SearchResultsPage().DisCountedProduct.isDisplayed();
                System.out.println(a+" is discounted product");
            }catch (Exception e){
                try {
                    new ProductDetailPage().AddToCart.isDisplayed();
                    listProduct.add(new ProductDetailPage().ProductTitle.getText());
                    new ProductDetailPage().AddToCart.click();
                    Thread.sleep(3000);
                }catch (Exception message){
                    System.out.println(a+" is not in stock");
                }
            }
            Driver.get().get(ProductUrl);
        }
    }



    @Then("go to cart")
    public void goToCart() {

        new DashBoardPage().Cart.click();

    }

    @Then("verify product on the cart")
    public void verifyProductOnTheCart() {


        for (int a=0;a<new CartPage().CartProducts.size();a++){
            String expect=listProduct.get(a).substring(0,85);
            String actual= (String) new CartPage().ListOfCartProductc().get(a);
            Assert.assertEquals(expect,actual.substring(0,85));

        }

    }


}
