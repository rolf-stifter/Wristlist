package be.pxl.elision.repositories;
import be.pxl.elision.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    //Find all Notifications between 2 dates
    @Transactional(readOnly = true)
    List<Notification> findByMeasuredBetween(Date start, Date end);
    //Find Latest Notification
    @Transactional(readOnly = true)
    Notification findTop1ByOrderByMeasuredDesc();
}
