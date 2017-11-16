package Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tylerturnbull on 11/15/17.
 */

public class ScheduleEvent implements Parcelable{

    private String title;
    private String startTime;
    private String endTime;
    private String location;

    public ScheduleEvent(String title, String startTime, String endTime, String location) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public ScheduleEvent(Parcel in){
        title = in.readString();
        startTime = in.readString();
        endTime = in.readString();
        location = in.readString();
    }


    public static final Creator<ScheduleEvent> CREATOR = new Creator<ScheduleEvent>() {
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
        dest.writeString(getTitle());
        dest.writeString(getStartTime());
        dest.writeString(getEndTime());
        dest.writeString(getLocation());
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
