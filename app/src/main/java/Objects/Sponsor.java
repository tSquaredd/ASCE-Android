package Objects;

import android.os.Parcel;
import android.os.Parcelable;

import org.ascebuffalo.asce.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/11/21.
 */

public class Sponsor implements Parcelable {

    private int S_picture;
    private String S_name;
    private String S_level;

    public Sponsor(int pic, String name, String money) {
        this.S_picture = pic;
        this.S_name = name;
        this.S_level = money;

    }

    public Sponsor(Parcel in) {
        S_picture = in.readInt();
        S_name = in.readString();

        S_level = in.readString();
    }

    public static Creator<ScheduleEvent> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getS_picture());
        dest.writeString(getS_name());
        dest.writeString(getS_level());
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

    public int getS_picture() {
        return S_picture;
    }

    public void setS_picture(int s_picture) {
        S_picture = s_picture;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public String getS_level() {
        return S_level;
    }

    public void setS_level(String s_level) {
        S_level = s_level;
    }


    public static List<Sponsor> getData() {
        List<Sponsor> data = new ArrayList<>();
        data.add(new Sponsor(R.drawable.cha,
                "CHA Consulting, Inc.",
                "Gold Event Sponsor"));
        data.add(new Sponsor(R.drawable.rsz_11cpl,
                "Clark Patterson Lee",
                "Gold Event Sponsor"));
        data.add(new Sponsor(R.drawable.parsons,
                "Parsons Corporation",
                "Gold Event Sponsor"));
        data.add(new Sponsor(R.drawable.asce,
                "ASCE Region 1",
                "Silver Event Sponsor"));
        data.add(new Sponsor(R.drawable.foiutalbert,
                "Foit-Albert Associates",
                "Silver Event Sponsor"));
        data.add(new Sponsor(R.drawable.tc_geosynthetics,
                "TenCate Geosynthetics",
                "Silver Event Sponsor"));
        data.add(new Sponsor(R.drawable.watt,
                "Watts Architecture and Engineering",
                "Silver Event Sponsor"));
        data.add(new Sponsor(R.drawable.usi,
                "United Survey Inc.",
                "Silver Event Sponsor"));
        data.add(new Sponsor(R.drawable.b_l,
                "Barton & Loguidice",
                "Bronze Event Sponsor"));
        data.add(new Sponsor(R.drawable.ejp_logo,
                "Everett J. Prescott Inc.",
                "Bronze Event Sponsor"));
        data.add(new Sponsor(R.drawable.ub,
                "UB School of Engineering and Applied Sciences",
                "Bronze Event Sponsor"));
        return data;
    }
}

