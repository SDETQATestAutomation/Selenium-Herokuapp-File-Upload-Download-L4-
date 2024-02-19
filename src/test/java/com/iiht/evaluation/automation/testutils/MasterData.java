package com.iiht.evaluation.automation.testutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterData {
	public static final Map<String, String> test_herokuapp_upload_download_master_data = new HashMap<>();
	
	static {


		/* **********************************/
		test_herokuapp_upload_download_master_data.put("example_name","File Download");
		test_herokuapp_upload_download_master_data.put("file_to_download","test-file.txt");
		test_herokuapp_upload_download_master_data.put("file_to_upload","my_image.png");

	}
}
