package Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ziyi liu on 11/25/2017.
 */

public class Speaker implements Parcelable {
    private int selfie;
    private String name;
    private int first;

    public Speaker(int selfie, String name, int appear) {
        this.selfie = selfie;
        this.name = name;
        this.first = appear;
    }

    public Speaker(Parcel input) {
        selfie = input.readInt();
        name = input.readString();
        first = input.readInt();
    }
//


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getSelfie());
        dest.writeString(getName());
        dest.writeInt(isFirst());
    }

    public static final Creator<Speaker> CREATOR = new Parcelable.Creator<Speaker>() {

        @Override
        public Speaker createFromParcel(Parcel source) {
            return new Speaker(source);
        }

        @Override
        public Speaker[] newArray(int size) {
            return new Speaker[0];
        }
    };

    public int getSelfie() {
        return selfie;
    }

    public void setSelfie(int selfie) {
        this.selfie = selfie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
