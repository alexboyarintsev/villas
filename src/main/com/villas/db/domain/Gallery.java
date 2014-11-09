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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "villa_id")
    private Villa villa;

    @Column(name = "picture_name", nullable = false)
    private String pictureName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Villa getVilla() {
        return villa;
    }

    public void setVilla(Villa villa) {
        this.villa = villa;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

}
