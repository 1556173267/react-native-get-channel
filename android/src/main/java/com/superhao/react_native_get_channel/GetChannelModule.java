package com.superhao.react_native_get_channel;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class GetChannelModule extends ReactContextBaseJavaModule {


    public GetChannelModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "GetChannelModule";
    }

    @ReactMethod
    public void getAppMetaData(String key, final Promise promise) {
        String resultData = null;
        if (getReactApplicationContext() == null || TextUtils.isEmpty(key)) {
            resultData = null;
        }
        try {
            PackageManager packageManager = getReactApplicationContext().getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getReactApplicationContext().getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }
            }
            promise.resolve(resultData);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            promise.reject(e);
        }

    }
}
