package bg.softuni.Pathfinder.model.view;

public class UserProfileView {

    private String fullName;
    private String username;
    private Integer age;
    private String level;

    public UserProfileView(String fullName, String username, Integer age, String level) {
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileView setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileView setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public UserProfileView setLevel(String level) {
        this.level = level;
        return this;
    }
}
