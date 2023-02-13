package com.slokam.da.hc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.da.hc.entity.Appointment;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IAppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping()
	public ResponseEntity<Appointment> createAppointment
	  (@RequestBody Appointment appointment) throws PatientException{
		LOGGER.info("Entered into createAppointment");
		 ResponseEntity<Appointment> re =null;
		if(appointment!=null){
			LOGGER.info("Appointment::"+appointment);
			appointmentService.createAppointment(appointment);
		    re = new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
		}else{
			re = new ResponseEntity<Appointment>(appointment,HttpStatus.BAD_REQUEST);
		}
			
		LOGGER.debug("Exit from createAppointment");
		return re;
	}
}
