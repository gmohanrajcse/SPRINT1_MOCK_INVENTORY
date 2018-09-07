package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;


import com.example.repository.ItemRepository;
import com.example.service.ItemService;;

@RestController
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/api/item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
		Item item = itemService.findById(id);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@GetMapping("/api/items/")
	public ResponseEntity<List<Item>> getAllCricketers() {
		ArrayList<Item >itemsList = (ArrayList<Item>) itemService.getAllItems();
		return new ResponseEntity<List<Item>>(itemsList, HttpStatus.OK);
	}
	
	@PostMapping("/api/item/")
	public ResponseEntity<Item> addCricketer(@RequestBody Item item) {
		System.out.print(item);
		Item iItem = new Item();
		iItem.setItem_code(item.getItem_code());
		iItem.setItem_name(item.getItem_name()); 
		iItem.setItem_category(item.getItem_category());
		iItem.setPrice(item.getPrice());
		iItem.setTax(item.getTax());
		itemRepository.save(iItem);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@PutMapping("/api/item/{id}")
	public ResponseEntity<Item> updateCricketer(@PathVariable("id") Long id, @RequestBody Item item) {
		Item iItem = itemService.findById(id);
		iItem.setItem_code(item.getItem_code());
		iItem.setItem_name(item.getItem_name()); 
		iItem.setItem_category(item.getItem_category());
		iItem.setPrice(item.getPrice());
		iItem.setTax(item.getTax());
		itemRepository.save(iItem);
		return new ResponseEntity<Item>(iItem, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/item/{id}")
	public ResponseEntity<String> deleteCricketer(@PathVariable("id") Long id) {
		Item iItem = itemService.findById(id);
		itemRepository.delete(iItem);
		return new ResponseEntity<String>("Item removed", HttpStatus.OK);
	}
}
