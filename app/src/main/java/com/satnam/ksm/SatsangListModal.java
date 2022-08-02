package com.satnam.ksm;

import java.util.Date;

public class SatsangListModal {
    private String time;
    private String place;
    private String organizer;
    private String kirtankar;
    private String date;

    public SatsangListModal(String date, String time, String place, String organizer, String kirtankar) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.organizer = organizer;
        this.kirtankar = kirtankar;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getKirtankar() {
        return kirtankar;
    }
}
