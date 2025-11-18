package houduan.Object;

public class User {
    private String username;
    private String realName;
    private String password;
    private int age;

    public User(String username, String realName, String password,int age) {
        this.username = username;
        this.realName = realName;
        this.password=password;
        this.age = age;
    }

    // Getter + Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRealName() { return realName; }
    public void setRealName(String realName) { this.realName = realName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}