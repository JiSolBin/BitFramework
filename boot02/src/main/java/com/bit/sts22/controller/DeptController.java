package com.bit.sts22.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.service.DeptApiService;

@RestController
@RequestMapping("/api")
public class DeptController {
	
	@Autowired
	DeptApiService deptApiService;

	@CrossOrigin
	@GetMapping("/dept")
	public List<Dept> getList(){
		
		return deptApiService.getList();
	}
	
	@CrossOrigin
	@PostMapping("/dept")
	public ResponseEntity<?> addList(@RequestBody Dept bean) {
		
		try {
			if(deptApiService.appendDept(bean)>0) {
				// body 내용도 같이 보내고 있음
				// return new ResponseEntity(HttpStatus.OK);
				// 상태코드만 보내기 (+bean)
				return ResponseEntity.ok(bean);
			}else {
				// return new ResponseEntity(HttpStatus.BAD_REQUEST);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			// return new ResponseEntity(HttpStatus.BAD_REQUEST);
			// .build() -> 객체 생성
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/dept/{deptno}")
	public Dept getDept(@PathVariable int deptno) {
		
		return deptApiService.getDept(deptno);
	}
	
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<?> editDept(@PathVariable int deptno, @RequestBody Dept bean){
		
		try {
			if(deptApiService.editDept(bean)>0) {
				return ResponseEntity.ok(bean);
			}
		} catch (Exception e) {}
		
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<?> removeDept(@PathVariable int deptno){
		return deptApiService.removeDept(deptno)>0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}
}
