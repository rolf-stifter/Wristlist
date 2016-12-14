package be.pxl.elision.repositories;

import be.pxl.elision.models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Repository
public interface LocationRepository extends MongoRepository<Location,String> {
    //Find all Locations between 2 dates
    @Transactional(readOnly = true)
    List<Location> findByMeasuredBetween(Date start, Date end);
    //Find Latest Location
    @Transactional(readOnly = true)
    Location findTop1ByOrderByMeasuredDesc();
}
