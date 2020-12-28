package com.example.sweater.repo;

import com.example.sweater.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
}
