package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class US_01_Step_Definitions {


    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("SELECT DISTINCT count(id) FROM users");


    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        DB_Util.runQuery("SELECT count(id) FROM users");
        String actual = DB_Util.getFirstRowFirstColumn();

        DB_Util.runQuery("SELECT DISTINCT count(id) FROM users");
        String expected = DB_Util.getFirstRowFirstColumn();

                assertEquals(expected, actual);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Util.runQuery("SELECT * FROM users");
    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> dataTable) {

        List<String> actual = DB_Util.getAllColumnNamesAsList();

        assertEquals(dataTable, actual);

    }


}
