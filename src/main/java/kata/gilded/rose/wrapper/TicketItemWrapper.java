package kata.gilded.rose.wrapper;
import kata.gilded.rose.Item;



/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public class TicketItemWrapper extends AbstractItemWrapper {

	public TicketItemWrapper(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		
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
	}
}
