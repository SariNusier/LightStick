package sqhive.com.lightstick.sliders;

/**
 * Created by mladen on 26/03/15.
 */
public interface SliderListener {

    /**
     ** Constants
     */
    public enum Type {
        MOVE_LISTENER,
        CHANGE_LISTENER,
    };

    /**
     * This is fired when the slider is moved.
     */
    public void onMove();

    /**
     * This is fired when the slider is changed.
     */
    public void onChange();
}
