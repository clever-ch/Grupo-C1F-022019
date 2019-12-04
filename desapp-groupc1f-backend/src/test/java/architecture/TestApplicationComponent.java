package architecture;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class TestApplicationComponent extends TestArchitecture {
	
	  @Test
	  public void noClassesWithServiceAnnotationShouldResideOutsideTheApplicationLayer() {
	    ArchRule rule = ArchRuleDefinition.classes()
	      .that().areAnnotatedWith(Service.class)
	      .should().resideOutsideOfPackage("root.model");
	    rule.check(classes);
	  }
}
