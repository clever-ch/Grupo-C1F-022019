package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

public class TestDomainComponents {
	
	JavaClasses classes = new ClassFileImporter().importClasspath();
	
	@Test
	public void serviceClassesShouldOnlyBeAccessedByControllers() {
		ArchRule rule = ArchRuleDefinition.classes()
				.that().resideInAPackage("..root.service")
				.should().onlyBeAccessed().byAnyPackage("..root.controller", "..root.service");
		rule.check(classes);
	}

}