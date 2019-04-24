package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemDescService;
import com.jt.service.ItemService;


@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDescService itemDescService;
	
	@RequestMapping("/{itemid}")
	public String findItemById(@PathVariable Long itemid,Model model) {
		Item item = itemService.findItemById(itemid);
		model.addAttribute("item", item);
		ItemDesc itemDesc = itemDescService.findItemDescById(itemid);
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}
}
