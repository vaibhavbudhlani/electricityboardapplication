package com.bcg.electricityboard;

import com.bcg.electricityboard.service.DataStore;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectricityboardApplication {
	@Autowired
	private DataStore dataStore;

	public static void main(String[] args) {
		SpringApplication.run(ElectricityboardApplication.class, args);
	}


	@PostConstruct
	public void loadJsonData() {
		dataStore.setRecords();
	}

}
