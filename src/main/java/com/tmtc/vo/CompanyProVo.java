package com.tmtc.vo;

import com.tmtc.po.Company;
import com.tmtc.po.Product;

public class CompanyProVo{
	private Product product;
	private Company company;
	public CompanyProVo() {	}
	
	public CompanyProVo(Product product, Company company) {
		super();
		this.product = product;
		this.company = company;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CompanyProVo [product=" + product + ", company=" + company + "]";
	}
}
