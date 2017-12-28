package com.coinmarket.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coinmarket.rest.domain.Coin;
import com.coinmarket.rest.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Coin> getAllCoins() {

		return service.getAllCoins();
	}

}
