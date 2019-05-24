package pe.com.core.test.integration.test;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.proyection.projection.controller.TaskController;
import io.proyection.projection.domain.Task;
import io.proyection.projection.domain.User;
import io.proyection.projection.repository.TaskRepository;
import sun.security.util.PendingException;
import static org.mockito.Mockito.doNothing;

import java.io.IOException;
import java.util.Date;

public class TaskIntegrationTest {
	private final TaskController taskController = new TaskController();
	private static Task task = new Task();
	private static User user = new User();
	private String mensaje = "";
	private String nombreCategoria = "";
	@Mock
	private HttpServletResponse response;

	@Given("despues de iniciar sesion en la aplicacion")
	public void despues_de_iniciar_sesion_en_la_aplicacion()throws Throwable {
		MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com");
        user.setId((long) 1);
        Assert.assertTrue(true);
	}
	
	@When ("hago click en el boton agregar tarea")
	public void hagoClickEnElBotonAgregarTarea() throws Throwable {
		MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com/tasks");
        Assert.assertTrue(true);
	}
	
	@And ("en la nueva pantalla escribo en el campo Nombre el valor de \"Login\"")
	public void enLaNuevaPantallaEscriboEnElCampoNombreElValor() {
		task.setSummary("");
		task.setCreatedBy("Miguel");
		task.setLimitDate(new Date());
		Assert.assertTrue(true);
	}
	@And("presiono el boton de Guardar")
	public void presionoElBotonDeGuardar() {
		try {
			taskController.createTask(user.getId(), task);
			mensaje = "Se registro el task correctamente";
	        Assert.assertTrue(true);

		} catch (Exception e) {
			mensaje = "Error: " + e.getMessage();
			Assert.fail(mensaje);
		}
	}
}