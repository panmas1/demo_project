package com.example.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {

	private int statucode;
	private Date tDate;
	private HttpStatus error;
	private String errormsg;
	private String path;
	
	
	public ApiError() {
		
	}
	
	
	public ApiError(int statucode, Date tDate, HttpStatus error, String errormsg, String path) {
		super();
		this.statucode = statucode;
		this.tDate = tDate;
		this.error = error;
		this.errormsg = errormsg;
		this.path = path;
	}
	
	
	public int getStatucode() {
		return statucode;
	}
	public void setStatucode(int statucode) {
		this.statucode = statucode;
	}
	
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public HttpStatus getError() {
		return error;
	}
	public void setError(HttpStatus error) {
		this.error = error;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
