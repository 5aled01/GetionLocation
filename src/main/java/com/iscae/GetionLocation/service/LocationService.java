package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Location;
import com.iscae.GetionLocation.model.Vente;
import com.iscae.GetionLocation.repo.LocationRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationService {

    private final LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }


    public List<Location> findAllLocation(){
        return locationRepo.findAll();
    }

    public Optional<Location> findLocationById(long id){
        return  locationRepo.findById(id);
    }
    public void deleteLocation(Long id){
        locationRepo.deleteById(id);
    }

    public Location addLocation(Location location){
        return locationRepo.save(location);
    }


    public Location updateLocation(Location location){
        return locationRepo.save(location);
    }
}
