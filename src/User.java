public class User {
    private String UserId;
    private String password;
    private String name;

    public User() {
    }

    public User(String UserId, String password, String name) {
        this.UserId = UserId;
        this.password = password;
        this.name = name;
    }

    public String getUserId() {
        return UserId;
    }
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}