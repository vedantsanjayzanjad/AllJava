package com.task.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Holiday;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.HolidayRepo;
import com.task.service.HolidayService;

@Service
public class HolidayImpl implements HolidayService {

	@Autowired
	private HolidayRepo holidayRepo;

	@Override
	public Holiday createHoliday(Holiday holiday) throws Exception {
		
		System.out.println("Adding");
		LocalDate plusDays = holiday.getHolidayDate().plusDays(1);
		holiday.setHolidayDate(plusDays);
		System.out.println(holiday.getHolidayDate());
		Holiday save = this.holidayRepo.save(holiday);
		return holiday;
	}

	@Override
	public List<Holiday> getAllHoliday() {
		List<Holiday> findAll = this.holidayRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteHolidayById(int holidayId) {
		Holiday delete = this.holidayRepo.findById(holidayId)
				.orElseThrow(() -> new ResourceNotFoundException("Holiday", "HolidayID", holidayId));
		this.holidayRepo.delete(delete);
	}

	@Override
	public Holiday getOneHoliday(int holidayId) {
		Holiday holiday = this.holidayRepo.findById(holidayId)
				.orElseThrow(() -> new ResourceNotFoundException("Holiday", "HolidayID", holidayId));
		return holiday;
	}

	@Override
	public Holiday updateHoliday(int holidayId, Holiday holiday) {
		Holiday update = this.holidayRepo.findById(holidayId)
				.orElseThrow(() -> new ResourceNotFoundException("Holiday", "holidayId", holidayId));
		System.out.println(holiday.getHolidayDate());
//		System.out.println("Adding");
		LocalDate plusDays = holiday.getHolidayDate().plusDays(1);
//		System.out.println(plusDays);
		update.setHolidayDate(plusDays);	
//		update.setHolidayDate(holiday.getHolidayDate());
		update.setHolidayName(holiday.getHolidayName());
		Holiday save = this.holidayRepo.save(update);
		return save;
	}
}
