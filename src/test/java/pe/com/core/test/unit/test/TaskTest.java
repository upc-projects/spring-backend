package pe.com.core.test.unit.test;

import io.proyection.projection.controller.TaskController;
import io.proyection.projection.domain.Task;
import io.proyection.projection.domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskTest {

    @Mock
    private Task task;
    @Mock
    private User user;

    @Mock
    private TaskController taskController;

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

    @Test
    public void notNullChecker() {
        Assert.assertNotNull(task);
        Assert.assertNotNull(taskController);
    }

    @Test
    public void createTask() {
        try {
            System.out.println("Metodo crear task");
            task = new Task();
            task.setCreatedBy("Miguel");
            task.setAcceptanceCriteria(null);
            task.setCreatedAt(new Date());
            task.setDone(false);
            task.setId((long) 1);
            task.setLimitDate(null);
            task.setModifiedBy("Miguel");
            task.setStatus(0);
            task.setSummary("test");
            task.setUpdatedAt(new Date());
            user.setId((long) 2);
            task.setUser(user);

            when(taskController.createTask(any(), any())).thenReturn(task);
            Task taskobtenido = taskController.createTask(user.getId(), task);
            Assert.assertTrue(taskobtenido.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllTasksByUserId() {
        try {
            System.out.println("Metodo obtener todos los task por id");
            when(taskController.getAllTasksByUserId(any(), any())).thenReturn(any());
            System.out.println(taskController.getAllTasksByUserId((long) 1, any()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTaskById() {
        try {
            System.out.println("Metodo obtener tarea por id");
            Task taskbuscada;
            task = new Task();
            task.setSummary("haz tu tarea");
            task.setId((long) 2);

            when(taskController.getTaskById(any())).thenReturn(task);
            taskbuscada = taskController.getTaskById(task.getId());
            Assert.assertNotNull(taskbuscada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void getAllTasks() {
        try {
            System.out.println("Metodo obtener todos los task");
            Page<Task> tasks = (Page<Task>) task;
            when(taskController.getAllTasks(any())).thenReturn(tasks);
            System.out.println(taskController.getAllTasksByUserId((long) 1, any()));
            when(taskController.getTaskById(any())).thenReturn(task);
            Assert.assertNotNull(task.getId());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void updateTask() {
        try {
            Task taskBuscado;
            Task taskEditado = new Task();
            taskEditado.setAcceptanceCriteria(null);
            taskEditado.setId((long) 3);
            taskEditado.setModifiedBy("Miguel");

            task = new Task();
            task.setSummary("edita la tarea");
            task.setId((long) 2);

            when(taskController.updateTask(any(), any(), any())).thenReturn(taskEditado);
            when(taskController.getTaskById(any())).thenReturn(task);
            task.setId(taskController.updateTask(user.getId(), task.getId(), taskEditado).getId());
            taskBuscado = taskController.getTaskById(task.getId());
            System.out.println("Metodo actualizar task");
            System.out.println(taskBuscado.getId());
            Assert.assertEquals(taskBuscado.getId(), taskEditado.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTask() {
        try {
            task = new Task();
            task.setSummary("Tarea simple");
            task.setId((long) 3);

            user = new User();
            user.setId((long) 4);
            ResponseEntity<?> taskEliminado;
            taskEliminado = taskController.deleteComment(user.getId(), task.getId());
            Assert.assertNull(taskEliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}