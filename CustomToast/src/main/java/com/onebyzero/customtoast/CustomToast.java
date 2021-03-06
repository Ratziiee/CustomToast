package com.onebyzero.customtoast;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class CustomToast {

    private Context context;
    private int icon=R.drawable.ic_warning_white_24dp;
    private String message="No text!";
    private int cardBackgroundColor=android.R.color.black;
    private float cardElevation=4;
    private float cardCornerRadius=8;
    private float textSize=16;
    private Typeface typeface=Typeface.DEFAULT;
    private int gravity=-91;
    private int xOffset;
    private int yOffset;

    public CustomToast() {
    }

    public CustomToast(Context context){
        this.context=context;
    }

    public CustomToast setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public CustomToast setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomToast setCardBackgroundColor(int cardBackgroundColor) {
        this.cardBackgroundColor = cardBackgroundColor;
        return this;
    }

    public CustomToast setCardElevation(float elevation){
        this.cardElevation=elevation;
        return this;
    }

    public CustomToast setCardRadius(float radius){
        this.cardCornerRadius=radius;
        return this;
    }

    public CustomToast setTextSize(float textSize){
        this.textSize=textSize;
        return this;
    }

    public CustomToast setTypeFace(Typeface typeface){
        this.typeface=typeface;
        return this;
    }

    public CustomToast setGravity(int gravity, int xOffset, int yOffset){
        this.gravity=gravity;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        return this;
    }

    /**
     * Creates the toast with initialized variables. And returns the custom toast.
     * @param duration Duration of the toast message.
     * @return Toast object.
     */
    public Toast createToast(int duration){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.toast_layout,null);
        CardView cardView=view.findViewById(R.id.cardView);
        ImageView toastIcon=view.findViewById(R.id.toastIcon);
        TextView toastMessage=view.findViewById(R.id.toastMessage);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cardView.setCardBackgroundColor(context.getColor(cardBackgroundColor));
        }else{
            cardView.setBackgroundColor(context.getResources().getColor(cardBackgroundColor));
        }
        cardView.setCardElevation(cardElevation);
        cardView.setRadius(cardCornerRadius);
        toastIcon.setImageDrawable(context.getDrawable(icon));
        toastMessage.setTextSize(textSize);
        toastMessage.setText(message);
        toastMessage.setTypeface(typeface);

        Toast toast=new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        if (gravity!=-91) toast.setGravity(gravity,xOffset,yOffset);
        return toast;
    }

    /**
     * Pre-Set Info toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast
     */
    public static Toast info(Context context, String message, int duration){
        return new CustomToast(context)
                .setIcon(R.drawable.ic_info_black_24dp)
                .setMessage(message)
                .setCardBackgroundColor(R.color.infoColor)
                .createToast(duration);
    }

    /**
     * Pre-Set Centered Info toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast centerInfo(Context context, String message, int duration){
        Toast toast= warning(context,message,duration);
        toast.setGravity(Gravity.CENTER,0,0);
        return toast;
    }

    /**
     * Pre-Set Top Info toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast topInfo(Context context, String message, int duration){
        Toast toast= warning(context,message,duration);
        toast.setGravity(Gravity.TOP,0,64);
        return toast;
    }

    /**
     * Pre-Set Warning toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast warning(Context context, String message, int duration){
        return new CustomToast(context)
                .setIcon(R.drawable.ic_warning_white_24dp)
                .setMessage(message)
                .setCardBackgroundColor(R.color.warningColor)
                .createToast(duration);
    }

    /**
     * Pre-Set Centered Warning toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast centerWarning(Context context, String message, int duration){
        Toast toast= warning(context,message,duration);
        toast.setGravity(Gravity.CENTER,0,0);
        return toast;
    }

    /**
     * Pre-Set Top Warning toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast topWarning(Context context, String message, int duration){
        Toast toast= warning(context,message,duration);
        toast.setGravity(Gravity.TOP,0,64);
        return toast;
    }

    /**
     * Pre-Set Error toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast error(Context context, String message, int duration){
        return new CustomToast(context)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setMessage(message)
                .setCardBackgroundColor(R.color.errorColor)
                .createToast(duration);
    }

    /**
     * Pre-Set Centered Error toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast centerError(Context context, String message, int duration){
        Toast toast= error(context,message,duration);
        toast.setGravity(Gravity.CENTER,0,0);
        return toast;
    }

    /**
     * Pre-Set Top Error toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast topError(Context context, String message, int duration){
        Toast toast= error(context,message,duration);
        toast.setGravity(Gravity.TOP,0,64);
        return toast;
    }

    /**
     * Pre-Set Success toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast success(Context context, String message, int duration){
        return new CustomToast(context)
                .setIcon(R.drawable.ic_check_circle_black_24dp)
                .setMessage(message)
                .setCardBackgroundColor(R.color.successColor)
                .createToast(duration);
    }

    /**
     * Pre-Set Centered Success toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast centerSuccess(Context context, String message, int duration){
        Toast toast= success(context,message,duration);
        toast.setGravity(Gravity.CENTER,0,0);
        return toast;
    }

    /**
     * Pre-Set Top Success toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast topSuccess(Context context,String message,int duration){
        Toast toast= success(context,message,duration);
        toast.setGravity(Gravity.TOP,0,64);
        return toast;
    }

    /**
     * Customizable toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param icon Icon that will be on the left side of the toast message.
     * @param cardBackgroundColor Background color of toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast custom(Context context, String message, int icon, int cardBackgroundColor, int duration){
        return new CustomToast(context)
                .setIcon(icon)
                .setMessage(message)
                .setCardBackgroundColor(cardBackgroundColor)
                .createToast(duration);
    }

    /**
     * Customizable centered toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param icon Icon that will be on the left side of the toast message.
     * @param cardBackgroundColor Background color of toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast customCenter(Context context, String message, int icon, int cardBackgroundColor, int duration){
        Toast toast= custom(context,message,icon,cardBackgroundColor,duration);
        toast.setGravity(Gravity.CENTER,0,0);
        return toast;
    }

    /**
     * Customizable top toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param icon Icon that will be on the left side of the toast message.
     * @param cardBackgroundColor Background color of toast.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast customTop(Context context, String message, int icon, int cardBackgroundColor, int duration){
        Toast toast= custom(context,message,icon,cardBackgroundColor,duration);
        toast.setGravity(Gravity.TOP,0,64);
        return toast;
    }

    /**
     * Fully customizable toast
     * @param context Context
     * @param message Message that will be on the toast.
     * @param icon Icon that will be on the left side of the toast message.
     * @param cardBackgroundColor Background color of toast.
     * @param cornerRadius Corner radius of the toast.
     * @param elevation Elevation of the toast.
     * @param textSize Text size of the toast message.
     * @param typeface Typeface of the toast message.
     * @param gravity Gravity of the toast.
     * @param xOffset X axis offset for toast gravity.
     * @param yOffset Y axis offset for toast gravity.
     * @param duration Duration of the toast message.
     * @return Toast.
     */
    public static Toast allCustom(Context context, String message, int icon, int cardBackgroundColor, float cornerRadius, float elevation,
                                  float textSize, Typeface typeface, int gravity, int xOffset, int yOffset, int duration){
        Toast toast=new CustomToast(context)
                .setIcon(icon)
                .setMessage(message)
                .setCardBackgroundColor(cardBackgroundColor)
                .setCardElevation(elevation)
                .setCardRadius(cornerRadius)
                .setTextSize(textSize)
                .setTypeFace(typeface)
                .createToast(duration);
        if (gravity!=-1) toast.setGravity(gravity,xOffset,yOffset);
        return toast;
    }

    /**
     * Simple way to create CustomToast. You can use it to fully customize toast.
     * @param context Context
     * @return CustomToast object
     */
    public static CustomToast allCustom(Context context){
        return new CustomToast(context);
    }

}
