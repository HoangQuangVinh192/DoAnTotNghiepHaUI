package com.devpro.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.devpro.entities.SaleOrder;
import com.devpro.entities.SaleOrderProducts;


import com.devpro.repositories.SaleOrderRepo;
import com.devpro.services.SaleOrderService;
@Controller
public class AdminSaleOrder {
	@Autowired
	private SaleOrderService saleOrderService;
	@Autowired
	private SaleOrderRepo saleOrderRepo;
	@Autowired
	public JavaMailSender javaMailSender;
	
	
	@RequestMapping(value = { "/admin/saleorder" }, method = RequestMethod.GET)
	public String saveProduct(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		model.addAttribute("saleorders", saleOrderService.searchAdmin(null));
		return "back-end/saleorder";
	}
	@RequestMapping(value = { "/admin/saleorder/{id}" }, method = RequestMethod.GET)
	public String saveProduct(@PathVariable("id") Integer id, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		SaleOrder saleOrder = saleOrderRepo.getOne(id);
		model.addAttribute("saleorder", saleOrder);
		model.addAttribute("saleorderproducts", saleOrderService.searchProduct(id));
		return "back-end/saleorderProduct";
	}
	@RequestMapping(value = { "/admin/confirm_saleProduct/{id}" }, method = RequestMethod.GET)
	public String confirm_sale(@PathVariable("id") Integer id, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		String status = request.getParameter("status");
		SaleOrder saleOrderInDP = saleOrderRepo.getOne(id);
		if(status.equals("1")) {
			saleOrderInDP.setStatus(1);
		}
		if(status.equals("2")) {
			saleOrderInDP.setStatus(2);
		}
		if(status.equals("3")) {
			saleOrderInDP.setStatus(3);
			List<SaleOrderProducts> sop = saleOrderService.searchProduct(id);
			for (SaleOrderProducts item : sop) {
				item.getProduct().setAmount(item.getQuality()+item.getProduct().getAmount());
			}
		}
		saleOrderRepo.save(saleOrderInDP);
		model.addAttribute("saleorders", saleOrderService.searchAdmin(null));
		
		
//		String email = saleOrderInDP.getEmail();
//		MyConstants myConstants = new MyConstants();
//		myConstants.setFRIEND_EMAIL(email);
//		SimpleMailMessage mess = new SimpleMailMessage();
//		mess.setTo(myConstants.getFRIEND_EMAIL());
//		mess.setSubject("Xác nhận đơn hàng");
//		mess.setText("Xin chào! Đơn hàng của bạn đã được gửi. Vui lòng giữ liên lạc để nhận hàng. Cảm ơn bạn đã mua"
//				+ "hàng của chúng tôi");
// 
//        // Send Message!
//        this.javaMailSender.send(mess);

		return "back-end/saleorder";
	}
}
