package com.hua.h5loader_core;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 17:52
 */

public class BaseParam implements Parcelable{

    private int webType;

    public int getWebType() {
        return webType;
    }

    /**
     * builder创建参数时会调用此方法填充参数对象。
     * 这里传入的是BaseBuilder，因此实现需要强转为自身的builder对象
     * 再进行赋值。
     *
     * @param builder the builder
     */
    public void fill(BaseBuilder builder){
        this.webType = builder.webType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.webType);
    }

    public BaseParam() {
    }

    protected BaseParam(Parcel in) {
        this.webType = in.readInt();
    }

    public static final Creator<BaseParam> CREATOR = new Creator<BaseParam>() {
        @Override
        public BaseParam createFromParcel(Parcel source) {
            return new BaseParam(source);
        }

        @Override
        public BaseParam[] newArray(int size) {
            return new BaseParam[size];
        }
    };
}
