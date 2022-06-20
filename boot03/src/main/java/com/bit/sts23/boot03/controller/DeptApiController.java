package com.bit.sts23.boot03.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.bit.sts23.boot03.mapper.domain.Dept;
import com.bit.sts23.boot03.service.RestServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DeptApiController {
	
	@Autowired
	RestServiceImpl restService;

	// 부서 리스트 조회
	@GetMapping("/dept")
	public ResponseEntity<?> getList(){
		return ResponseEntity.ok(restService.selectAll());
	}
	
	// 부서 조회
	@GetMapping("/dept/{deptno}")
	public ResponseEntity<?> getDept(@PathVariable int deptno) {
		return ResponseEntity.ok(restService.selectOne(deptno));
	}
	
	// 부서 추가
	@PostMapping("/dept")
	public ResponseEntity<?> addDept(@RequestBody Dept dept) {
		
		// JSON 형태로 보내기 위해서 map 사용
		Map<String, Object> map = new LinkedHashMap<>();
		
		if(restService.insertOne(dept)>0) {
			map.put("result", true);
			return ResponseEntity.ok(map);
		}
		
		map.put("result", false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	// 부서 수정
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<?> editDept(@PathVariable int deptno, @RequestBody Dept bean){
		
		Map<String, Object> map = new LinkedHashMap<>();
		
		if(restService.updateOne(bean)>0) {
			map.put("result", true);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		map.put("result", false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	// 부서 삭제
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<?> deleteDept(@PathVariable int deptno){
		return ResponseEntity.status(
				restService.deleteOne(deptno)>0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST
				).build();
	}
	
}
