package com.cn.tink.simpledemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/5/11.
 */

public class ServerData  implements Parcelable {

    public int type; //1 为图文混合 2 纯图片

    public String image_url_1;

    public String image_url_2;

    public String title;

    public String content;

    protected ServerData(Parcel in) {
        type = in.readInt();
        image_url_1 = in.readString();
        image_url_2 = in.readString();
        title = in.readString();
        content = in.readString();
    }

    public static final Creator<ServerData> CREATOR = new Creator<ServerData>() {
        @Override
        public ServerData createFromParcel(Parcel in) {
            return new ServerData(in);
        }

        @Override
        public ServerData[] newArray(int size) {
            return new ServerData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(image_url_1);
        dest.writeString(image_url_2);
        dest.writeString(title);
        dest.writeString(content);
    }
}
