package com.springboot.flightserviceexample;

import com.springboot.flightserviceexample.dto.FlightBookingAcknowlegement;
import com.springboot.flightserviceexample.dto.FlightBookingRequest;
import com.springboot.flightserviceexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {
	@Autowired
	private FlightBookingService service;
@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowlegement bookFlightTicket(@RequestBody FlightBookingRequest request){
     return service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}
