package kata.gilded.rose.wrapper;
import kata.gilded.rose.Item;





/**
 * 
 * @since 16 août 2015
 * @author simon 
 */
public abstract class AbstractItemWrapper {

	protected Item item;

	public AbstractItemWrapper(Item item) {
		super();
		this.item = item;
	}

	public abstract void updateQuality();
}
