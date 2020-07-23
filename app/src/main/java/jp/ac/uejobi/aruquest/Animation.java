package jp.ac.uejobi.aruquest;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;

/**
 * Created by uejobi on 2018/11/01.
 */

public class Animation {
    public AnimationDrawable anim;
    public LayoutInflater inflater;
    public ImageView imageView;
    ViewGroup.MarginLayoutParams marginLayoutParams;
    public Drawable[] drImg;

    public Animation() {
        anim = new AnimationDrawable();
    }

    public void setAnimation(LayoutInflater inflater, ImageView imageView) {
        this.inflater = inflater;
        this.imageView = imageView;
        marginLayoutParams = (ViewGroup.MarginLayoutParams)this.imageView.getLayoutParams();
    }

    public AnimationDrawable getAnim() {
        return anim;
    }

    public void setDrImg(Resources res, int img[], int width, int height) {
        drImg = new Drawable[img.length];
        for(int i = 0; i < img.length; i++) {
            drImg[i] = ContextCompat.getDrawable(inflater.getContext(),img[i]);
        }
        Bitmap orgBitmap = ((BitmapDrawable)drImg[0]).getBitmap();
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(orgBitmap, width, height, false);
        drImg[0] = new BitmapDrawable(res, resizedBitmap);
    }

    public void createAnimation(int frame, boolean oneShotFlg){ // img:画像のRID配列 width:リサイズしたい画像の幅 height:リサイズしたい画像の高さ
        for(int i = 0; i < drImg.length; i++){
            anim.addFrame(drImg[i],frame);
        }
        anim.setOneShot(oneShotFlg); // 繰り返し設定
        imageView.setBackgroundDrawable(anim);
    }

    public void setAnimationPos(int leftMargin, int topMargin){
        marginLayoutParams.leftMargin = leftMargin;
        marginLayoutParams.topMargin = topMargin;
    }
}
