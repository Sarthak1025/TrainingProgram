package com.training.controller;

import com.training.beans.Order;
import com.training.service.AddOnService;
import com.training.service.CoffeeService;
import com.training.service.OrderService;
import com.training.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private AddOnService addOnService;
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public ModelAndView indexController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@GetMapping("/about")
	public ModelAndView aboutController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	@GetMapping("/contact")
	public ModelAndView contactController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}
	@GetMapping("/menu")
	public ModelAndView menuController() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("coffeeList",coffeeService.getAllCoffees());
		mv.addObject("sizeList",sizeService.getAllSizes());
		mv.addObject("addOnList",addOnService.getAllAddOns());
		mv.addObject("order",new Order());
		mv.setViewName("menu");
		return mv;
	}
	@PostMapping("/order")
	public ModelAndView orderController(@ModelAttribute("order") Order order) {
		ModelAndView mv = new ModelAndView();
		System.out.println(order);
		orderService.getAllOrders();
		mv.addObject("trueBill",orderService.generateTrueBill(order));
		mv.addObject("discountPercent",orderService.getDiscountPercentage(order));
		mv.addObject("finalBill",orderService.generateFinalBill(order));
		orderService.placeOrder(order);
		mv.setViewName("finalbill");
		return mv;
	}
}
