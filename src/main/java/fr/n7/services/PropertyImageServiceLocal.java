package fr.n7.services;

import fr.n7.entities.PropertyImages;

import javax.ejb.Local;
import java.util.UUID;

@Local
public interface PropertyImageServiceLocal extends IDAO<PropertyImages, UUID> {


}
