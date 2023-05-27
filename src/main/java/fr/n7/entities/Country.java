package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Country {
    private Integer id;
    private String name;

    private List<City> cities;

}
