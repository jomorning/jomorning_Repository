package com.example.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

	@GetMapping("/jsonTest1")
	public String jsonTest1() {
		return "jsonTest1";
	}

	@PostMapping("/case1")
	public void case1(@RequestBody HashMap<String, Object> map) {
		System.out.println("mapping OK");
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map);
	}

	@GetMapping("/jsonTest2")
	public String jsonTest2() {
		return "jsonTest2";
	}

	@PostMapping("/case2")
	public void case2(@RequestBody HashMap<String, Object> map) {
		System.out.println("case2");
		System.out.println(map.get("id"));
	}

	@GetMapping("/jsonTest3")
	public String jsonTest3() {
		return "jsonTest3";
	}

	@PostMapping("/case3")
	@ResponseBody
	public HashMap<String, Object> case3(@RequestBody HashMap<String, Object> map) {
		System.out.println("case3");
		System.out.println("id: " + map.get("id"));
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("id", map.get("id"));
		result.put("msg", "서버에서 응답 완료 (테스트)");
		result.put("success", true);
		return result;
	}

}
