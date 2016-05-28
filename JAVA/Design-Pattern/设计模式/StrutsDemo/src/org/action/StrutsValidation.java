package org.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsValidation extends ActionSupport{
	private String name;
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String testValidate()
	{
		if(!name.equals("HelloWorld")){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("name", getName()+" 来自testValidate()方法的验证");
			return "success";
		}else{
			return "error";
		}
	}
	
	public String execute() throws Exception{
		if(!name.equals("HelloWorld")){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("name", getName());
			return "success";
		}else{
			return "error";
		}
	}
}
