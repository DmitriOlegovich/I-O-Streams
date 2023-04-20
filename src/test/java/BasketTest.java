import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class BasketTest extends TestCase {

    @Test
    public void testAddToBasket(){
        String[] products = {"Молоко", "Хлеб", "Гречка"};
        int[] prices = {78, 50, 64};
        Basket basket = new Basket(products, prices);

        basket.addToCart(0,2);
        basket.addToCart(1, 4);
        int[] actual = basket.getQuantities();
        int[] expected = {2, 4, 0};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLoadFromTxt(){
        Basket basket = Basket.loadFromTxtFile(new File("src/test/resources/test_basket.txt"));
        String[] actualGoods = basket.getGoods();
        String[] expectedGoods = {"Молоко", "Хлеб", "Гречка"};

        Assertions.assertArrayEquals(expectedGoods, actualGoods);

    }

}