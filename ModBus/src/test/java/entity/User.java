package entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "userr")
@NamedQueries({
        @NamedQuery(name="findAllUser",query="SELECT u FROM User u"),
        @NamedQuery(name="findUserWithId",query="SELECT u FROM User u WHERE u.id = ?1"),
        @NamedQuery(name="findUserWithName",query="SELECT u FROM User u WHERE u.name = :name")

})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    private int age;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, precision = 10, scale = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}