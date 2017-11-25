package Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ziyi liu on 11/25/2017.
 */

public class Speaker implements Parcelable {
    private int selfie;
    private String name;

    public Speaker(int selfie, String name) {
        this.selfie = selfie;
        this.name = name;
    }

    public Speaker(Parcel input) {
        selfie = input.readInt();
        name = input.readString();
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
}
