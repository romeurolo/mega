package org.academiadecodigo.mega.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.academiadecodigo.mega.persistence.model.Location;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewDto {
    private Integer id;
    private Location location;
    private String name;
    private Boolean type;
    private Integer evaluation;
    private String coment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "name:" + name +
                "tipe (true-good, false-bad)" + type +
                "evaluation" + evaluation +
                "text" + coment +
                ", location" + (location != null ? location.getId() : null) +
                "} " + super.toString();
    }
}
