package com.example.demo.Service;

import com.example.demo.Entity.Location;
import com.example.demo.Repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) { this.locationRepository = locationRepository; }

    public Location addLocation(Location location) throws Exception
    {
        System.out.println("Inside addLocation function");
        return locationRepository.save(location);
    }
}
