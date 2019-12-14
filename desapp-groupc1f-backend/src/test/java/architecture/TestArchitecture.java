package architecture;

import org.junit.BeforeClass;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

public class TestArchitecture {
	
	static JavaClasses classes;
	
	@BeforeClass
	public static void setUp() {
	 classes = new ClassFileImporter()
			.importClasspath();
	}
}