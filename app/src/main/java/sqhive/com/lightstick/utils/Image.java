package sqhive.com.lightstick.utils;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sari on 26/03/15.
 */
public class Image {

    List<Slice> slices;
    Bitmap bitmap;

    public Image(Bitmap bitmap){
        this.bitmap = bitmap;
        slices = sliceBitmap(bitmap);
    }

    public List<Slice> getSlices(){
        return slices;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public List<Slice> sliceBitmap(Bitmap bitmap){
        List<Slice> toReturn = new ArrayList<>();

        for(int i = 0; i<bitmap.getWidth(); i++){
            List<Pixel> curSlice = new ArrayList<>();

            for(int j = 0 ; j<bitmap.getHeight();i++){
                int unParsedColor = bitmap.getPixel(i,j);
                RGB color = new RGB((byte)Color.red(unParsedColor),(byte)Color.green(unParsedColor),
                        (byte)Color.blue(unParsedColor));
                curSlice.add(new Pixel(color));
            }
            toReturn.add(new Slice(curSlice));
        }

        return toReturn;
    }
}
