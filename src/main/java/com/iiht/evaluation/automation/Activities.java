package com.iiht.evaluation.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.iiht.evaluation.automation.SubActivities.do_javascript_click;

public class Activities {

    public static boolean click_available_example(WebDriver driver, String example_name) {
        String example_name_link_xpath = locators.herokuapp_upload_download_element.get("example_name_link").replace("$(example_name)", example_name);

        WebElement example_name_link_element = SubActivities.find_element_use_xpath(driver, example_name_link_xpath);
        if (example_name_link_element == null) {
            return false;
        }
        example_name_link_element.click();
        return true;
    }

    public static boolean download_file(WebDriver driver, String file_to_download) {
        String file_to_download_link_xpath = locators.herokuapp_upload_download_element.get("file_to_download_link").replace("$(file_to_download)", file_to_download);
        WebElement file_downloader_name_link_element = SubActivities.find_element_use_xpath(driver, file_to_download_link_xpath);
        if (file_downloader_name_link_element == null) {
            return false;
        }
        clear_download_folder(driver);
        do_javascript_click(driver,file_downloader_name_link_element);
        return true;
    }

    public static boolean check_file_exist_in_download_folder(WebDriver driver, String file_to_download){
        String folderPath = "./downloads";
        File file = new File(folderPath, file_to_download);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        dir.delete();
    }
    public static void clear_download_folder(WebDriver driver){
        String folderPath = "./downloads";
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            // Get all files and subdirectories within the folder
            File[] files = folder.listFiles();

            // Iterate through each file and subdirectory
            if (files != null) {
                for (File file : files) {
                    // Delete the file or directory
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }

            System.out.println("Folder content cleared successfully.");
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }

    public static boolean upload_file(WebDriver driver, String file_to_upload) throws InterruptedException {
        String file_to_upload_input_xpath = locators.herokuapp_upload_download_element.get("file_to_upload_input");
        String file_to_upload_button_xpath = locators.herokuapp_upload_download_element.get("file_to_upload_button");
        String file_upload_message_xpath = locators.herokuapp_upload_download_element.get("file_upload_message");
        String uploaded_file_name_xpath = locators.herokuapp_upload_download_element.get("uploaded_file_name");

        String file_to_upload_location = System.getProperty("user.dir")+"upload/"+file_to_upload;
        System.out.println("file_to_upload_location " + file_to_upload_location);
        WebElement file_to_upload_input_element = SubActivities.find_element_use_xpath(driver, file_to_upload_input_xpath);
        if (file_to_upload_input_element == null) {
            return false;
        }
        file_to_upload_input_element.sendKeys(file_to_upload_location);
        Thread.sleep(5000);
        WebElement file_to_upload_button_element = SubActivities.find_element_use_xpath(driver, file_to_upload_button_xpath);
        if (file_to_upload_button_element == null) {
            return false;
        }
        do_javascript_click(driver,file_to_upload_button_element);
        Thread.sleep(5000);
        WebElement file_upload_message_element = SubActivities.find_element_use_xpath(driver, file_upload_message_xpath);
        if (file_upload_message_element == null) {
            return false;
        }
        String file_upload_message_text=file_upload_message_element.getText();
        System.out.println("file_upload_message_text " + file_upload_message_text);
        if(!file_upload_message_text.equals("File Uploaded!")){
            return false;
        }
        WebElement uploaded_file_name_xpath_element = SubActivities.find_element_use_xpath(driver, uploaded_file_name_xpath);
        if (uploaded_file_name_xpath_element == null) {
            return false;
        }
        String uploaded_file_name_xpath_text=uploaded_file_name_xpath_element.getText();
        System.out.println("uploaded_file_name_xpath_text " + uploaded_file_name_xpath_text);
        if(!uploaded_file_name_xpath_text.equals(file_to_upload)){
            return false;
        }
        return true;
    }

}


