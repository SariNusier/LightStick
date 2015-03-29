package sqhive.com.lightstick.communication;

import android.content.Context;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.widget.Toast;

import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import java.io.IOException;
import java.util.List;

/**
 * Created by mladen on 28/03/15.
 */
public class UsbChannel extends Channel {

    /**
     */
    UsbManager manager;

    UsbSerialPort port;

    private List<UsbSerialDriver> availableDrivers;
    private UsbSerialDriver driver;

    /**
     * Constructor for the channel.
     * @param context
     */
    public UsbChannel(Context context) {

        manager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
        findDrivers();

        driver = availableDrivers.get(0);
        UsbDeviceConnection connection = manager.openDevice(driver.getDevice());
        if (connection == null) {

        }
        port = driver.getPorts().get(0);

        try {
            port.open(connection);
            port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);



            Toast.makeText(context.getApplicationContext(), "Read bytes.",
                    Toast.LENGTH_LONG).show();

            port.close();
        } catch (IOException e) {
            // Deal with it.
        }

    }

    /**
     * Find all drivers supported using probing.
     * @return
     */
    public Boolean findDrivers() {
        availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager);
        if (availableDrivers.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Select driver for the port.
     * @param index The index of the driver.
     */
    public void selectDriver(int index) {
        driver = availableDrivers.get(index);
    }

    /**
     * Select a port from the driver.
     * @param port
     */
    public void selectPort(short port) {
        this.port = driver.getPorts().get(port);
    }

    /**
     * Opens an active connection on the port.
     */
    public void openConnection(UsbDeviceConnection connection) throws IOException {
        port.open(connection);
    }

    /**
     * Closes an active connection on the port.
     */
    public void closeConnection() throws IOException {
        port.close();
    }

    /**
     * Configure the port.
     */
    public void configurePort() {
        try {
            port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write a byte array to port.
     * @param bytes
     */
    public void writeBytes(byte[] bytes) {

    }

    /**
     * Read a byte array from port.
     * @param length
     * @return
     */
    public byte[] readBytes(int length) {
        byte buffer[] = new byte[length];
        try {
            int numBytesRead = port.read(buffer, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
