package com.mercedes.benz.fuel.cost.producer.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercedes.benz.fuel.cost.producer.service.FuelCostProducerService;

@Controller
@RequestMapping(value = "/fuelCostProducer")
public class FuelCostProducerController {
	
	@Autowired
	FuelCostProducerService fuelCostProducerService;
	
	@PostMapping(value = "/produce")
	public String producer(@RequestBody JSONObject message) throws Exception{
		fuelCostProducerService.send(message.toJSONString());

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}
