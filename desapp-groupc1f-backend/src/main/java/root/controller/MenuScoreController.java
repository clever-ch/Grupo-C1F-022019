package root.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.MenuScoreDTO;
import root.constants.ScoreState;
import root.model.Customer;
import root.model.MenuScore;
import root.repository.CustomerRepository;
import root.repository.MenuRepository;
import root.repository.MenuScoreRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MenuScoreController {
	
	@Autowired
	private MenuScoreRepository menuScoreRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/menuscores")
	public List<MenuScore> getAllMenuScores() {
		System.out.println("|************|Entro al MenuScoreRepository|************|");
		return menuScoreRepository.findAll();
	}
	
	@PostMapping("/menuscores")
	public MenuScore createMenuScore(@Valid @RequestBody MenuScoreDTO menuScoreDTO) {
		MenuScore menuScore = new MenuScore();
		menuScore.setScoreState(ScoreState.Pending);
		menuScore.setMenu(menuRepository.findById(menuScoreDTO.idMenu).get());
		menuScore.setRate(menuScoreDTO.rate);

		List<Customer> customers = customerRepository.findAll();
		for (Customer cust : customers) {
			
			if (cust.getTokenTPA().equals(menuScoreDTO.userToken)) {
				Customer customer = cust;
				menuScore.setUser(customer);
			}
		}
		
		return menuScoreRepository.save(menuScore);
	}
}
