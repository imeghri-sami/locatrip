package fr.n7.services;

import fr.n7.entities.Country;

import javax.ejb.Local;

@Local
public interface CountryServiceLocal extends IDAO<Country, Integer> {
}
