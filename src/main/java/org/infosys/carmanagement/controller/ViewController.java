package org.infosys.carmanagement.controller;


import org.infosys.carmanagement.model.Car;
import org.infosys.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;


@Configuration
@Controller
public class ViewController {
	
	@Autowired
	private CarService service;

    // BEAN COMPONENT OBJ AUTOMATICALLY CREATES ( FIN CLIENT OR restTemplate )
    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
    
	@GetMapping("/register-car")
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "car-registration";
    }

    @PostMapping("/register-car")
    public String submitCarForm(@ModelAttribute Car car, Model model) {
       System.out.println(car);
		try {
        service.addCar(car);
		return "statuspage";
		}
		catch(Exception e) {
			model.addAttribute("errorMessage", "Employee not added to the database");
			return "statuspage";
		}
      
    }
    
    
}