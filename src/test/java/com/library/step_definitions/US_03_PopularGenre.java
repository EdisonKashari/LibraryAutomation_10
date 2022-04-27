package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_03_PopularGenre {

    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name order by 2 desc;");

    }
    @Then("verify that “Classic\" is the most popular book genre.")
    public void verify_that_classic_is_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name order by 2 desc;");
        String actualPopularBookGenre=DB_Util.getFirstRowFirstColumn();
    String expectedPopularBookGenre="Classic";
        Assert.assertEquals(expectedPopularBookGenre,actualPopularBookGenre);

    }

}
