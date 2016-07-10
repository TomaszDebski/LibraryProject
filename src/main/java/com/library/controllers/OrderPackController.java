package com.library.controllers;

import java.util.List;

import com.library.entities.OrderPack;
import com.library.services.OrderPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomasz Dębski
 *
 */
@RestController
public class OrderPackController {
	
	@Autowired
	OrderPackService orderpackService;
	
	@RequestMapping("/orderPack")
	public List<OrderPack> getAllBooks(){
		return orderpackService.getAllOrderPacks();
	}

	@RequestMapping(value = "/orderPack",method= RequestMethod.POST)
	public void addOrderPack(@RequestBody OrderPack orderPack){
		orderpackService.addOrderPack(orderPack);
	}
	
	@RequestMapping(value="/orderPack/{id}")
	public OrderPack getOrderPackById(@PathVariable("id") long id){
		return orderpackService.getOrderPackbyId(id);
	}
	
	@RequestMapping(value="/orderPack/{id}",method=RequestMethod.PUT)
	public void updateOrderPack(@PathVariable("id") long id,@RequestBody OrderPack orderPack){	
		orderpackService.updateOrderPack(orderPack);
	}
	
	@RequestMapping(value="/orderPack/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") long id){
		OrderPack orderPack = orderpackService.getOrderPackbyId(id);
		orderpackService.removeOrderPack(orderPack);
	}
}
