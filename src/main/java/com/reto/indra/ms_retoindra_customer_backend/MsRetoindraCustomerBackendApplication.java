package com.reto.indra.ms_retoindra_customer_backend;

import com.reto.indra.ms_retoindra_customer_backend.config.OpenApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(OpenApiConfig.class)
public class MsRetoindraCustomerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRetoindraCustomerBackendApplication.class, args);
	}

}
