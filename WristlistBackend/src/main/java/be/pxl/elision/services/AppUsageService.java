package be.pxl.elision.services;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.repositories.AppUsageRepository;
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
public class AppUsageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUsageService.class);

    @Autowired
    private AppUsageRepository repository;

    public List<AppUsage> getAll(){
        return repository.findAll();
    }
    public AppUsage addNew(AppUsage appUsage){
        return repository.save(appUsage);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public List<AppUsage> getBetweenDates(Date start, Date end) {
        return repository.findByMeasuredBetween(start, end);
    }
    public AppUsage findLatest(){
        return repository.findTop1ByOrderByMeasuredDesc();
    }


}
