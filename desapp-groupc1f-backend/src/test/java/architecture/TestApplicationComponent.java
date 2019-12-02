package architecture;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class TestApplicationComponent {
	
	JavaClasses classes = new ClassFileImporter().importClasspath();
	
	@Test
	  public void noClassesWithServiceAnnotationShouldResideOutsideTheApplicationLayer() {
	    ArchRule rule = ArchRuleDefinition.classes()
	      .that().areAnnotatedWith(Service.class)
	      .should().resideOutsideOfPackage("root.model");
	    rule.check(classes);
	  }
}
