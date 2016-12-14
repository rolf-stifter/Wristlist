package be.pxl.elision.services;

import be.pxl.elision.models.Notification;
import be.pxl.elision.repositories.NotificationRepository;
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
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    NotificationRepository repository;

    public List<Notification> getAll(){
        return repository.findAll();
    }
    public Notification addNew(Notification notification){
        return repository.save(notification);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public List<Notification> getBetweenDates(Date start, Date end) {
        return repository.findByMeasuredBetween(start, end);
    }
    public Notification findLatest(){
        return repository.findTop1ByOrderByMeasuredDesc();
    }
}
