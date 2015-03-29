package sqhive.com.lightstick.communication;

/**
 * Created by mladen on 28/03/15.
 */
abstract public class Channel {


    /**
     * Helper method to write through the channel.
     * @param s
     */
    public void write(String s) {

    }

    /**
     * Helper method to read.
     * @return
     */
    public String read() {
        String r = null;
        return r;
    }

    /**
     * Write bytes to the channel.
     * @param b
     */
    abstract public void writeBytes(byte[] b);

    /**
     * Read bytes from the channel.
     * @param length the length of bytes to read.
     * @return
     */
    abstract public byte[] readBytes(int length);
}
