package com.cn.tink.simpledemo;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Utils {

    public static List<ServerData> getServerData(String fileName, Context context) {
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
        Gson gson = new Gson();
        List<ServerData> list = gson.fromJson(stringBuffer.toString(), new TypeToken<List<ServerData>>() {
        }.getType());
        return list;
    }
}
