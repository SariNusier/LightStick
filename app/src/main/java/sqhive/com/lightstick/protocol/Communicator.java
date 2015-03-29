package sqhive.com.lightstick.protocol;

import sqhive.com.lightstick.communication.Channel;

/**
 * Created by mladen on 28/03/15.
 */
public class Communicator {

    /* Channel to communicate through.
     */
    private Channel channel;

    /**
     * Constructor for passed channel.
     * @param channel
     */
    public Communicator(Channel channel) {
        setChannel(channel);
    }

    /**
     * Set the communication channel.
     * @param channel
     */
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
