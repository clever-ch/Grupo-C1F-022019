package architecture;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class TestComponentToTest {
	
	JavaClasses classes = new ClassFileImporter().importClasspath();
	
	@Test
	public void serviceClassesShouldOnlyBeAccessedByControllers() {
		ArchRule rule = ArchRuleDefinition.classes()
				.that().resideInAPackage("..test.java.model.factories")
				.should().onlyBeAccessed().byAnyPackage("..test.java.model");
		rule.check(classes);
	}
}
