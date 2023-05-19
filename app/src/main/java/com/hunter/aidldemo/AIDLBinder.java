package com.hunter.aidldemo;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.TimeUtils;

public class AIDLBinder extends ICat.Stub{
    private String text;
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void setText(String text) throws RemoteException {
        this.text = text;
    }

    public String getText() {
        if (!TextUtils.isEmpty(text)) {
            return text;
        }
        return "";
    }
}
