package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.Holidays;
import com.terzoOne.terzoOneBackend.repository.HolidayRepository;
import com.terzoOne.terzoOneBackend.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;
    @Override
    public List<Holidays> getHolidays() {
        List<Holidays> holidays=holidayRepository.findAll();
        List<Holidays> holidaysList=new ArrayList<>();
        int count=0;
        for (Holidays holiday : holidays) {
            if(holiday.getLeavedate().isAfter(LocalDate.now())&&count<5){
                holidaysList.add(holiday);
                count++;
            }
        }
        return holidaysList;
    }
}
