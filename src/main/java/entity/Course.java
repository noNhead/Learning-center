package entity;

import java.util.Map;

public class Course {
    private String title;
    private Map<String, Integer> themes;

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
}
