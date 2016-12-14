package be.pxl.elision.services;

import be.pxl.elision.models.Location;
import be.pxl.elision.repositories.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Service
public class LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    LocationRepository repository;


    public List<Location> getAll(){
        return repository.findAll();
    }
    public Location addNew(Location location){
        return repository.save(location);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public List<Location> getBetweenDates(Date start, Date end) {
        return repository.findByMeasuredBetween(start, end);
    }
    public Location findLatest(){
        return repository.findTop1ByOrderByMeasuredDesc();
    }
}
