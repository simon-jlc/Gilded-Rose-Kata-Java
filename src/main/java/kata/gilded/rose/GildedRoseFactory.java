package kata.gilded.rose;
import java.util.ArrayList;
import java.util.List;

import kata.gilded.rose.wrapper.AbstractItemWrapper;
import kata.gilded.rose.wrapper.CheeseItemWrapper;
import kata.gilded.rose.wrapper.LegendaryItemWrapper;
import kata.gilded.rose.wrapper.StandardItemWrapper;
import kata.gilded.rose.wrapper.TicketItemWrapper;


/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public class GildedRoseFactory {

	private List<AbstractItemWrapper> items;
	
	public GildedRoseFactory() {
		this.items = new ArrayList<>();
	}

	public void addItem(List<Item> items) {
		for(Item item : items) {
			addItem(item);
		}
	}

	public void updateQuality() {
		for(AbstractItemWrapper iWrapper : items) {
			iWrapper.updateQuality();
		}
	}
	
	private void addItem(Item item) {
		if(item.getName().startsWith("Aged Brie")) {
			items.add(new CheeseItemWrapper(item));
		} else if(item.getName().startsWith("Backstage passes")) {
			items.add(new TicketItemWrapper(item));
		} else if(item.getName().startsWith("Sulfuras")) {
			items.add(new LegendaryItemWrapper(item));
		} else {
			items.add(new StandardItemWrapper(item));
		}
	}
}
