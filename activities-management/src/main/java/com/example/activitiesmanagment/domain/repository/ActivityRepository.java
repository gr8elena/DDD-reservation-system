package com.example.activitiesmanagment.domain.repository;

import com.example.activitiesmanagment.domain.models.Activity;
import com.example.activitiesmanagment.domain.models.ActivityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, ActivityId> {
    Optional<Activity> findById(ActivityId id);
}
