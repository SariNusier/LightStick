package sqhive.com.lightstick.protocol;

/**
 * Created by mladen on 28/03/15.
 */
public class Data {

    private class ItemValues {
        public int red;
        public int green;
        public int blue;
    }

    private class Item {
        public int id;
        public ItemValues values;
    }

    private Item item;

    /**
     * Default constructor.
     */
    public Data() {

    }

    /**
     * Set the data item's id.
     * @param id
     */
    public void setId(int id) {
        this.item.id = id;
    }

    public int getId() {
        return this.item.id;
    }
}
