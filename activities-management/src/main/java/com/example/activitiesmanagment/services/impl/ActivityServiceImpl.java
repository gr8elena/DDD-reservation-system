package com.example.activitiesmanagment.services.impl;

import com.example.activitiesmanagment.domain.models.Activity;
import com.example.activitiesmanagment.domain.models.ActivityId;
import com.example.activitiesmanagment.domain.repository.ActivityRepository;
import com.example.activitiesmanagment.services.ActivityService;
import com.example.activitiesmanagment.services.forms.ActivityForm;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;

    private final Validator validator;

    @Override
    public Activity findById(ActivityId id) {
        return activityRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity save(@NotNull ActivityForm activity){

        var violations = validator.validate(activity);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid activity data");
        }

        var newActivity = new Activity(activity.getAddress(), activity.getActivityType(), activity.getNumberOfPeople() ,activity.getPrice());

        return activityRepository.saveAndFlush(newActivity);
    }

    @Override
    public Activity update(@NonNull ActivityId id, @NonNull ActivityForm activity) {
        var activityToUpdate = findById(id);

        activityToUpdate.updateActivity(activity.getAddress(), activity.getActivityType(), activity.getNumberOfPeople(), activity.getPrice());

        return activityRepository.saveAndFlush(activityToUpdate);
    }

    @Override
    public void deleteById(ActivityId id) {
        activityRepository.deleteById(id);
        activityRepository.flush();
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
        activityRepository.flush();
    }
}