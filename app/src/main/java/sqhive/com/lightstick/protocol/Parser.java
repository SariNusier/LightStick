package sqhive.com.lightstick.protocol;

/**
 * Created by mladen on 28/03/15.
 */
public class Parser {

    private Data[] data;

    /**
     * Constructor with data.
     * @param data
     */
    public Parser(Data[] data) {
        this.data = data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
