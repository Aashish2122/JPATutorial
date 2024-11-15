package com.example.JPATutorial.JPATuts;

import com.example.JPATutorial.JPATuts.entities.ProductEntity;
import com.example.JPATutorial.JPATuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle123")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity saved = productRepository.save(productEntity);
		System.out.println(saved);
	}

	@Test
	void getRepository(){
		List<ProductEntity> li = productRepository.findAll();
		System.out.println(li);
	}

	@Test
	void getByTile(){
		//List<ProductEntity> li = productRepository.findByTitle("pepsi");
		//System.out.println(li);
	}

	@Test
	void findByAfter(){
		List<ProductEntity> li = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2023,1,1,0,0,0));
		System.out.println(li);
	}

//	@Test
//	void findByPriceAndTitle(){
//		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice
//				("pepsi", BigDecimal.valueOf(14.4));
//
//		productEntity.ifPresent(System.out::println);
//	}


}
