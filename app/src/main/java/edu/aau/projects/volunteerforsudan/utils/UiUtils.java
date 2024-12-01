package edu.aau.projects.volunteerforsudan.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class UiUtils {
    public static boolean isEmpty(EditText editText){
        return !TextUtils.isEmpty(editText.getText());
    }

    public static boolean verifyFields(EditText... fields){
        if (fields.length == 0)
            return false;
        else {
            for (int i = 0; i < fields.length; i++) {
                if (isEmpty(fields[i]))
                    return false;
            }
        }
        return true;
    }

    public static void makeToast(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void makeToast(int msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
