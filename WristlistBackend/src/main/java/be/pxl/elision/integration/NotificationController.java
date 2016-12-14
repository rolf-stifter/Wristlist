package be.pxl.elision.integration;

import be.pxl.elision.models.Notification;
import be.pxl.elision.services.NotificationService;
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
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService service;

    //ALL
    //OPTIONAL : BETWEEN DATES
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Notification>> getAll(@RequestParam(name= "start",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
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
    public ResponseEntity<Notification> getLatest() {
        return new ResponseEntity<>(service.findLatest(), HttpStatus.OK);
    }
    //POST ONE
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Notification> postNew(@RequestBody Notification notification) {
        return new ResponseEntity<>(service.addNew(notification), HttpStatus.CREATED);
    }
}
