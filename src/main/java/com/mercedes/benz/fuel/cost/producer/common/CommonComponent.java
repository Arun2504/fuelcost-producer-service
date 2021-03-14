package com.mercedes.benz.fuel.cost.producer.common;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mercedes.benz.fuel.cost.producer.service.FuelCostProducerService;

@Component
public class CommonComponent {
	
	@Autowired
	FuelCostProducerService fuelCostProducerService;

	
	@Scheduled(cron = "0 0/2 * * * ?")
	@SuppressWarnings("unchecked")
	public void produceKafkaMessage() throws Exception {

		JSONObject messageObject = new JSONObject();

		messageObject.put("fuelId", "false");
		messageObject.put("city", "Delhi");
		messageObject.put("fuelType", "Petrol");
		messageObject.put("fuelRequired", "10");
		
		fuelCostProducerService.send(messageObject.toJSONString());

	}

}
