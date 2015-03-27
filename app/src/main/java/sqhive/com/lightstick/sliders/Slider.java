package sqhive.com.lightstick.sliders;

/**
 * Created by mladen on 26/03/15.
 */
public class Slider {

    /** Background for listeners.
     */
    private SliderListenerBackground background;

    public Slider() {
        background = new SliderListenerBackground();
    }

    /**
     **
     */
    private static class DefaultSteps {
        static int FORWARD_STEP = 1;
        static int BACKWARD_STEP = 1;
    }

    /**
     **
     */
    private int position = 0;

    /** Moving mechanism.
     **
     */
    public void forward() {
        forward(DefaultSteps.FORWARD_STEP);
    }
    public void backward() {
        backward(DefaultSteps.BACKWARD_STEP);
    }

    /**
     * Move a step forward.
     * @param step
     */
    public void forward(int step) {
        setPosition(getPosition() + step);
    }
    /**
     * Move a step backward.
     * @param step
     */
    public void backward(int step) {
        setPosition(getPosition() - step);
    }

    /**
     * Set the current position of the slider.
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
        notifyMove();
    }

    /**
     * Get the current position of the slider.
     */
    public int getPosition() {
        return this.position;
    }


    /**
     ** Event registers.
     */

    /**
     *
     */
    public void setOnChangeListener(SliderListener listener) {
        background.setOnChangeListener(listener);
    }


    public void setOnMoveListener(SliderListener listener) {
        background.setOnMoveListener(listener);
    }

    /**
     ** Event handlers.
     */
    /**
     * Notify all onMove listeners.
     */
    protected void notifyMove() {
        notifyChange();
        background.callListeners(SliderListener.Type.MOVE_LISTENER);
    }

    /**
     * Notify all onChange listeners.
     */
    protected void notifyChange() {
        background.callListeners(SliderListener.Type.CHANGE_LISTENER);
    }
}

