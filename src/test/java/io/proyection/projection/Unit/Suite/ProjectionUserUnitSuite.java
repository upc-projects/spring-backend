package io.proyection.projection.Unit.Suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import io.proyection.projection.Unit.Test.UserTest;

@RunWith(Categories.class)
@SuiteClasses({UserTest.class})
public class ProjectionUserUnitSuite {

}

