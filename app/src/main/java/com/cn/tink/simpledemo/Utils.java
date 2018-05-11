package com.cn.tink.simpledemo;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Utils {

    public static String getServerData(String fileName, Context context) {
        AssetManager assetManager = context.getAssets();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream is = assetManager.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
