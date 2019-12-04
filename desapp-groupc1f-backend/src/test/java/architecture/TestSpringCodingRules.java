package architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestSpringCodingRules extends TestArchitecture {
	
	@Test
	public void classesThatAreAnnotatedAsRestControllerEndWithTheNameController() {
		ArchRule rule = ArchRuleDefinition.classes()
				.that().areAnnotatedWith(RestController.class)
				.should().haveSimpleNameEndingWith("Controller");
		rule.check(classes);
	}
	
	@Test
	public void classesThatAreAnnotatedAsServiceEndWithTheNameService() {
		ArchRule rule = ArchRuleDefinition.classes()
				.that().areAnnotatedWith(Service.class)
				.should().haveSimpleNameEndingWith("Service");
		rule.check(classes);
	}
	
	@Test
	public void allPublicMethodsInsideAControllerAreAnnotatedWithAnyRequestMappingAnnotations() {
		ArchRule rule = ArchRuleDefinition.methods()
			    .that().arePublic()
			    .and().areDeclaredInClassesThat()
			          .resideInAPackage("..root.controller..")
			    .and().areDeclaredInClassesThat()
			          .haveSimpleNameEndingWith("Controller")
			    .and().areDeclaredInClassesThat()
			         .areAnnotatedWith(RestController.class)
			    .should().beAnnotatedWith(RequestMapping.class)
			    .orShould().beAnnotatedWith(GetMapping.class)
			    .orShould().beAnnotatedWith(PostMapping.class)
			    .orShould().beAnnotatedWith(DeleteMapping.class)
				.orShould().beAnnotatedWith(PutMapping.class);
		rule.check(classes);
	}
}