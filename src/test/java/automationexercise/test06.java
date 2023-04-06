package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class test06 extends TestBase {

    @Test
    public void test01() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        driver.findElement(By.xpath("//html")).isDisplayed();
//        4. Click on 'Contact Us' button
        WebElement contactUs = driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));

        contactUs.click();
//        5. Verify 'Contact Us' is visible
        driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        wait(2);
//        6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kenaa@example.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Test");
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test message");
//        7. Upload file
        wait(2);
        WebElement sendFile = driver.findElement(By.xpath("//input[@type='file']"));
        wait(2);
        sendFile.sendKeys("C:\\Users\\nurik\\Desktop\\Yeni Text Document (2).txt");
//        8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();
//        9. Click OK button
        wait(2);
        driver.switchTo().alert().accept();
//


//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(success.getText().contains("Success!"));
//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@href='/']")).click();


    }
}
