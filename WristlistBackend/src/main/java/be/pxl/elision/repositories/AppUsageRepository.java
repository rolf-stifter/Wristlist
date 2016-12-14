package be.pxl.elision.repositories;

import be.pxl.elision.models.AppUsage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Repository
public interface AppUsageRepository extends MongoRepository<AppUsage, String> {
    //Find all AppUsages between 2 dates
    @Transactional(readOnly = true)
    List<AppUsage> findByMeasuredBetween(Date start, Date end);
    //Find Latest AppUsage
    @Transactional(readOnly = true)
    AppUsage findTop1ByOrderByMeasuredDesc();
}
