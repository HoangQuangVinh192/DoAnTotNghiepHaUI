package com.devpro.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_products")
public class Product extends BaseEntity{
	@Column(name = "title", length = 500, nullable = false)
	private String title;

	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price = BigDecimal.ZERO;

	@Column(name = "short_description", length = 3000, nullable = false)
	private String shortDes;

	@Lob
	@Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT")
	private String shortDetails;

	@Column(name = "seo", nullable = false)
	private String seo;
	
	@Column(name = "selling", nullable = false)
	private int selling = 0;
	
	@Column(name = "amount")
	private int amount = 100;
	
	@Column(name ="saleoff", nullable = false)
	private int saleoff=0;
	
	@Column(name="price_sale", nullable = false)
	private BigDecimal price_sale = price.subtract(price).multiply(new BigDecimal(saleoff).divide(new BigDecimal(100)));
	
	public BigDecimal discount(BigDecimal gia, int giam) {
		return gia.subtract(gia.multiply(new BigDecimal(giam).divide(new BigDecimal(100))));
	}
	
	public int getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(int saleoff) {
		this.saleoff = saleoff;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gift_id")
	private Category gift;

	public Category getGift() {
		return gift;
	}

	public void setGift(Category gift) {
		this.gift = gift;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Images> productImages = new ArrayList<Images>();
	
	public void addProductImages(Images _productImages) {
		_productImages.setProduct(this);
		productImages.add(_productImages);
	}
	
	public void removeProductImages(Images _productImages) {
		_productImages.setProduct(null);
		productImages.remove(_productImages);
	}

	public void removeProductImages() {
		for(Images productImages : productImages) {
			removeProductImages(productImages);
		}
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getShortDetails() {
		return shortDetails;
	}

	public void setShortDetails(String shortDetails) {
		this.shortDetails = shortDetails;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Images> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<Images> productImages) {
		this.productImages = productImages;
	}


	public int getSelling() {
		return selling;
	}

	public void setSelling(int selling) {
		this.selling = selling;
	}

	public BigDecimal getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(BigDecimal price_sale) {
		this.price_sale = price_sale;
	}

	

	
	

	
	

	

	

	
	
}
