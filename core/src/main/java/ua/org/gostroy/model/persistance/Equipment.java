package ua.org.gostroy.model.persistance;

import javax.persistence.*;

/**
 * Created by Sergey on 4/19/2015.
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "equipments")
public class Equipment extends BaseEntity {

    private String name;
    private String description;
    private byte[] image;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "FRK_USER", referencedColumnName = "ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
