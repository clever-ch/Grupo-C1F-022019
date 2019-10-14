package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Menu;
import repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public List<Menu> getMenus() {
        return (List<Menu>) menuRepository.findAll();
    }
	
	public MenuRepository getMenuRepository() {
		return this.menuRepository;
	}
}
