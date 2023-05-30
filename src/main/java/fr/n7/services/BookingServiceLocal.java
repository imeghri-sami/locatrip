package fr.n7.services;

import fr.n7.entities.Booking;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookingServiceLocal extends IDAO<Booking, Integer>{
    List<Booking> findByUeserId(int userId);
}
