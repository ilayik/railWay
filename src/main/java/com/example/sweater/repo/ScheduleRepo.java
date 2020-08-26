package com.example.sweater.repo;

import com.example.sweater.modul.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Integer> {
}
