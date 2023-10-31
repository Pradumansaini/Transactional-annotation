package com.springboot.flightserviceexample.service;

import com.springboot.flightserviceexample.dto.FlightBookingAcknowlegement;
import com.springboot.flightserviceexample.dto.FlightBookingRequest;
import com.springboot.flightserviceexample.entity.PassengerInfo;
import com.springboot.flightserviceexample.entity.PaymentInfo;
import com.springboot.flightserviceexample.repository.PassengerInfoRepository;
import com.springboot.flightserviceexample.repository.PaymentInfoRepository;
import com.springboot.flightserviceexample.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
@Autowired
    private PassengerInfoRepository passengerInfoRepository;
@Autowired
    private PaymentInfoRepository paymentInfoRepository;
@Transactional
    public FlightBookingAcknowlegement bookFlightTicket(FlightBookingRequest request) {


        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowlegement("SUCCES",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }
}
