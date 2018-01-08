package Objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by tylerturnbull on 11/15/17.
 */

public class ScheduleEvent implements Parcelable{

    private String title;
    private String startTime;
    private String endTime;
    private String location;
    private String[] presenters;
    private String[] moderators;
    private String[] leaders;
    private String[] panelists;
    private String sections;
    private String description;


    public ScheduleEvent(String title, String startTime, String endTime, String location,
                         String[] presenters, String[] moderators,
                         String[] leaders, String[] panelists, String sections, String description) {

        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.presenters = presenters;
        this.moderators = moderators;
        this.leaders = leaders;
        this.panelists = panelists;
        this.sections = sections;
        this.description = description;
    }

    public ScheduleEvent(Parcel in){
        title = in.readString();
        startTime = in.readString();
        endTime = in.readString();
        location = in.readString();
        presenters = in.createStringArray();
        moderators = in.createStringArray();
        leaders = in.createStringArray();
        panelists = in.createStringArray();
        sections = in.readString();
        description = in.readString();
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
        dest.writeStringArray(getPresenters());
        dest.writeStringArray(getModerators());
        dest.writeStringArray(getLeaders());
        dest.writeStringArray(getPanelists());
        dest.writeString(getSections());
        dest.writeString(getDescription());
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

    public String[] getPresenters() {
        return presenters;
    }

    public void setPresenters(String[] presenters) {
        this.presenters = presenters;
    }

    public String[] getModerators() {
        return moderators;
    }

    public void setModerators(String[] moderators) {
        this.moderators = moderators;
    }

    public String[] getLeaders() {
        return leaders;
    }

    public void setLeaders(String[] leaders) {
        this.leaders = leaders;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getPanelists() {
        return panelists;
    }

    public void setPanelists(String[] panelists) {
        this.panelists = panelists;
    }

    public String getTimeInterval(){
        return startTime + " - " + endTime;
    }
}
