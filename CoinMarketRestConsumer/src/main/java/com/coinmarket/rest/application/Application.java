package com.coinmarket.rest.application;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.coinmarket.rest.domain.Coin;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);

		// IOTA
		Object[] iotaArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("iota")).toArray();
		log.info("Name :" + ((Coin) iotaArray[0]).getName());

		log.info(" Price USD :" + Double.valueOf(((Coin) iotaArray[0]).getPrice_usd()));

		log.info("-------------------------------------------------");

		// VERGE
		Object[] vergeArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("verge")).toArray();
		log.info("Name :" + ((Coin) vergeArray[0]).getName());

		log.info(" Price USD :" + Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()));

		log.info("-------------------------------------------------");

		// DIGIBYTE
		Object[] digibyteArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("digibyte")).toArray();
		log.info("Name :" + ((Coin) digibyteArray[0]).getName());

		log.info(" Price USD :" + Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()));

		log.info("-------------------------------------------------");

		// CARDANO
		Object[] cardanoArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("cardano")).toArray();
		log.info("Name :" + ((Coin) cardanoArray[0]).getName());

		log.info(" Price USD :" + Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()));

		log.info("-------------------------------------------------");


		// BTC
		Object[] btcRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin")).toArray();
		log.info("Name :" + ((Coin) btcRArray[0]).getName());

		log.info(" Price USD :" + Double.valueOf(((Coin) btcRArray[0]).getPrice_usd()));

	}

}
