package be.pxl.elision.repositories;


import be.pxl.elision.models.UsedApi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Repository
public interface UsedApiRepository extends MongoRepository<UsedApi, String> {
    //Find all UsedApi between 2 dates
    @Transactional(readOnly = true)
    List<UsedApi> findByMeasuredBetween(Date start, Date end);
    //Find Latest UsedApi
    @Transactional(readOnly = true)
    UsedApi findTop1ByOrderByMeasuredDesc();
}
