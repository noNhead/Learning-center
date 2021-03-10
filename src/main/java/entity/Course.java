package entity;

import java.util.Map;

public class Course {
    private String title;
    private Map<String, Integer> themes;

    public Course(String title, Map<String, Integer> themes) {
        this.title = title;
        this.themes = themes;
    }

    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Integer> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, Integer> themes) {
        this.themes = themes;
    }

    public void addTheme(String string, Integer duration) {
        this.themes.put(string, duration);
    }

    public long getSummaryCourseTime() {
        long summaryDuration = 0;
        for (long duration: themes.values()) {
            summaryDuration+=duration;
        }
        return summaryDuration;
    }
}
