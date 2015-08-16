package kata.gilded.rose.wrapper;
import kata.gilded.rose.Item;



/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public class StandardItemWrapper extends AbstractItemWrapper {

	public StandardItemWrapper(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		
		if(item.quality >= 0) {
			item.quality--;
		}
		
		if(item.sellIn <= 0) {
			item.quality--;
		}
		
		item.sellIn--;
	}
}
