package Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by john on 2017/11/21.
 */

public class Sponsor implements Parcelable{

    private String Sname;
    private String Spic;
    private String Smoney;

    public Sponsor(String name, String pic, String money) {
        this.Sname = name;
        this.Spic = pic;
        this.Smoney = money;

    }

    public Sponsor(Parcel in){
        Sname = in.readString();
        Spic = in.readString();
        Smoney = in.readString();
    }


    public static final Parcelable.Creator<ScheduleEvent> CREATOR = new Parcelable.Creator<ScheduleEvent>() {
        @Override
        public ScheduleEvent createFromParcel(Parcel in) {
            return new ScheduleEvent(in);
        }

        @Override
        public ScheduleEvent[] newArray(int size) {
            return new ScheduleEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getPic());
        dest.writeString(getMoney());
          }



    public String getName() {
        return Sname;
    }

    public void setName(String title) {
        Sname = title;
    }

    public String getPic() {
        return Spic;
    }

    public void setPic(String startTime) {
        Spic = startTime;
    }

    public String getMoney() {
        return Smoney;
    }

    public void setMoney(String endTime) {
        Smoney = endTime;
    }



}

