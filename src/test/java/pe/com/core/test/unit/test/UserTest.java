package pe.com.core.test.unit.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.proyection.projection.controller.TaskController;
import io.proyection.projection.controller.UserController;
import io.proyection.projection.domain.Task;
import io.proyection.projection.domain.User;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@Mock
	private UserController userController;
	@Mock
	private User user;
	
	@BeforeClass //executes one time and one time only
	public static void inicioClase() {
		System.out.println("Inicio de la clase");
	}
	
	
	@AfterClass //when all the test cases have been executed
	public static void finClase() {
		System.out.println("Fin de la clase");
	}
	
	@Before //Executes each time a method is being called
	public void inicioMetodo() {
		System.out.println("Inicio del método");
	}
	
	@After //Executes each time after the method was called
	public void despuesMetodo() {
		System.out.println("Despues de cada test");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void insertarUser() {
		try {
			System.out.println("Metodo insertar usuario");
			user = new User();
			user.setUsername("Miguel");
			user.setPassword("testing321");
			user.setFirstname("Miguel");
			user.setLastname("Delgado");
			user.setEmail("miguel@gmail.com");
			user.setId((long) 1);
			when(userController.createUser(Matchers.any())).thenReturn(user);
			User userObtenido = userController.createUser(user);
			Assert.assertTrue(userObtenido.getId()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void obtenerUsuario() {
		try {
			System.out.println("Metodo obtener usuario");
			User userBuscado;
			user = new User();
			user.setFirstname("Enzo");
			user.setId((long) 2);
			when(userController.getUserById(Matchers.any())).thenReturn(user);
			userBuscado = userController.getUserById(user.getId());
			Assert.assertNotNull(userBuscado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void updateUser() {
		try {
			User userBuscado;
			User userEditado = new User();
			userEditado.setUsername("Miguel");
			userEditado.setPassword("testing321");
			userEditado.setFirstname("Miguel");
			userEditado.setLastname("Delgado");
			userEditado.setEmail("miguel@gmail.com");
			userEditado.setId((long) 3);
			
			user = new User();
			user.setFirstname("Enzo");
			user.setId((long) 2);
			
			when(userController.updateUser(Matchers.any(), Matchers.any())).thenReturn(userEditado);
			when(userController.getUserById(Matchers.any())).thenReturn(user);
			user.setId(userController.updateUser(user.getId(), userEditado).getId());
			userBuscado = userController.getUserById(user.getId());
			System.out.println("Metodo actualizar usuario");
			System.out.println(userBuscado.getId());
			Assert.assertEquals(userBuscado.getId(), userEditado.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void deleteUser() {
		try {
			user = new User();
			user.setFirstname("Rodrigo");
			user.setId((long)3);
			
			User userEliminado = new User();
			when(userController.deleteUser(Matchers.any())).thenReturn(null);
			userEliminado = userController.deleteUser(user.getId());
			Assert.assertNull(userEliminado);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void  getAllUsers() {
		try {
			System.out.println("Metodo obtener todos los usuarios");
			Sort sort = null;
			when(userController.getAllUsers(Matchers.any())).thenReturn(true);
			System.out.println(userController.getAllUsers(sort));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
}
