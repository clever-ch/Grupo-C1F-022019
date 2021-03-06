package root.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import root.DTO.MenuDTO;
import root.constants.MenuState;
import root.controller.exception.ResourceNotFoundException;
import root.model.Menu;
import root.repository.MenuRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MenuController {

	@Autowired
	private MenuRepository menuRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/menus")
	public List<Menu> getAllMenus() {
		LOG.info("Successful access to the menus list");
		return menuRepository.findAll();
	}
	
	@PostMapping("/menus")
	public Menu createMenu(@Valid @RequestBody MenuDTO menuDTO) {
		Menu newMenu = menuDTO.convertToMenu(menuDTO);
		newMenu.setMenuState(MenuState.Enabled);				//Por default el estado inicial es Habilitado
		
		LOG.info("Menu created: " + newMenu.getMenuName() + " through createMenu()");
		return menuRepository.save(newMenu);
	}
	
	@GetMapping("/menus/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable(value = "id") Long menuId)
			throws ResourceNotFoundException {
		Menu menu = menuRepository.findById(menuId)
				.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));
		LOG.info("getMenuById : SUCCESSFULL " + "id : " + menuId );
		return ResponseEntity.ok().body(menu);
	}
	
	@PutMapping("/menus/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable(value = "id") Long menuId,
			@Valid @RequestBody Menu menuDetails) throws ResourceNotFoundException {
		Menu menu = menuRepository.findById(menuId)
				.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));

		menu.setMenuName(menuDetails.getMenuName());
		menu.setDescription(menuDetails.getDescription());
		menu.setPrice(menuDetails.getPrice());
		menu.setValidFromDate(menuDetails.getValidFromDate());
		menu.setValidToDate(menuDetails.getValidToDate());
		menu.setDeliveryPrice(menuDetails.getDeliveryPrice());
		menu.setAvgDeliveryTime(menuDetails.getAvgDeliveryTime());
		final Menu updatedMenu = menuRepository.save(menu);
		LOG.info("updateMenu : SUCCESSFULL " + menu.getMenuName() + " ID:" + menuId);
		return ResponseEntity.ok(updatedMenu);
	}
	
	@DeleteMapping("/menus/{id}")
	public Map<String, Boolean> deleteMenu(@PathVariable(value = "id") Long menuId)
			throws ResourceNotFoundException {
		Menu menu = menuRepository.findById(menuId)
				.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));

		menuRepository.delete(menu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		LOG.info("deleteMenu : SUCCESSFULL " + menu.getMenuName() + " ID: " + menuId);
		return response;
	}
}
