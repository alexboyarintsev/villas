package main.com.villas.db.dto;

import main.com.villas.db.domain.Villa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by aboyarintsev on 09.11.2014.
 */
public class VillaDto  implements Serializable {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> images;

    public VillaDto(Villa v, List<String> images) {
        id = v.getId();
        name = v.getName();
        description = v.getDescription();
        price = v.getPrice();
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
