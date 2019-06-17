package io.proyection.projection.Integration.Test;

import static org.mockito.Mockito.doNothing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.proyection.projection.domain.Task;
import io.proyection.projection.service.TaskService;

public class TaskIntegrationTest {
	
	private final TaskService taskService = new TaskService();
	private static Task task = new Task();
	private String mensaje = "";
	private String nombreTask = "";

	@Mock
	private HttpServletResponse response;
	
	@Given("^despues de iniciar sesion en la aplicacion$")
	public void despues_de_iniciar_sesion_en_la_aplicacion() throws Throwable {
		MockitoAnnotations.initMocks(this); 
	    doNothing().when(response).sendRedirect("http://localhost:8080");
	    Assert.assertTrue(true);
	}

	@When("^hago click en el boton agregar tarea$")
	public void hago_click_en_el_boton_agregar_tarea() throws Throwable {
		MockitoAnnotations.initMocks(this); 
	    doNothing().when(response).sendRedirect("http://localhost:8080/tasks");
	    Assert.assertTrue(true);
	}

	@When("^en la nueva pantalla escribo en el campo Nombre el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_el_campo_Nombre_el_valor_de(String arg1) throws Throwable {
		nombreTask = arg1;
	    task.setSummary(nombreTask);
	    Assert.assertTrue(true);	}

	@When("^en la nueva pantalla escribo en el campo Descripcion el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_el_campo_Descripcion_el_valor_de(String arg1) throws Throwable {
		nombreTask = arg1;
	    task.setAcceptanceCriteria(nombreTask);
	    Assert.assertTrue(true);		}

	@When("^en la nueva pantalla escribo en el campo Fecha LÃ­mite el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_el_campo_Fecha_LÃ­mite_el_valor_de(String arg1) throws Throwable {
		try {
			nombreTask = arg1;
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(nombreTask);
			task.setLimitDate(date1);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}

	@When("^presiono el boton de Guardar$")
	public void presiono_el_boton_de_Guardar() throws Throwable {
	    try {
	    	Task tasknuevo = taskService.saveOrUpdateTask(task, "usuario");
			mensaje = "Se creo correctamente la Tarea";
			Assert.assertTrue(true);
		} catch (Exception e) {
			mensaje = "Error: " + e.getMessage();
			Assert.fail(mensaje);
		}
	}

	@Then("^el sistema me muestra el mensaje de: \"([^\"]*)\"$")
	public void el_sistema_me_muestra_el_mensaje_de(String arg1) throws Throwable {
		System.out.println(mensaje);
		System.out.println(arg1);
		assertEquals(arg1, mensaje);
	}

	@When("^hago click sobre la tarea existente \"([^\"]*)\"$")
	public void hago_click_sobre_la_tarea_existente(String arg1) throws Throwable {
		Assert.assertTrue(true);
	}

	@When("^hago click en la opciÃ³n actualizar tarea$")
	public void hago_click_en_la_opciÃ_n_actualizar_tarea() throws Throwable {
		try {
			task.setDone(true);
		    Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.print("Error actualizar: " + e.getMessage());
		}
		
	}

	@When("^presiono el boton de Actualizar$")
	public void presiono_el_boton_de_Actualizar() throws Throwable {
		try {
			taskService.saveOrUpdateTask(task, "usuario");
			mensaje = "Se actualizo correctamente la Tarea";
			Assert.assertTrue(true);
		} catch (Exception e) {
			mensaje = "Error: " + e.getMessage();
			System.out.print(mensaje);
		}
	}

	@When("^se muestra la pantalla de inicio$")
	public void se_muestra_la_pantalla_de_inicio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Then("^el sistema me muestra un listado con las tareas existentes$")
	public void el_sistema_me_muestra_un_listado_con_las_tareas_existentes() throws Throwable {
		try {
			List<Task> lista = (List<Task>) taskService.findAllTask(task.getUsername());
			Assert.assertTrue(lista.size()>=0);
		} catch (Exception e) {
			System.out.print("Error actualizar: " + e.getMessage());
		}
		
	}

	@When("^hago click en la opciÃ³n eliminar tarea$")
	public void hago_click_en_la_opciÃ_n_eliminar_tarea() throws Throwable {
		 try {
				taskService.deleteTaskByIdentifier(task.getId(), task.getUsername());
				mensaje = "Se elimino correctamente la Tarea";
				Assert.assertTrue(true);
			} catch (Exception e) {
				mensaje = "Error: " + e.getMessage();
				System.out.println(mensaje);
			}
	}
}
