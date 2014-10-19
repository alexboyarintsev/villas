package main.com.villas.db.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Entity
@Table(name = "galleries")
public class Gallery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Id
    @Column(name="villa_id")
    private Long villaId;

    @Column(name = "picture_name", nullable = false)
    private String pictureName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVillaId() {
        return villaId;
    }

    public void setVillaId(Long villaId) {
        this.villaId = villaId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

}
