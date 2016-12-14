package be.pxl.elision.services;

import be.pxl.elision.models.UsedApi;
import be.pxl.elision.repositories.UsedApiRepository;
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
public class UsedApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsedApiService.class);

    @Autowired
    UsedApiRepository repository;

    public List<UsedApi> getAll(){
        return repository.findAll();
    }
    public UsedApi addNew(UsedApi usedApi){
        return repository.save(usedApi);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public List<UsedApi> getBetweenDates(Date start, Date end) {
        return repository.findByMeasuredBetween(start, end);
    }
    public UsedApi findLatest(){
        return repository.findTop1ByOrderByMeasuredDesc();
    }
}
