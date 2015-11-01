package kata.gilded.rose;
import kata.gilded.rose.GildedRose;
import kata.gilded.rose.Item;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class GildedRoseTest {

	private GildedRose gildedRose;
	
	@Before
	public void setUp() {
		gildedRose = new GildedRose();
	}
	
	@After
	public void clearItems() {
		GildedRose.clearItems();
	}

	@Test
	public void shouldDecreaseQulityAndSellInByOneWhenStandardItem() {
		Item standard1 = new Item("+5 Dexterity Vest", 10, 20);
		Item standard2 = new Item("Elixir of the Mongoose", 5, 7);
		Item standard3 = new Item("Conjured Mana Cake", 3, 6);
		
		gildedRose.addItem(standard1);
		gildedRose.addItem(standard2);
		gildedRose.addItem(standard3);
		
		GildedRose.updateQuality();
		
		doItemAssertions(standard1, 9, 19);
		doItemAssertions(standard2, 4, 6);
		doItemAssertions(standard3, 2, 5);
	}
	
	@Test
	public void shouldNotDecreaseQualityWhenStandardQualityIsLessThan0() {
		Item standard = new Item("+5 Dexterity Vest", 10, -10);
		gildedRose.addItem(standard);
		GildedRose.updateQuality();
		doItemAssertions(standard, 9, -10);
	}
	
	@Test
	public void shouldDecreaseQualityBy2WhenStandardSellInIsLessThan0() {
		Item standard = new Item("+5 Dexterity Vest", -10, 5);
		gildedRose.addItem(standard);
		GildedRose.updateQuality();
		doItemAssertions(standard, -11, 3);
	}
	
	@Test
	public void shouldIncreaseQualityByOneWhenAgedBrie() {
		Item agedBrie = new Item("Aged Brie", 2, 0);
		gildedRose.addItem(agedBrie);
		GildedRose.updateQuality();
		doItemAssertions(agedBrie, 1, 1);
	}
	
	@Test
	public void shouldNotUpdateQualityWhenAgedBrieQualityIs50() {
		Item agedBrie = new Item("Aged Brie", 2, 50);
		Item agedBrieNegativeSellIn = new Item("Aged Brie", -10, 55);
		gildedRose.addItem(agedBrie);
		gildedRose.addItem(agedBrieNegativeSellIn);
		GildedRose.updateQuality();
		doItemAssertions(agedBrie, 1, 50);
		doItemAssertions(agedBrieNegativeSellIn, -11, 55);
	}
	
	@Test
	public void shouldIncreaseQualityBy2WhenAgedBrieSellInIsLessThan0() {
		Item agedBrie = new Item("Aged Brie", -1, 10);
		gildedRose.addItem(agedBrie);
		GildedRose.updateQuality();
		doItemAssertions(agedBrie, -2, 12);
	}
	
	@Test
	public void shouldIncreaseQualityBy1WhenBackstagePassesSellInIsGreaterThan10() {
		Item backStagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		gildedRose.addItem(backStagePasses);
		GildedRose.updateQuality();
		doItemAssertions(backStagePasses, 14, 21);
	}
	
	@Test
	public void shouldIncreaseQualityBy2WhenBackstagePassesSellInIsBetween10And5() {
		Item backStagePasses1 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		Item backStagePasses2 = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
		gildedRose.addItem(backStagePasses1);
		gildedRose.addItem(backStagePasses2);
		GildedRose.updateQuality();
		doItemAssertions(backStagePasses1, 9, 22);
		doItemAssertions(backStagePasses2, 5, 22);
	}
	
	@Test
	public void shouldIncreaseQualityBy3WhenBackstagePassesSellInIsBetween5And0() {
		Item backStagePasses1 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		Item backStagePasses2 = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20);
		gildedRose.addItem(backStagePasses1);
		gildedRose.addItem(backStagePasses2);
		GildedRose.updateQuality();
		doItemAssertions(backStagePasses1, 4, 23);
		doItemAssertions(backStagePasses2, 0, 23);
	}
	
	@Test
	public void shouldSetQualityTo0WhenBackstagePassesSellInIsLessOrEqualTo0() {
		Item backStagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		gildedRose.addItem(backStagePasses);
		GildedRose.updateQuality();
		doItemAssertions(backStagePasses, -1, 0);
	}
	
	@Test
	public void shouldNotUdateItemWhenLegendary() {
		Item sulfuras1 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		Item sulfuras2 = new Item("Sulfuras, Hand of Ragnaros", -5, 80);
		Item sulfuras3 = new Item("Sulfuras, Hand of Ragnaros", -5, -5);
		gildedRose.addItem(sulfuras1);
		gildedRose.addItem(sulfuras2);
		gildedRose.addItem(sulfuras3);
		GildedRose.updateQuality();
		doItemAssertions(sulfuras1, 0, 80);
		doItemAssertions(sulfuras2, -5, 80);
		doItemAssertions(sulfuras3, -5, -5);
	}
	
	@Test
	public void shouldNotUdateItemWhenLegendary_() {
		
		
	}
	
	private void doItemAssertions(Item item, int expectedSellIn, int expectedQuality) {
		Assertions.assertThat(item.getQuality()).isEqualTo(expectedQuality);
		Assertions.assertThat(item.getSellIn()).isEqualTo(expectedSellIn);
	}
}
