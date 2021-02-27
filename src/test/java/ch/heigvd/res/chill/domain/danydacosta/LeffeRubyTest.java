package ch.heigvd.res.chill.domain.danydacosta;

import ch.heigvd.res.chill.domain.Bartender;
import ch.heigvd.res.chill.domain.wasadigi.Boxer;
import ch.heigvd.res.chill.protocol.OrderRequest;
import ch.heigvd.res.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeffeRubyTest {

  @Test
  void thePriceAndNameForLeffeRubyShouldBeCorrect() {
    LeffeRuby beer = new LeffeRuby();
    assertEquals(beer.getName(), LeffeRuby.NAME);
    assertEquals(beer.getPrice(), LeffeRuby.PRICE);
  }

  @Test
  void aBartenderShouldAcceptAnOrderForLeffeRuby() {
    Bartender jane = new Bartender();
    String productName = "ch.heigvd.res.chill.domain.danydacosta.LeffeRuby";
    OrderRequest request = new OrderRequest(3, productName);
    OrderResponse response = jane.order(request);
    BigDecimal expectedTotalPrice = LeffeRuby.PRICE.multiply(new BigDecimal(3));
    assertEquals(expectedTotalPrice, response.getTotalPrice());
  }

}