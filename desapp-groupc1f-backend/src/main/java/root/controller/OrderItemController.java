package root.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.DTO.OrderItemDTO;
import root.controller.exception.NumberOfMenuDistintCeroException;
import root.controller.exception.UserNotFoundException;
import root.exceptions.CantTakeCreditException;
import root.model.Customer;
import root.model.CustomerWallet;
import root.model.Menu;
import root.model.OrderItem;
import root.repository.CustomerRepository;
import root.repository.CustomerWalletRepository;
import root.repository.MenuRepository;
import root.repository.OrderItemRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OrderItemController {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustomerWalletRepository customerWalletRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("/orderItems")
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}
	
	@PostMapping("/orderItems")
	public ResponseEntity<OrderItem> buyMenu(@Valid @RequestBody OrderItemDTO orderItemDTO) throws CantTakeCreditException, UserNotFoundException, NumberOfMenuDistintCeroException {

		Optional<Menu> newMenu = menuRepository.findById(orderItemDTO.menuId);
		OrderItem orderItem = new OrderItem();
		
		if((orderItemDTO.numberMenus) > 0) {
				
				orderItem.setMenu(newMenu.get());
				orderItem.setNumberMenus(orderItemDTO.numberMenus);
				orderItem.setTotalPrice(orderItemDTO.totalPrice);
		} else throw new NumberOfMenuDistintCeroException("El numero de menus debe ser mayor a 0");
				
		CustomerWallet customerWallet = new CustomerWallet();
		Customer customer = new Customer();
		
		List<Customer> customers = customerRepository.findAll();

		for (Customer cust : customers) {
			if (cust.getTokenTPA().equals(orderItemDTO.tokenUser)) {
				customer = cust;
			} else throw new UserNotFoundException("Usuario no habilitado");
		}
		
		customerWallet = customer.getaWallet();
		customerWallet.takeCredit(orderItemDTO.totalPrice);
		
		orderItemRepository.save(orderItem);
		customerWalletRepository.save(customerWallet);
		
		return ResponseEntity.ok(orderItem);
	}
}
