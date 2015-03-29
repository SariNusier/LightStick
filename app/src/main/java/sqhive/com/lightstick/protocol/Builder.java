package sqhive.com.lightstick.protocol;

import java.util.ArrayList;

/**
 * Created by mladen on 28/03/15.
 */
public class Builder {

    private ArrayList<Data> data;


    public Builder() {

    }

    /**
     * Add data item to the stack.
     * @param item
     */
    public void addData(Data item) {
        this.data.add(item);
    }
}
