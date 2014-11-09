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

    @Column(name="villa_id")
    private Long villaId;

    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Column(name = "image", nullable=false, columnDefinition="mediumblob")
    private byte[] image;

    @Column(name = "thumb")
    private byte thumb;

    @Column(name = "cover")
    private byte cover;

    @Column(name = "extension")
    private String extension;

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte getCover() {
        return cover;
    }

    public void setCover(byte cover) {
        this.cover = cover;
    }

    public byte getThumb() {
        return thumb;
    }

    public void setThumb(byte thumb) {
        this.thumb = thumb;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
