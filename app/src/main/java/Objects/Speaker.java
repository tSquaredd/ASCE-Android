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
    private String position;
    private String bio;

    public Speaker(int selfie, String name, int appear, String position, String bio) {
        this.selfie = selfie;
        this.name = name;
        this.first = appear;
        this.position = position;
        this.bio = bio;
    }



    public Speaker(Parcel input) {
        selfie = input.readInt();
        name = input.readString();
        first = input.readInt();
        position = input.readString();
        bio = input.readString();
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
        dest.writeString(getPosition());
        dest.writeString(getBio());

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
