package com.shopping.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = 201005291207L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
