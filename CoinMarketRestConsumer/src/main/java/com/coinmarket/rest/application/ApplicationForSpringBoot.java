package com.coinmarket.rest.application;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.coinmarket.rest.domain.Coin;

@SpringBootApplication
public class ApplicationForSpringBoot {

	
	private static final Logger log=LoggerFactory.getLogger(ApplicationForSpringBoot.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationForSpringBoot.class);
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {

			 
			Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);


			// VERGE COIN
			Object[] vergeArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("verge")).toArray();
			log.info("Name :" + ((Coin) vergeArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()));

			log.info("-------------------------------------------------");

			// DIGIBYTE COIN
			Object[] digibyteArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("digibyte")).toArray();
			log.info("Name :" + ((Coin) digibyteArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()));


			log.info("-------------------------------------------------");

	

			// CARDANO COIN
			Object[] cardanoArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("cardano")).toArray();
			log.info("Name :" + ((Coin) cardanoArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()));

			

			log.info("-------------------------------------------------");

			// STREAMR COIN
			Object[] streamRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("streamr DataCoin"))
					.toArray();
			log.info("Name :" + ((Coin) streamRArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) streamRArray[0]).getPrice_usd()));

			
			log.info("----------------------------------------------------");

			//BTC COIN
			Object[] btcRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin"))
					.toArray();
			log.info("Name :" + ((Coin) btcRArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()));


			
	

		
		};
	}
	
	
}
