package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HolidayRepository extends JpaRepository<Holidays, Date> {

//    @Query("SELECT d from Holidays d WHERE d.leavedate > :currDate")
//    List<Holidays> searchHolidays(LocalDate currDate);
}
