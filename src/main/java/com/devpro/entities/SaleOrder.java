package com.devpro.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
public class SaleOrder {
	

	@Column(name = "total", precision = 13, scale = 2, nullable = false)
	private BigDecimal total;

	
	@Id // xác định đây là khoá chính.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
	@Column(name = "id")
	private Integer id; // primary-key

	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	 
	
	@Column(name="note", columnDefinition = "LONGTEXT", nullable = false)
	private String note;
	
	@Column(name="address", columnDefinition = "LONGTEXT")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name = "status")
	private Integer status= 0;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleOrder", fetch = FetchType.LAZY)
	private List<SaleOrderProducts> saleOrderProducts = new ArrayList<SaleOrderProducts>();
	
	public void addSaleOrderProducts(SaleOrderProducts _saleOrderProducts) {
		_saleOrderProducts.setSaleOrder(this);
		saleOrderProducts.add(_saleOrderProducts);
	} 	 

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<SaleOrderProducts> getSaleOrderProducts() {
		return saleOrderProducts;
	}

	public void setSaleOrderProducts(List<SaleOrderProducts> saleOrderProducts) {
		this.saleOrderProducts = saleOrderProducts;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
