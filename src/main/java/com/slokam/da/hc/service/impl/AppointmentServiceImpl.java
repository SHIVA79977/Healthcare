package com.slokam.da.hc.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.AppointmentDAO;
import com.slokam.da.hc.entity.Appointment;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IAppointmentService;
@Service
public class AppointmentServiceImpl implements IAppointmentService{
	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	@Autowired
	private AppointmentDAO appointDao;
	
	@Override
	public void createAppointment(Appointment appointment) throws PatientException {
		LOGGER.info("Entered into createAppointment");
		
				appointment.setTaken(new Date());
				LOGGER.info("Appointment Details::"+appointment);
				appointDao.save(appointment);
		
		LOGGER.info("Exit from createAppointment");
	}
	
}
