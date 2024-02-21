package data.provider;

import core.helpper.ExcelHelper;
import core.helpper.JSONHelper;
import org.testng.annotations.DataProvider;

public class ProductData {
//    @DataProvider(name = "productData")
//    public Object[][] data(){
//        return new Object[][] {
//                {"standard_user", "secret_sauce", "Sauce Labs Backpack"},
//                {"problem_user", "secret_sauce", "Sauce Labs Fleece Jacket"},
//                {"visual_user", "secret_sauce", "Sauce Labs Onesie"},
//        };
//    }

    @DataProvider(name = "productDataFromJSON")
    public Object[][] dataFromJSON(){
        return JSONHelper.readJsonFromFile("src\\test\\java\\data\\driven\\product_data.json");
    }
    @DataProvider(name = "productDataFromExcel")
    public Object[][] dataFromExcel(){
        return ExcelHelper.readJsonFromExcel("src\\test\\java\\data\\driven\\data.xlsx");
    }
}
