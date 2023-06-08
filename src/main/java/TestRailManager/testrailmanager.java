package TestRailManager;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class testrailmanager {

    public static String TEST_RUN_ID="1";
    public static String TEST_RUN_ENGINE_URL="https://mayankautomation.testrail.io/";
    public  static int TEST_CASE_PASS_STATUS=1;
    public static int  TEST_CASE_FAIL_STATUS=5;
    public static String TEST_RAIL_USERNAME="kumarmayank0605@gmail.com";
    public static String TEST_RAIL_PASSWORD="Hello@123";


    public static  void addTestCaseStatusToTestRail(String testcaseid,int status,String error){
        String testRunID=TEST_RUN_ID;
        APIClient client=new APIClient(TEST_RUN_ENGINE_URL);

        client.setUser(TEST_RAIL_USERNAME);
        client.setPassword(TEST_RAIL_PASSWORD);

        Map<String,Object> data=new HashMap<>();
        data.put("status_id",status);
        data.put("comment","this test case is used for Google Automation");

        try {
            client.sendPost("add_result_for_case"+"/"+testRunID+"/"+testcaseid,data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }


}
