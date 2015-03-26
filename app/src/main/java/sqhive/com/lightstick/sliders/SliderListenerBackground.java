package sqhive.com.lightstick.sliders;

import java.util.ArrayList;

/**
 * Created by mladen on 26/03/15.
 */
public class SliderListenerBackground {

    /** Holder for the listeners.
     */
    ArrayList<ArrayList<SliderListener>> listeners = new ArrayList<ArrayList<SliderListener>>();


    /**
     * Construct all listeners.
     */
    public SliderListenerBackground() {
        for (SliderListener.Type l : SliderListener.Type.values()) {
            listeners.add(new ArrayList<SliderListener>());
        }
    }

    /**
     * Add onMove listener.
     * @param listener
     */
    public void setOnMoveListener(SliderListener listener) {
        this.listeners.get(SliderListener.Type.MOVE_LISTENER.ordinal()).add(listener);
    }

    /**
     * Add onChange listener.
     * @param listener
     */
    public void setOnChangeListener(SliderListener listener) {
        this.listeners.get(SliderListener.Type.CHANGE_LISTENER.ordinal()).add(listener);
    }


    public void callListeners(SliderListener.Type listener) {
        for (SliderListener l : this.listeners.get(listener.ordinal())) {
            switch (listener) {
                case CHANGE_LISTENER: {
                    l.onChange();
                    break;
                }
                case MOVE_LISTENER: {
                    l.onMove();
                    break;
                }
            }
        }
    }
}
