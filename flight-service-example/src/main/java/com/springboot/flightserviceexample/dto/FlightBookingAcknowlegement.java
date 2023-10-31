package com.springboot.flightserviceexample.dto;

import com.springboot.flightserviceexample.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowlegement {

    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;


}
