package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.Menu;
import service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping(value = "/getMenu", method= RequestMethod.GET)
	public ModelAndView getMenu(@RequestParam long id)
	{
		ModelAndView mv=new ModelAndView("showMenu.jsp");
		Menu aMenu=menuService.getMenuRepository().findById(id).orElse(new Menu());	
		
		mv.addObject(aMenu);
		return mv;
	}
	
	//@RequestMapping("/menus")
    //@ResponseBody
    //public ResponseEntity<List> getMenus() {
    //    return new ResponseEntity(menuService.getMenus(), HttpStatus.OK);
    //}
}
