package com.iiht.evaluation.automation;

import java.util.HashMap;
import java.util.Map;

public class locators {
    public static final Map<String, String> herokuapp_upload_download_element = new HashMap<>();

    static {
        herokuapp_upload_download_element.put("example_name_link", "//div[@id='content']/descendant::a[text()='$(example_name)']");
        herokuapp_upload_download_element.put("file_to_download_link", "//div[@id='content']//descendant::a[text()='$(file_to_download)']");
        herokuapp_upload_download_element.put("file_to_upload_input", "//input[@id='file-upload']");
        herokuapp_upload_download_element.put("file_to_upload_button", "//input[@id='file-submit']");
        herokuapp_upload_download_element.put("file_upload_message", "//div[@id='content']/descendant::h3");
        herokuapp_upload_download_element.put("uploaded_file_name", "//div[@id='uploaded-files']");






    }
}
