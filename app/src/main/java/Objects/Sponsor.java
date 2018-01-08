package Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by john on 2017/11/21.
 */

public class Sponsor implements Parcelable{

    private String Sname;
    private int Spic;
    private String Smoney;
    private String Sdes;
    public Sponsor(String name, int pic, String money,String des) {
        this.Sname = name;
        this.Spic = pic;
        this.Smoney = money;
        this.Sdes = des;

    }

    public Sponsor(Parcel in){
        Sname = in.readString();
        Spic = in.readInt();
        Smoney = in.readString();
        Sdes = in.readString();
    }


    public static final Parcelable.Creator<Sponsor> CREATOR = new Creator<Sponsor>() {
        @Override
        public Sponsor createFromParcel(Parcel in) {
            return new Sponsor(in);
        }

        @Override
        public Sponsor[] newArray(int size) {
            return new Sponsor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getPic());
        dest.writeString(getMoney());
        dest.writeString(getdes());
          }



    public String getName() {
        return Sname;
    }

    public void setName(String title) {
        Sname = title;
    }

    public int getPic() {
        return Spic;
    }

    public void setPic(int startTime) {
        Spic = startTime;
    }

    public String getMoney() {
        return Smoney;
    }

    public void setMoney(String endTime) {
        Smoney = endTime;
    }

    public void  setdes(String des){Sdes=des;}

    public String getdes(){return Sdes;}

}

