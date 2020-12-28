package com.example.railway.dataloader;

import java.util.Date;
import com.example.railway.model.Schedule;
import com.example.railway.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;


public class ScheduleDataLoader implements ApplicationRunner {

    private final ScheduleRepo scheduleRepo;

    @Autowired
    public ScheduleDataLoader(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        scheduleRepo.save(new Schedule(1L,"1",Date.parse("2020-10-01 00:00:00.000000"),"Station1",1L,1L));
    }
}
//        id	arrival	                station_name	train_number	station_id	train_id
//        1	2020-10-01 00:00:00.000000	Station1	1	1	1
//        2	2020-10-13 00:00:00.000000	Station1	5	1	5
//        3	2020-10-03 00:00:00.000000	Station1	2	1	2
//        4	2020-10-08 00:00:00.000000	Station1	3	1	3
//        5	2020-10-02 00:00:00.000000	Station2	1	2	1
//        6	2020-10-12 00:00:00.000000	Station2	5	2	5
//        7	2020-10-04 00:00:00.000000	Station2	2	2	2
//        8	2020-10-03 00:00:00.000000	Station2	4	2	4
//        9	2020-10-03 00:00:00.000000	Station3	1	3	1
//        10	2020-10-11 00:00:00.000000	Station3	5	3	5
//        11	2020-10-05 00:00:00.000000	Station3	2	3	2
//        12	2020-10-10 00:00:00.000000	Station3	3	3	3
//        13	2020-10-04 00:00:00.000000	Station4	1	4	1
//        14	2020-10-10 00:00:00.000000	Station4	5	4	5
//        15	2020-10-06 00:00:00.000000	Station4	2	4	2
//        16	2020-10-05 00:00:00.000000	Station5	1	5	1
//        17	2020-10-09 00:00:00.000000	Station5	5	5	5
//        18	2020-10-07 00:00:00.000000	Station5	2	5	2
//        19	2020-10-05 00:00:00.000000	Station5	4	5	4
//        20	2020-10-06 00:00:00.000000	Station6	1	6	1
//        21	2020-10-08 00:00:00.000000	Station6	5	6	5
//        22	2020-10-08 00:00:00.000000	Station6	2	6	2
//        23	2020-10-13 00:00:00.000000	Station6	3	6	3
//        24	2020-10-07 00:00:00.000000	Station7	1	7	1
//        25	2020-10-07 00:00:00.000000	Station7	5	7	5
//        26	2020-10-09 00:00:00.000000	Station7	2	7	2
//        27	2020-10-14 00:00:00.000000	Station7	3	7	3
//        28	2020-10-10 00:00:00.000000	Station7	4	7	4


