package com.tmtc.vo;

import com.tmtc.po.Product;

public class ProductVo extends Product{
	private String pro_type_name;
	private String sell_type_name;
	private String city_name;
	private String company_name;
	public ProductVo() {	}
	public ProductVo(Product product,String pro_type_name, String sell_type_name, String city_name, String company_name) {
		super(product.getId(),product.getCity_id(),product.getCompany_id(),product.getPro_name(),product.getPro_type(),product.getRemote_url(),
				product.getMarket_price(),product.getShop_price(),product.getExp_score(),
				product.getDetail(),product.getStock(),product.getSell_type(),product.getLimit_buy(),product.getSort(),
				product.getRemark(),product.getCreate_time(),product.getIs_check(),product.getPro_picture());
		this.pro_type_name = pro_type_name;
		this.sell_type_name = sell_type_name;
		this.city_name = city_name;
		this.company_name = company_name;
	}
	public String getPro_type_name() {
		return pro_type_name;
	}
	public void setPro_type_name(String pro_type_name) {
		this.pro_type_name = pro_type_name;
	}
	public String getSell_type_name() {
		return sell_type_name;
	}
	public void setSell_type_name(String sell_type_name) {
		this.sell_type_name = sell_type_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@Override
	public String toString() {
		return "ProductVo [pro_type_name=" + pro_type_name + ", sell_type_name=" + sell_type_name + ", city_name="
				+ city_name + ", company_name=" + company_name + "]";
	}
}
