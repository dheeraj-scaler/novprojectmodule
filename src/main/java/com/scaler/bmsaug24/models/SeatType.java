package com.scaler.bmsaug24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeatType extends BaseModel {
    private String value;

    // have other seat information in this


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
