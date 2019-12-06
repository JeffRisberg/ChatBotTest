package com.company;

import org.junit.Test;

public class Main {

  @Test
  public void login_to_chat_bot() {

    when().
      get("/lotto/{id}", 5).
      then().
      statusCode(200).
      body("lotto.lottoId", equalTo(5),
        "lotto.winners.winnerId", hasItems(23, 54));

  }
}
