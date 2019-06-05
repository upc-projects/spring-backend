package pe.com.core.test.unit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import pe.com.core.test.unit.test.UserTest;

@RunWith(Categories.class)
@SuiteClasses({UserTest.class})
public class ProjectionUnitSuiteUser {

}

