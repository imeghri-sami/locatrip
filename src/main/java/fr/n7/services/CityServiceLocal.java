package fr.n7.services;

import fr.n7.entities.City;

import javax.ejb.Local;

@Local
public interface CityServiceLocal extends IDAO<City, Integer>{
}
