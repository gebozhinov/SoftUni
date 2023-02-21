package gifts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class GiftFactoryTests {


    private GiftFactory giftFactory;
    private static final Gift gift1 = new Gift("Car", 15);
    private static final Gift gift2 = new Gift("Bike", 7);
    private static final Gift gift3 = new Gift("Phone", 13);
    private static final Gift gift4 = new Gift("Teddy Bear", 150);
    private static final Gift gift5 = new Gift("Bitcoin", 21);

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
        addGifts(giftFactory);
    }

    @Test
    public void testGetCountShouldReturnNumberOfPresents() {
        assertEquals(5, giftFactory.getCount());
    }

    @Test
    public void testCreateGiftShouldReturnStringIfGiftIsCreated() {
        Gift gift = new Gift("Sneakers", 22);
        assertEquals(String.format("Successfully added gift %s with magic %.2f.", gift.getType(), gift.getMagic()),
                giftFactory.createGift(gift));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowIfGiftIsAlreadyCreated() {
        Gift gift = new Gift("Car", 13);
        giftFactory.createGift(gift);
    }

    @Test
    public void testRemoveGiftShouldReturnTrueIfGiftIsRemoved() {
        assertTrue(giftFactory.removeGift("Car"));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowIfTheGivenNameIsNull() {
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowIfTheGivenNameIsEmptyString() {
        giftFactory.removeGift("    ");
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        Gift gift = giftFactory.getPresentWithLeastMagic();
        assertEquals("Bike", gift.getType());
        assertEquals(7, gift.getMagic(), 0);
    }

    @Test
    public void testGetPresentShouldReturnThePresentWithGivenName() {
        Gift gift = giftFactory.getPresent("Teddy Bear");
        assertEquals("Teddy Bear", gift.getType());
        assertEquals(150, gift.getMagic(), 0);
    }

    @Test
    public void testGetPresents() {
        Collection<Gift> gifts = giftFactory.getPresents();
        assertTrue(gifts.contains(gift1));
        assertTrue(gifts.contains(gift2));
        assertTrue(gifts.contains(gift3));
        assertTrue(gifts.contains(gift4));
        assertTrue(gifts.contains(gift5));

    }

    private void addGifts(GiftFactory giftFactory) {
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.createGift(gift4);
        giftFactory.createGift(gift5);
    }

}
