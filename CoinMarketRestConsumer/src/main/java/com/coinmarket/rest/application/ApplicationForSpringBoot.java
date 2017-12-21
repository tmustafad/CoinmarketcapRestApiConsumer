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

			log.info(">>>> " + coins);

			// VERGE
			Object[] vergeArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("verge")).toArray();
			log.info("Name :" + ((Coin) vergeArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()));
			log.info("Total Verge Holding : " + 1000 * Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()) + " USD");

			log.info("-------------------------------------------------");

			// DIGIBYTE
			Object[] digibyteArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("digibyte")).toArray();
			log.info("Name :" + ((Coin) digibyteArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()));

			log.info("Total Digibyte Holding : " + 500 * Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()) + " USD");

			log.info("-------------------------------------------------");

			// YOYOW
			// Object[] yoyowArray = Arrays.stream(coins).filter(x ->
			// x.getName().equalsIgnoreCase("yoyow"))
			// .toArray();
			// log.info("Name :" + ((Coin) yoyowArray[0]).getName());
			//
			// log.info(" Price USD :" + Double.valueOf(((Coin)
			// yoyowArray[0]).getPrice_usd()));
			//
			// log.info("-------------------------------------------------");

			// CARDANO
			Object[] cardanoArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("cardano")).toArray();
			log.info("Name :" + ((Coin) cardanoArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()));

			log.info("Total Cardano Holding : " + 944 * Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()) + " USD");

			log.info("-------------------------------------------------");

			// STREAMR
			Object[] streamRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("streamr DataCoin"))
					.toArray();
			log.info("Name :" + ((Coin) streamRArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) streamRArray[0]).getPrice_usd()));

			log.info("Total StreamR Holding : " + 957 * Double.valueOf(((Coin) streamRArray[0]).getPrice_usd()) + " USD");
			
			log.info("----------------------------------------------------");

			//BTC
			Object[] btcRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin"))
					.toArray();
			log.info("Name :" + ((Coin) btcRArray[0]).getName());

			log.info(" Price USD :" + Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()));

			log.info("Total BTC Holding : " + 0.0011 * Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()) + " USD");

			
			
			double totalHoldings = (957 * Double.valueOf(((Coin) streamRArray[0]).getPrice_usd()))
					+ (944 * Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()))
					+ (500 * Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()))
					+ (1000 * Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()))+
					(0.0011 * Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()));
			log.info("------------TOTAL PORTFOLIO VALUE ==>>   " + totalHoldings+" USD + 200 * YOYOW price");

		
		};
	}
	
	
}
