package Objects;

import android.os.Parcel;
import android.os.Parcelable;

import org.ascebuffalo.asce.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static List<Speaker> getData(){
        List<Speaker> data = new ArrayList<>();

        data.add(new Speaker(R.drawable.erymc,
                "Don Wittmer",
                0,
                "P.E., M.ASCE, Chair, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));


        data.add(new Speaker(R.drawable.erymc,
                "Tony Cioffi",
                0,
                "P.E., M.ASCE Region 1 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.jason_havens,
                "Jason Havens",
                0,
                "P.E., M.ASCE, Buffalo Section President",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Michael J. Finn",
                0,
                "P.E., City Engineer, City of Buffalo DPW",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Kristina Swallow",
                0,
                "P.E., ENV SP, F.ASCE, ASCE 2018 President",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.tom_smith,
                "Tom Smith",
                0,
                "ENV SP, CAE, F.ASCE, Executive Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));


        data.add(new Speaker(R.drawable.erymc,
                "Greg Kuklinski",
                0,
                "P.E., M.ASCE, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Shawn Kelley",
                0,
                "Ph.D., P.E., M.ASCE, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Nancy Berson",
                0,
                "Aff.M.ASCE, Director, Geographic Services",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Jennifer Lawrence",
                0,
                "Aff.M.ASCE, Senior Manager, Geographic Services",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Jesse Gormley",
                0,
                "P.E., ENV SP, M.ASCE, Committee on Younger Members",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "John Casana",
                0,
                "P.E., D.WRE, LEED AP, F.ASCE, Region 2 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.john_mcgrath,
                "John MCGrath",
                0,
                "MD, Interventional Radiologist, John R. Oishei Children’s Hospital and Gates Vascular Institute",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Chuck Black",
                0,
                "P.E., M.ASCE Region 4 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Peter Moore",
                0,
                "P.E., F.ASCE, Region 5 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Robin Kemper",
                0,
                "P.E., LEED AP, F.SEI, F.ASCE, 2018 ASCE President-elect",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.francis ,
                "Francis Mahaney",
                0,
                "E.I.T., A.M.ASCE, Buffalo Section President-elect",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Charlie Mumford",
                0,
                "Civil Engineer 1, AECOM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Maria Lehman",
                0,
                "P.E., F.ASCE, Director of Strategic Initiatives,Ecology &amp; Environment, Inc.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Raosanne Frandina",
                0,
                "P.E., L.S., Frandina Engineering And Land Surveying, P.C.Stacy M. Kubit, P.E., WSP",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Melissa Burns",
                0,
                "P.E., M.ASCE",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.kelly_dooley,
                "Kelly Dooley",
                0,
                "P.E., M.ASCE, Director, Raise the Bar",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.bethany_mazur,
                "Bethany Mazur",
                0,
                "J.D., Director of Alumni and Constituent Engagement -University at Buffalo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.jason_lang,
                "Jason Lang",
                0,
                "M.BA, CPA, Defense Contract Audit Agency",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.stacy_kubit,
                "Stacy M. Kubit",
                0,
                "P.E., WSP USA Inc.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat"));

        data.add(new Speaker(R.drawable.rsz_steve_ranalli,
                "Steven P.Ranalli",
                0,
                "P.E., Vice President of Waterfront Development, Empire State Development, Erie Canal Harbor Development Corporation",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat"));

        data.add(new Speaker(R.drawable.erymc,
                "Nicholas M. DeNichilo",
                0,
                "P.E., F.ASCE, President and CEO, Mott MacDonald North America",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat"));

        // header
        data.add(new Speaker(R.drawable.erymc,
                "Francis Mahaney",
                1,
                "E.I.T., A.M.ASCE, Buffalo Section President-elect",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Greg Kuklinski",
                1,
                "P.E., M.ASCE, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Jason Havens",
                1,
                "P.E., M.ASCE, Buffalo Section President",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.kristina_swallow,
                "Kristina Swallow",
                1,
                "P.E., ENV SP, F.ASCE, ASCE 2018 President",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Michael J. Finn",
                1,
                "P.E., City Engineer, City of Buffalo DPW",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Nancy Berson",
                1,
                "Aff.M.ASCE, Director, Geographic Services",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Peter Moore",
                1,
                "P.E., F.ASCE, Region 5 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.rosanne_frandina,
                "Robin Kemper",
                1,
                "P.E., LEED AP, F.SEI, F.ASCE, 2018 ASCE President-elect",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Shawn Kelley",
                1,
                "Ph.D., P.E., M.ASCE, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Tony Cioffi",
                1,
                "P.E., M.ASCE Region 1 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Don Wittmer",
                1,
                "P.E., M.ASCE, Chair, Leader Training Committee",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Bethany Mazur",
                1,
                "J.D., Director of Alumni and Constituent Engagement -University at Buffalo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));

        data.add(new Speaker(R.drawable.erymc,
                "Chuck Black",
                1,
                "P.E., M.ASCE Region 4 Director",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis est vitae erat laoreet consectetur. Mauris dui mauris, dictum vel egestas vel, porta sed ante. Phasellus congue viverra ipsum,"));
        Collections.sort(data, (o1, o2) -> {
            if (o1.getName().charAt(0) - o2.getName().charAt(0) == 0) {
                return o2.isFirst() - o1.isFirst();
            }
            return o1.getName().charAt(0) - o2.getName().charAt(0);
        });

        return data;
    }
}
