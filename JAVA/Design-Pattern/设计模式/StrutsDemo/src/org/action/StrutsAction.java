package org.action;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsAction extends ActionSupport{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String testValidate()
	{
		
		return "success";
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
		
	public void validate() {
		//�������Ϊ�գ���Ѵ�����Ϣ��ӵ�Action���fieldErrors
		if(this.getName()==null||this.getName().trim().equals("")){
				addFieldError("name", "�����Ǳ���ģ�");			
		}
	}
	
	
}
