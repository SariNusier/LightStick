package sqhive.com.lightstick.sliders;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * Created by mladen on 26/03/15.
 */
public class SensorSlider extends Slider implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer;

    /**
     *
     */
    public SensorSlider(Context context) {
        super();

        senSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     *
     */
    @Override
    public void forward() {
        // Fix to make use of the acceleration.
        super.forward();
    }


    /**
     **
     */
    /**
     *
     * @param sensorEvent
     */
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        if (Math.abs(x) > 1) {
            if (x > 1) {
                forward();
            } else {
                backward();
            }
            Log.d("Sensor", "Value of (x, y, z): " + x + "," + y +  "," + z + ".");
        }
    }

    /**
     *
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
