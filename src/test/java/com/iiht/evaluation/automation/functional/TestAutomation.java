package com.iiht.evaluation.automation.functional;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.App;
import com.iiht.evaluation.automation.testutils.MasterData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import com.iiht.evaluation.automation.SubActivities;
import org.testng.annotations.*;

import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;

public class TestAutomation extends App {

    @Test
    public void test_click_available_example() throws IOException {
        String example_name = MasterData.test_herokuapp_upload_download_master_data.get("example_name");
        boolean testcase_status = true;
        try {
            boolean click_available_example_succeed = Activities.click_available_example(driver,example_name);
            System.out.println("click_available_example_succeed " + click_available_example_succeed);
            if (!click_available_example_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public void test_download_file() throws IOException {
        String file_name = MasterData.test_herokuapp_upload_download_master_data.get("file_to_download");
        boolean testcase_status = true;
        try {
            boolean download_file_succeed = Activities.download_file(driver,file_name);
            System.out.println("download_file_succeed " + download_file_succeed);
            if (!download_file_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public void test_check_file_exist_in_download_folder() throws IOException {
        String file_name = MasterData.test_herokuapp_upload_download_master_data.get("file_to_download");
        boolean testcase_status = true;
        try {
            boolean check_file_exist_in_download_folder_succeed = Activities.check_file_exist_in_download_folder(driver,file_name);
            System.out.println("check_file_exist_in_download_folder_succeed " + check_file_exist_in_download_folder_succeed);
            if (!check_file_exist_in_download_folder_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public void test_upload_file() throws IOException {
        String file_name = MasterData.test_herokuapp_upload_download_master_data.get("file_to_upload");
        boolean testcase_status = true;
        try {
            boolean upload_file_succeed = Activities.upload_file(driver,file_name);
            System.out.println("upload_file_succeed " + upload_file_succeed);
            if (!upload_file_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }



}