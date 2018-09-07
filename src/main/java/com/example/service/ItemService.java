package com.example.service;

import java.util.List;

import com.example.model.Item;

public interface ItemService {
	void save(Item cricketer);
	Item findById(Long id);
	List<Item> getAllItems();	
}
