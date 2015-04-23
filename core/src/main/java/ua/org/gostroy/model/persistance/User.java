package ua.org.gostroy.model.persistance;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sergey on 3/29/2015.
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String email;
    private String password;
    private Set<Equipment> equipments = new HashSet<>(0);

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.ALL})
    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }
}
