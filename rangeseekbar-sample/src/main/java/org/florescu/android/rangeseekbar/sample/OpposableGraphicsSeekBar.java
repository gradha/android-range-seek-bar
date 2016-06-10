package org.florescu.android.rangeseekbar.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;

import org.florescu.android.rangeseekbar.RangeSeekBar;
import org.florescu.android.util.BitmapUtil;

public class OpposableGraphicsSeekBar extends RangeSeekBar<Integer>
{
    public OpposableGraphicsSeekBar(Context context)
    {
        super(context);
    }

    public OpposableGraphicsSeekBar(Context context,
        AttributeSet attrs)
    {
        super(context, attrs);
    }

    public OpposableGraphicsSeekBar(Context context,
        AttributeSet attrs,
        int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override public void drawThumbDecoration(float x,
        float y,
        boolean pressed,
        Canvas canvas,
        boolean areSelectedValuesDefault,
        boolean leftThumb)
    {
        Bitmap extraThumb = BitmapUtil.drawableToBitmap(
            getContext().getDrawable(R.mipmap.ic_launcher)
        );
        final float h = extraThumb.getHeight() / 2;

        Matrix matrix = new Matrix();
        matrix.setRotate(leftThumb ? 45 : -45);
        matrix.postTranslate(
            x + (leftThumb ? -h : 0),
            y + (leftThumb ? -h * 0.5f : +h));

        canvas.drawBitmap(
            extraThumb,
            matrix,
            null
        );
    }
}
