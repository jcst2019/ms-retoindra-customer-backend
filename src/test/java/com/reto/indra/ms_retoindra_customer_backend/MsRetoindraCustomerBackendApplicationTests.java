package com.reto.indra.ms_retoindra_customer_backend;

import com.reto.indra.ms_retoindra_customer_backend.controller.CustomerController;
import com.reto.indra.ms_retoindra_customer_backend.model.Customer;
import com.reto.indra.ms_retoindra_customer_backend.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class MsRetoindraCustomerBackendApplicationTests {
	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;

	private List<Customer> testCustomers;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		testCustomers = Arrays.asList(
				Customer.builder().id("1").uniqueCode("123456").name("Juan").lastName("Solar").dni("4302393").age(30).address("Calle Falsa 123").phoneNumber("123456789").email("juan.perez@example.com").build(),
				Customer.builder().id("2").uniqueCode("654321").name("María").lastName("García").dni("987654321").age(25).address("Avenida Siempreviva 742").phoneNumber("987654321").email("maria.garcia@example.com").build(),
				Customer.builder().id("3").uniqueCode("987654").name("Luis").lastName("Rodríguez").dni("987123456").age(40).address("Calle del Sol 456").phoneNumber("987123456").email("luis.rodriguez@example.com").build(),
				Customer.builder().id("4").uniqueCode("456789").name("Ana").lastName("López").dni("456789123").age(35).address("Calle Luna 789").phoneNumber("456789123").email("ana.lopez@example.com").build(),
				Customer.builder().id("5").uniqueCode("789456").name("Carlos").lastName("Martínez").dni("789456123").age(28).address("Plaza Mayor 101").phoneNumber("789456123").email("carlos.martinez@example.com").build()
		);
	}

	@Test
	void testCustomers() {
		when(customerService.listCustomers()).thenReturn(Flux.fromIterable(testCustomers));

		StepVerifier.create(customerController.customers().getBody())
				.expectNextSequence(testCustomers)
				.verifyComplete();
		//Validar que se llame exactamente una vez durante la prueba
		verify(customerService, times(1)).listCustomers();
	}

	@Test
	void testListCustomerById() {
		Customer testCustomer = testCustomers.get(0);
		when(customerService.listCustomerById(testCustomer.getId())).thenReturn(Mono.just(testCustomer));

		StepVerifier.create(customerController.listCustomers(testCustomer.getId()).getBody())
				.expectNext(testCustomer)
				.verifyComplete();

		verify(customerService, times(1)).listCustomerById(testCustomer.getId());
	}

	@Test
	void testFindByUniqueCode() {
		Customer testCustomer = testCustomers.get(0);
		String uniqueCode = testCustomer.getUniqueCode();
		when(customerService.listClientByUniqueCode(uniqueCode)).thenReturn(Mono.just(testCustomer));

		StepVerifier.create(customerController.findByUniqueCode(uniqueCode).getBody())
				.expectNext(testCustomer)
				.verifyComplete();

		verify(customerService, times(1)).listClientByUniqueCode(uniqueCode);
	}

	@Test
	void testCreateCustomer() {
		Customer testCustomer = testCustomers.get(0);
		when(customerService.createCustomer(testCustomer)).thenReturn(Mono.just(testCustomer));

		StepVerifier.create(customerController.createCustomer(testCustomer).getBody())
				.expectNext(testCustomer)
				.verifyComplete();

		verify(customerService, times(1)).createCustomer(testCustomer);
	}

}
