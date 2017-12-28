package com.coinmarket.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coinmarket.rest.domain.Coin;

@Service
public class AppServiceImpl implements AppService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Coin> getAllCoins() {
		Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);
		return Arrays.asList(coins);
	}
}
