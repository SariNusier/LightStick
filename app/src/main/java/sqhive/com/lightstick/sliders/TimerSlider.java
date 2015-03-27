package sqhive.com.lightstick.sliders;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mladen on 26/03/15.
 */
public class TimerSlider extends Slider {


    private int interval;

    private Timer timer;


    /**
     * Constructor for the slider.
     * || Make sure to call the parent constructor.
     *
     * @param interval
     */
    public TimerSlider(int interval) {
        super();

        this.interval = interval;

        timer = new Timer();
        timer.schedule(new SliderTask(), 0, this.interval);
    }

    /**
     *
     */
    @Override
    public void forward() {
        super.forward();
    }


    /**
     *
     */
    private class SliderTask extends TimerTask {
        @Override
        public void run() {
            forward();
        }
    }

}
