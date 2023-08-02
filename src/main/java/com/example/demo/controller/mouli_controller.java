package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandling.ApiResponse;
import com.example.demo.payload.ok;
import com.example.demo.services.ok2;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")

public class mouli_controller {
	@Autowired
	ok2 ok2;
	@PostMapping("/insert")
	public ResponseEntity<ok>addusers(@Valid @RequestBody ok pp){
		ok mouli=this.ok2.addusers(pp);
		return new ResponseEntity<>(mouli,HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ok>updateusers(@Valid @PathVariable int id, @RequestBody ok kk,Object Application){
		ok kk1=this.ok2.updateusers(kk, id);
		return ResponseEntity.ok(kk1);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse>delete(@Valid @PathVariable int id){
		this.ok2.deleteusers(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("id deleted succussfully",true),HttpStatus.OK);
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ok>getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.ok2.getbyid(id));
	}
	@GetMapping("/getall")
    public ResponseEntity<List<ok>> getall(){
    	return ResponseEntity.ok(this.ok2.getallusers());
    }
}
