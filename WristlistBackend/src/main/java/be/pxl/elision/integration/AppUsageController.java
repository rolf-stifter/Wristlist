package be.pxl.elision.integration;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.services.AppUsageService;
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
public class AppUsageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUsageController.class);

    @Autowired
    AppUsageService service;

    //ALL
    //OPTIONAL : BETWEEN DATES
    @RequestMapping(value= "/usage", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<AppUsage>> getAll(@RequestParam(name= "start",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
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
    @RequestMapping(value ="/usage/latest",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<AppUsage> getLatest() {
        return new ResponseEntity<>(service.findLatest(), HttpStatus.OK);
    }
    //POST ONE
    @RequestMapping(value= "/usage", method = RequestMethod.POST)
    public ResponseEntity<AppUsage> postNew(@RequestBody AppUsage appUsage) {
        return new ResponseEntity<>(service.addNew(appUsage), HttpStatus.CREATED);
    }



}
