package load_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import load_service.entity.LoadData;
import load_service.service.LoadService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("load")
@AllArgsConstructor
public class LoadController {
	private LoadService service;
	
	@GetMapping("/{id}")
	public LoadData getLoadReport(@PathVariable Long id) {
		LoadData data=service.getLoadReport(id);
        
		return data;
	}

}
