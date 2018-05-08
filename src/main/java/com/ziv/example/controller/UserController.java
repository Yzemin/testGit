package com.ziv.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.example.bean.User;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年2月14日   下午5:39:47 
 * 类说明 :
 * 
*/
@RestController
@RequestMapping(value = "/user")
public class UserController {
	@RequestMapping
	public String login() {
		return "Hi World";
	}
	
	@RequestMapping(value = "get")
	public Map<String,Object> get(@RequestParam String name){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("date", new Date());
		return map;
	}
	
	@RequestMapping(value = "find/{id}/{name}")
	public User get(@PathVariable int id,@PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
	
	
}
 