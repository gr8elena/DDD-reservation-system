package com.example.activitiesmanagment.services;

import com.example.activitiesmanagment.domain.models.Activity;
import com.example.activitiesmanagment.domain.models.ActivityId;
import com.example.activitiesmanagment.services.forms.ActivityForm;

import java.util.List;

public interface ActivityService {

    Activity findById(ActivityId id);
    List<Activity> findAll();
    Activity save(ActivityForm activity);
    Activity update(ActivityId id, ActivityForm activity);
    void deleteById(ActivityId id);
    void delete(Activity activity);

}
