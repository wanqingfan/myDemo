package com.demo.controller.front;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.model.management.User;
import com.demo.service.UserService;
import com.demo.util.CommonUtil;
import com.jfinal.core.Controller;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;


/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {

	private UserService userService = UserService.userService;

	public void index() {
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<10;i++){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id",CommonUtil.getUUID());
			jsonObject.put("username","张三"+i);
			jsonObject.put("age",i+10);
			jsonArray.add(jsonObject);
		}

		setAttr("base", getRequest().getContextPath());
		setAttr("demoList",jsonArray);
		render("/index/test.html");
	}

	public void userSave(){

		for(int i=0;i<10;i++){
			User user = new User();
			user.set("id",CommonUtil.getUUID());
			user.set("username","test"+i);
			user.set("password",DigestUtils.md5Hex("1234"));
			user.set("createDate",new Date());
			user.save();
//			getModel(user.getClass()).save();
		}

	}
}



