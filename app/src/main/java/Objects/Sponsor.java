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
    private int is_header;



    public Sponsor(int pic, String name, String money, int is_header) {
        this.S_picture = pic;
        this.S_name = name;
        this.S_level = money;
        this.is_header = is_header;

    }

    public Sponsor(Parcel in) {
        S_picture = in.readInt();
        S_name = in.readString();
        S_level = in.readString();
        is_header = in.readInt();
    }

    public static Creator<ScheduleEvent> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getS_picture());
        dest.writeString(getS_name());
        dest.writeString(getS_level());
        dest.writeInt(getIs_header());
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

    public int getIs_header() {
        return is_header;
    }

    public void setIs_header(int is_header) {
        this.is_header = is_header;
    }

    public static List<Sponsor> getData() {
        List<Sponsor> data = new ArrayList<>();
        data.add(new Sponsor(R.drawable.cha,
                "CHA Consulting, Inc.",
                "Gold Event Sponsor",
                1));
        data.add(new Sponsor(R.drawable.cha,
                "CHA Consulting, Inc.",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.rsz_11cpl,
                "Clark Patterson Lee",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.gpi,
                "Greenman-Pedersen, Inc.",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.mm,
                "Mott MacDonald",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.parsons,
                "Parsons Corporation",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.union,
                "Union Concrete & Construction Corporation",
                "Gold Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.asce,
                "ASCE Region 1",
                "Silver Event Sponsor",
                1));
        data.add(new Sponsor(R.drawable.asce,
                "ASCE Region 1",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.foiutalbert,
                "Foit-Albert Associates",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.tc_geosynthetics,
                "TenCate Geosynthetics",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.watt,
                "Watts Architecture and Engineering",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.usi,
                "United Survey Inc.",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.pdg,
                "Popli Design Group",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.wsp,
                "WSP Global",
                "Silver Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.b_l,
                "Barton & Loguidice",
                "Bronze Event Sponsor",
                1));
        data.add(new Sponsor(R.drawable.b_l,
                "Barton & Loguidice",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.ejp_logo,
                "Everett J. Prescott Inc.",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.cybex,
                "CYBEX U.S. CORP.",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.frandina,
                "Frandina Engineering and Land Surveying, PC",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.labella,
                "LaBella Associates",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.liberty_mutual,
                "Liberty Mutual",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.mcmahon,
                "McMahon & Mann Consulting Engineers, P.C.",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.region_4,
                "ASCE Region 4",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.region_5,
                "ASCE Region 5",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.wc,
                "WENDT CORPORATION",
                "Bronze Event Sponsor",
                0));
        data.add(new Sponsor(R.drawable.ub,
                "UB School of Engineering and Applied Sciences",
                "Bronze Event Sponsor",
                0));
        return data;
    }
}

