package com.example.VolunteerEventLog.data;

import com.example.VolunteerEventLog.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventDao extends CrudRepository<Event, Integer> {
}
