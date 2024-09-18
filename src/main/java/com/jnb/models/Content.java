package com.jnb.models;

import java.util.Calendar;

public class Content {
    protected int cod;
    protected String name;
    protected int group; // Season, Volume, Saga, etc
    protected int unit; // Episode, Chapter, etc
    protected String platform; // Crunchyroll, Netflix, etc
    protected Calendar releaseDay;
    protected boolean releasing;
    protected int personalStatus; // 0- Plan to watch, 1- Watching, 2- Watched, 3- Dropped
    protected int category; // 0- Series, 1- Anime, 2- Movie, 3- Book

//  CONSTRUCTORS    (I. General - II. Movies - III. Less specification(Plan to watch) - IV. Not specified)
    public Content(String name, int group, int unit, String platform, Calendar releaseDay, boolean releasing, int personalStatus, int category) {
        this.name = name;
        this.group = group;
        this.unit = unit;
        this.platform = platform;
        this.releaseDay = releaseDay;
        this.releasing = releasing;
        this.personalStatus = personalStatus;
        this.category = category;
    }
    public Content(String name, String platform, boolean releasing, int personalStatus, int category) {
        this.name = name;
        this.platform = platform;
        this.releasing = releasing;
        this.personalStatus = personalStatus;
        this.category = category;
    }
    public Content(String name, String platform, int category) {
        this.name = name;
        this.platform = platform;
        this.category = category;
    }
    public Content() {
    }

//  OPERATIONAL CLASS FUNCTIONS
    public void start(){
        this.setPersonalStatus(1);
        this.setGroup(1);
        this.setUnit(1);
    }
    public void stop(){
        this.setPersonalStatus(3);
    }
    public void finish(){
        this.setPersonalStatus(2);
        this.setReleasing(false);
    }

//  STRING FORMAT CLASS FUNCTIONS
    public String stringCalendar(Calendar weekNumber){
        String weekDay;
        int x = weekNumber.get(Calendar.DAY_OF_WEEK);
        weekDay = switch (x) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "No one selected";
        };

        return weekDay;
    }
    public String stringPersonalStatus(int personalStatus) {
        String pStatus;

        return pStatus = switch (personalStatus) {
            case 0 -> "Plan to Watch";
            case 1 -> "Watching";
            case 2 -> "Watched";
            case 3 -> "Dropped";
            default -> "Not added";
        };
    }
    public String stringCategory(int category) {
        String cat;

        return cat = switch (category) {
            case 0 -> "Series";
            case 1 -> "Anime";
            case 2 -> "Movie";
            case 3 -> "Book";
            default -> "Not added";
        };
    }

//  GETTERS AND SETTERS

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }

    public int getUnit() {
        return unit;
    }
    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Calendar getReleaseDay() {
        return releaseDay;
    }
    public void setReleaseDay(int releaseDay) {
        Calendar weekNumber = Calendar.getInstance();
        weekNumber.set(Calendar.DAY_OF_WEEK, releaseDay);
        this.releaseDay = weekNumber;
    }

    public boolean isReleasing() {
        return releasing;
    }
    public void setReleasing(boolean releasing) {
        this.releasing = releasing;
    }

    public int getPersonalStatus() {
        return personalStatus;
    }
    public void setPersonalStatus(int personalStatus) {
        this.personalStatus = personalStatus;
    }

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Content{" +
                "cod=" + cod +
                ", name='" + name + '\'' +
                ", season=" + group +
                ", episode=" + unit +
                ", platform='" + platform + '\'' +
                ", releaseDay=" + this.stringCalendar(releaseDay) +
                ", releasing=" + releasing +
                ", personalStatus=" + this.stringPersonalStatus(personalStatus) +
                ", category=" + this.stringCategory(category) +
                '}';
    }
}