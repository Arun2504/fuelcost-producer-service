package com.mercedes.benz.fuel.cost.producer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mercedes.benz.fuel.cost.producer.service.FuelCostProducerService;

@Service
public class FuelCostProducerServiceImpl implements FuelCostProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) throws Exception {
		
		
		
		String kafkaTopic = "fuelEvent";
		
		
		    
		    kafkaTemplate.send(kafkaTopic, message);
		
	}

}
