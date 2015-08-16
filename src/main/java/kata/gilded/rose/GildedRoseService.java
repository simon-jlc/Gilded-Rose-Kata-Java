package kata.gilded.rose;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public class GildedRoseService {

	private final static Predicate<Item> IS_CHEESE = i -> i.getName().startsWith("Aged Brie");
	private final static Predicate<Item> IS_TICKET = i -> i.getName().startsWith("Backstage passes");
	private final static Predicate<Item> IS_LEGENDARY = i -> i.getName().startsWith("Sulfuras");
	private final static Predicate<Item> IS_STANDARD = i -> !i.getName().startsWith("Aged Brie") 
			&& !i.getName().startsWith("Backstage passes")
			&& !i.getName().startsWith("Sulfuras");
	
	private final static Consumer<Item> UPDATE_CHEESE = item -> {
		item.sellIn--;
		
		if(item.quality < 50) {
			item.quality++;
			
			if(item.sellIn < 0) {
				item.quality++;
			}
		}
	};
	
	private final static Consumer<Item> UPDATE_TICKET = item -> {
		if(item.sellIn > 10) {
			item.quality++;
		} else if (item.sellIn > 5) {
			item.quality = item.quality + 2;
		} else if (item.sellIn > 0) {
			item.quality = item.quality + 3;
		} else {
			item.quality = 0;
		}
		
		item.sellIn--;
	};
	
	private final static Consumer<Item> UPDATE_LEGENDARY = item -> {};
	
	private final static Consumer<Item> UPDATE_STANDARD = item -> {
		if(item.quality >= 0) {
			item.quality--;
		}
		
		if(item.sellIn <= 0) {
			item.quality--;
		}
		
		item.sellIn--;
	};
	
	public GildedRoseService() {
	}

	public void updateQuality(List<Item> items) {
		items.stream().filter(IS_CHEESE).forEach(UPDATE_CHEESE);
		items.stream().filter(IS_TICKET).forEach(UPDATE_TICKET);
		items.stream().filter(IS_LEGENDARY).forEach(UPDATE_LEGENDARY);
		items.stream().filter(IS_STANDARD).forEach(UPDATE_STANDARD);
	}
}
