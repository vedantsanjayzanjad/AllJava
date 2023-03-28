package com.task.serviceimpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Holiday;
import com.task.entities.Task;
import com.task.entities.User;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.HolidayRepo;
import com.task.repository.TaskRepo;
import com.task.service.TaskService;

@Service
public class TaskImpl implements TaskService {

	@Autowired
	private TaskRepo taskRepo;

	@Autowired
	private HolidayRepo holidayRepo;

	@Override
	public Task createTask(Task task) throws Exception {

		List<Holiday> holidayDetailsList = holidayRepo.findAll();
		LocalDate startDate = task.getStartDate().plusDays(1);
		int days = task.getDays();
		LocalDate endDate = task.getStartDate();
		
		for(int i=0;i<days;i++)
		{
			endDate = endDate.plus(1,ChronoUnit.DAYS);
			if(endDate.getDayOfWeek()==DayOfWeek.SATURDAY||endDate.getDayOfWeek()==DayOfWeek.SUNDAY||
			checkholiday(holidayDetailsList, endDate))
			{
				days++;
			}
		}
		task.setEndDate(endDate);
		task.setStartDate(startDate);
		System.out.println(startDate + "::Start Date");
		System.out.println(endDate + "::End Date");
		Task save = this.taskRepo.save(task);
		return save;
	}
	
	public boolean checkholiday(List<Holiday> holidayDetailsList,LocalDate endDate)
	{
		for(Holiday holiday:holidayDetailsList)
		{
			if(holiday.getHolidayDate().isEqual(endDate))
			{
			return true;
			}
		}
		return false;
	}
	
	@Override
	public List<Task> getAllTask() {
		List<Task> findAll = this.taskRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteTaskById(int taskId) {
		Task delete = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
		this.taskRepo.delete(delete);
	}

	@Override
	public Task getOneTask(int taskId) {
		Task task = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
		return task;
	}

	@Override
	public Task updateTask(int taskId, Task task) {
		Task updateTask = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task", "TaskId", taskId));
		List<Holiday> holidayDetailsList = holidayRepo.findAll();
		LocalDate startDate = task.getStartDate().plusDays(1);
		System.out.println(startDate);
		System.out.println(startDate.plusDays(1));
		int days = task.getDays();
		System.out.println(days);
		LocalDate endDate = task.getStartDate();
		System.out.println(endDate);
		
		
		for(int i=0;i<days;i++)
		{
			endDate = endDate.plus(1,ChronoUnit.DAYS);
			if(endDate.getDayOfWeek()==DayOfWeek.SATURDAY||endDate.getDayOfWeek()==DayOfWeek.SUNDAY||
			checkholiday(holidayDetailsList, endDate))
			{
				days++;
			}
		}
		
		updateTask.setStartDate(startDate);
		updateTask.setDays(task.getDays());
		System.out.println(task.getDays());
		updateTask.setEndDate(endDate);
		System.out.println(startDate + "::Start Date");
		System.out.println(endDate + "::End Date");
		updateTask.setTaskDescription(task.getTaskDescription());
		Task save = this.taskRepo.save(updateTask);
		return save;
	}

	@Override
	public List<Task> getByUser(int id) {
		List<Task> findByUserId = this.taskRepo.findByUserId(id);
		return findByUserId;
	}

}

//
//		for (LocalDate d : collect) {
//			if (startDate.isEqual(d)) {
//				days++;
//				System.out.println(days);
//				break;
//			} 
//			
//			else if (d.isAfter(startDate) && d.isEqual(endDate)) {
//				days=+2;
//				System.out.println(days);
//				continue;
//			}
//			else if (d.isAfter(startDate) || d.isEqual(endDate)) {
//				days++;
//				System.out.println(days);
//				break;
//			}