package com.company;

import org.junit.Test;

public class Main {

  String theToken;

  @Before
  public void login_to_chat_bot() {
    given().request().body("username, password").
      when().
      post("/chatbot.dev1.aisera.net/aisera/webchat/login").
      then().
      statusCode(200).
    // response provides a token, extract it, and sstore into theToken

  }

  @Test
  public void make_a_request() {
    given().request().header("authorization", "Mutual " + theToken)
      .header("get-over-post", true)
      .body("query to webchat")
    when().
      post("/chatbot.dev1.aisera.net/aisera/webchat/receive").
      then().
      statusCode(200).
      body(" // this should match what is in the document from Ajay");
  }

  @Test
  public void make_another_request() {
    given().request().header("authorization", "Mutual " + theToken)
      .header("get-over-post", true)
      .body("second query to webchat")
    when().
      post("/chatbot.dev1.aisera.net/aisera/webchat/receive").
      then().
      statusCode(200).
      body(" // this second response");
  }
}
