import jakarta.persistence.*;

@Entity
@Table(name = "DBUSER") //WATCH out  USER is a reserved name!
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "navn")
    private String username;

    // TODO: Remember Getters and setters as well

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}