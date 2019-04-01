package com.example.VolunteerEventLog.data;

import com.example.VolunteerEventLog.models.Volunteer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VolunteerDao  extends CrudRepository<Volunteer, Integer> {
}
