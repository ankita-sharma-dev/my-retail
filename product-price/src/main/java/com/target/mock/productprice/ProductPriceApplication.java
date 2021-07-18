package com.target.mock.productprice;

import com.target.mock.productinfo.data.ProductPrice;
import com.target.mock.productprice.data.MonetaryAmount;
import com.target.mock.productprice.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@EnableMongoRepositories
public class ProductPriceApplication implements CommandLineRunner {
	@Autowired
	ProductPriceRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(ProductPriceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save product prices
		repository.save(new ProductPrice(13860428, new MonetaryAmount("USD", BigDecimal.ONE)));
		repository.save(new ProductPrice(13860429, new MonetaryAmount("USD", BigDecimal.ONE)));
		repository.save(new ProductPrice(13860430, new MonetaryAmount("USD", BigDecimal.ONE)));
		repository.save(new ProductPrice(13860431, new MonetaryAmount("USD", BigDecimal.ONE)));



	}

}
