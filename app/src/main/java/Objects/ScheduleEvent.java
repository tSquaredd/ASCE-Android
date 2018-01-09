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

    public static ArrayList<ScheduleEvent> fridayScheduleData(){
        String[] presenterList;
        String[] moderatorList;
        String[] leaderList;


        ArrayList<ScheduleEvent> list = new ArrayList<>(15);
        ScheduleEvent event = new ScheduleEvent("Registration / Continental Breakfast",
                "7:00", "7:45",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Don Wittmer";

        presenterList = new String[5];
        presenterList[0] = "Tony Cioffi";
        presenterList[1] = "Jason Havens";
        presenterList[2] = "Michael J. Finn";
        presenterList[3] = "Kristina Swallow";
        presenterList[4] = "Tom Smith";


        event = new ScheduleEvent("Welcome",
                "7:45", "8:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC",
                null);

        list.add(event);

        moderatorList = new String[2];
        moderatorList[0] = "Greg Kuklinksi";
        moderatorList[1] = "Shawn Kelley";

        presenterList = new String[2];
        presenterList[0] = "Nancy Berson";
        presenterList[1] = "Jennifer Lawrence";

        event = new ScheduleEvent("ASCE Live",
                "8:15", "9:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC",
                "Learn about the ins and outs of ASCE including the organization, structure, " +
                        "and internal workings."
        );

        list.add(event);

        event = new ScheduleEvent("Break",
                "9:15", "9:30",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null
        );

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Jesse Gormley";

        event = new ScheduleEvent("Flipping the Script on Networking",
                "9:30", "10:30",
                "ROOM**",
                presenterList,
                null,
                null,
                null,
                "ERYMC / WSCL",
                null);

        list.add(event);

        leaderList = new String[4];
        leaderList[0] = "Tony Cioffi (ROOM**)";
        leaderList[1] = "John Casana (ROOM**)";
        leaderList[2] = "Chuck Black (ROOM**)";
        leaderList[3] = "Peter Moore (ROOM**)";

        event = new ScheduleEvent("Region Breakout Session",
                "10:30", "12:00",
                "Depends on Section",
                null,
                null,
                leaderList,
                null,
                "WSBL / ERYMC / WSCL",
                "Join others from your region and learn new names and faces; " +
                        "acquire new skills with a fun filled icebreaker.\n" +
                        "Region leaders meet with their respective section / branch leaders, Younger member leaders " +
                        "and Student chapter leaders."
        );

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Peter Moore";

        event = new ScheduleEvent("Networking Lunch",
                "12:00", "12:40",
                "Grand B-G",
                null,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Robin Kemper";

        event = new ScheduleEvent("Society Speaker",
                "12:40", "12:55",
                "Grand B-G",
                presenterList,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Jesse Gormley";

        event = new ScheduleEvent("CYM Town Hall and Rountables",
                "1:15", "2:45",
                "Grand B-G",
                presenterList,
                null,
                null,
                null,
                "ERYMC",
                "Roundtable topics include: Fundraising, Government Affairs, Professional Development, " +
                        "University Outreach and Job Fair, K-12 and Community Outreach, Social Media and Marketing, " +
                        "Social and Networking Events, Increasing Membership, and Board Recruitment and Retention");

        list.add(event);

        event = new ScheduleEvent("ERYMC Group Photo",
                "2:30", "2:45",
                "Announcement made prior on location",
                null,
                null,
                null,
                null,
                null,
                null);

        list.add(event);

        event = new ScheduleEvent("Networking Break",
                "2:45", "3:00",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "John Casana";

        leaderList = new String[3];
        leaderList[0] = "Kristina Swallow";
        leaderList[1] = "Robin Kemper";
        leaderList[2] = "Tom Smith";

        event = new ScheduleEvent("Society Leaders Q&A",
                "3:05", "4:00",
                "Regency Ballroom",
                null,
                moderatorList,
                leaderList,
                null,
                "WSBL / ERYMC",
                null);

        list.add(event);

        presenterList = new String[2];
        presenterList[0] = "Nancy Berson";
        presenterList[1] = "Shawn Kelley";

        event = new ScheduleEvent("\"The ASCE Adventure\" Awards Presentation",
                "4:00", "4:15",
                "Regency Ballroom",
                presenterList,
                null,
                null,
                null,
                "WSBL / ERYMC",
                null);

        moderatorList = new String[1];
        moderatorList[0] = "Francis Mahaney";

        presenterList = new String[1];
        presenterList[0] = "Charlie Mumford";

        event = new ScheduleEvent("How to execute a successful ASCE K-12 Outreach Event from start to finish",
                "4:15", "5:15",
                "ROOM**",
                presenterList,
                moderatorList,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Joint Social",
                "6:00", "7:00",
                "Pearl Street Grill",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Ticketed event. Appetizers and drink tickets provided. Location accesible by public tranist and/or walking.");

        list.add(event);

        return list;
    }

    public static ArrayList<ScheduleEvent> saturdayEventSchedule() {
        String[] presenterList;
        String[] moderatorList;
        String[] leaderList;


        ArrayList<ScheduleEvent> list = new ArrayList<>(11);
        ScheduleEvent event = new ScheduleEvent("Networking Breakfast",
                "7:30", "8:00",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Meet new friends and learn their stories; Swap buisness cards; learn what " +
                        "classes students enjoy and why they want to be Civil Engineers");

        list.add(event);

        event = new ScheduleEvent("Coffee with the 2019 President-Elect Nominees",
                "8:00", "8:30",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Chuck Black";

        presenterList = new String[1];
        presenterList[0] = "Maria Lehman";

        event = new ScheduleEvent("Managing the Disruption of the Civil Engineering Profession",
                "8:30", "9:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Jason Havens";

        presenterList = new String[2];
        presenterList[0] = "Raosanne Frandina";
        presenterList[1] = "Stacy M. Kubit";

        event = new ScheduleEvent("The good, the bad, and where we should take MWBE policy",
                "9:20", "10:15",
                "Grand E-G",
                presenterList,
                moderatorList,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Networking Break",
                "10:15", "10:30",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        presenterList = new String[1];
        presenterList[0] = "Melissa Burns";

        event = new ScheduleEvent("Business Meeting",
                "10:30", "12:10",
                "Grand E-G",
                presenterList,
                null,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Leadership Lunch",
                "12:15", "12:35",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Enjoy lunch with new friends and sicuss the events of the weekend; Share new ideas and actions you learned from the weekend sessions");

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Don Wittmer";

        presenterList = new String[1];
        presenterList[0] = "Nicholas M. DeNichilo";

        event = new ScheduleEvent("ASCE Industry Leaders Council Keynote: \"XXXXX\"",
                "12:35", "1:25",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Learn from those who have made leading others a career goal and found success"
        );

        list.add(event);

        moderatorList = new String[2];
        moderatorList[0] = "Jason Havens";
        moderatorList[1] = "Francis Mahaney";

        presenterList = new String[2];
        presenterList[0] = "Kelly Dooley";
        presenterList[1] = "Jason Lang";

        event = new ScheduleEvent("Should we Raise the Bar?",
                "1:30", "2:30",
                "Grand B-G",
                null,
                moderatorList,
                null,
                presenterList,
                "ERYMC",
                null);

        list.add(event);

        return list;

    }
}
