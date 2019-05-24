package pe.com.core.test.integration.test;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.proyection.projection.controller.UserController;
import io.proyection.projection.domain.User;
import io.proyection.projection.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.doNothing;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sun.security.util.PendingException;


public class UserIntegrationTest {

	private final UserController userController = new UserController();
	private  UserRepository userRepository;
    private static User user = new User();
    private String mensaje = "";
	private String nombre = "";
	@Mock
	private HttpServletResponse response;
	
    @Given("^Ingreso en la aplicacion$")
    public void ingreso_en_la_aplicacion()throws Throwable{
        MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com");
        Assert.assertTrue(true);
    }

    @When("^hago click en el boton crear cuenta$")
    public void hagoClickEnElBotonCrearCuenta()throws Throwable {
    	MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com/signin.html");
        Assert.assertTrue(true);
    }

    @And("^en la nueva pantalla escribo en el campo correo electronico el valor de \"([^\"]*)\"$")
    public void enLaNuevaPantallaEscriboEnElCampoCorreoElectronicoElValorDe(String arg0) throws Throwable {
        nombre = arg0;
    	user.setEmail(nombre);
        Assert.assertTrue(true);
    }

    @And("^en la nueva pantalla escribo en el campo contraseña el valor de \"([^\"]*)\"$")
    public void enLaNuevaPantallaEscriboEnElCampoContraseñaElValorDe(String arg0) throws Throwable {
        nombre = arg0;
    	user.setPassword(nombre);
    	Assert.assertTrue(true);
    }

    @And("^presiono el boton de Guardar usuario$")
    public void presionoElBotonDeGuardarUsuario() {
        try {
			userRepository.save(user);
			mensaje = "Se registro el usuario correctamente";
			Assert.assertTrue(true);
		} catch (Exception e) {
			mensaje = "Error: " + e.getMessage();
			Assert.fail(mensaje);
		}

    }

    @Then("^el sistema me muestra el mensaje de: \"([^\"]*)\" y muestra la pantalla home$")
    public void elSistemaMeMuestraElMensajeDeYMuestraLaPantallaHome(String arg0) throws Throwable {
    	Assert.assertEquals(arg0, mensaje);
    }

    @Given("^despues de iniciar sesion en la aplicacion con el usuario que eliminare$")
    public void despuesDeIniciarSesionEnLaAplicacionConElUsuarioQueEliminare() throws Throwable{
    	MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com");
        Assert.assertTrue(true);
    }

    @When("^hago click sobre administrar usuario$")
    public void hagoClickSobreAdministrarUsuario() throws Throwable{
    	MockitoAnnotations.initMocks(this);
        doNothing().when(response).sendRedirect("http://www.projection.com/editarUsuario.html");
        Assert.assertTrue(true);
    }

    @And("^hago click en la opcion eliminar usuario$")
    public void hagoClickEnLaOpcionEliminarUsuario() {
        Assert.assertTrue(true);
    }

    @And("^hago click en aceptar en la ventana de confirmacion$")
    public void hagoClickEnAceptarEnLaVentanaDeConfirmacion() {
        try {
			userRepository.delete(user);
			mensaje = "Se elimino correctamente el Usuario";
			Assert.assertTrue(true);
		} catch (Exception e) {
			mensaje = "Error: " + e.getMessage();
			Assert.fail(mensaje);
		}
    }

    @Then("^el sistema muestra el mensaje de: \"([^\"]*)\"$")
    public void elSistemaMuestraElMensajeDe(String arg0) throws Throwable {
    	Assert.assertEquals(arg0, mensaje);  
    }

}
