package kata.gilded.rose.wrapper;
import kata.gilded.rose.Item;



/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public class CheeseItemWrapper extends AbstractItemWrapper {

	public CheeseItemWrapper(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {

		item.sellIn--;
		
		if(item.quality < 50) {
			item.quality++;
			
			if(item.sellIn < 0) {
				item.quality++;
			}
		}
	}
}
