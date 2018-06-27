package com.inredec.atutor.utilitieslayer;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

public class utils {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

    public static void showToast(Context context, @StringRes int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
