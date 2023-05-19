package com.example.activitiesmanagment.port.rest;

import com.example.activitiesmanagment.domain.models.Activity;
import com.example.activitiesmanagment.domain.models.ActivityId;
import com.example.activitiesmanagment.services.ActivityService;
import com.example.activitiesmanagment.services.forms.ActivityForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
@AllArgsConstructor
public class ActivityResource {

    private final ActivityService activityService;

    @GetMapping
    public List<Activity> findAll() {
        return activityService.findAll();
    }

    @PostMapping("/add")
    public Activity addActivity(@RequestBody ActivityForm activityForm) {
        return activityService.save(activityForm);
    }

    @PutMapping("/update/{id}")
    public Activity updateProduct(@PathVariable ActivityId id, @RequestBody ActivityForm activityForm) {
        return activityService.update(id, activityForm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable ActivityId id) {
        activityService.deleteById(id);
    }

}
