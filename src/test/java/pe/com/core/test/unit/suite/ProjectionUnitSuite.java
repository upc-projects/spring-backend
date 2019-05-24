package pe.com.core.test.unit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import io.proyection.projection.domain.Task;
import pe.com.core.test.unit.test.TaskTest;

@RunWith(Categories.class)
@SuiteClasses({TaskTest.class})
public class ProjectionUnitSuite {

}
