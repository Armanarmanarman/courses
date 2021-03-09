
package model;

public class Courses {
    private int id;
    private String title;
    private String description;
    private String discipline;

    public Courses(int id, String title, String description, String discipline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.discipline = discipline;
    }

    public Courses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Course " +
                "id: " + id +
                ", title: '" + title + '\'' +
                ", description='" + description + '\'' +
                ", '" + discipline + "' discipline"
                ;
    }
}
