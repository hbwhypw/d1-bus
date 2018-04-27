package test;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class S {

	@NotNull
	@NotEmpty
	private String text1;
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date text2;

	public S() {
		super();
	}

	public S(String text1, Date text2) {
		super();
		this.text1 = text1;
		this.text2 = text2;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public Date getText2() {
		return text2;
	}

	public void setText2(Date text2) {
		this.text2 = text2;
	}

	@Override
	public String toString() {
		return "s [text1=" + text1 + ", text2=" + text2 + "]";
	}
	
}
