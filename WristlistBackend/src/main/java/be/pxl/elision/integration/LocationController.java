package be.pxl.elision.integration;

import be.pxl.elision.models.Location;
import be.pxl.elision.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by 11308157 on 8/12/2016.
 */
@RestController
@RequestMapping("/location")
public class LocationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    LocationService service;

    //ALL
    //OPTIONAL : BETWEEN DATES
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Location>> getAll(@RequestParam(name= "start",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
                                                 @RequestParam(name = "end",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  Date end){
        if(start!=null && end!=null){
            return new ResponseEntity<>(service.getBetweenDates(start,end), HttpStatus.OK);
        }
        else if (start==null&&end==null){
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    //LATEST
    @RequestMapping(value ="/latest",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Location> getLatest() {
        return new ResponseEntity<>(service.findLatest(), HttpStatus.OK);
    }
    //POST ONE
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Location> postNew(@RequestBody Location location) {
        return new ResponseEntity<>(service.addNew(location), HttpStatus.CREATED);
    }
}
