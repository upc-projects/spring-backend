package io.proyection.projection.Unit.Test;

import io.proyection.projection.domain.Task;
import io.proyection.projection.domain.User;
import io.proyection.projection.service.TaskService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskTest {

    @Mock
    private Task task;
    @Mock
    private User user;

    @Mock
    private TaskService taskService;

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
        Assert.assertNotNull(taskService);
    }

    @Test
    public void createTask() {
        try {
            System.out.println("Metodo crear task");
            task = new Task();
            task.setCreatedBy("Miguel");
            task.setAcceptanceCriteria(null);
            task.setDone(false);
            task.setId(1L);
            task.setLimitDate(null);
            task.setModifiedBy("Miguel");
            task.setStatus(0);
            task.setSummary("test");

            user.setId(2L);
            user.setUsername("miguelito@gmail.com");
            task.setUser(user);

            when(taskService.saveOrUpdateTask(any(), any())).thenReturn(task);
            Task taskObtenido = taskService.saveOrUpdateTask(task, user.getUsername());
            Assert.assertTrue(taskObtenido.getId() > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllTasksByUserId() {
        try {
            System.out.println("Metodo obtener todos los task por id");

            task = new Task();
            task.setCreatedBy("Miguel");
            task.setAcceptanceCriteria("criteria");
            task.setDone(false);
            task.setId(1L);
            task.setLimitDate(null);
            task.setModifiedBy("Miguel");
            task.setStatus(0);
            task.setSummary("test");

            user.setId(2L);
            user.setUsername("miguelito@gmail.com");
            task.setUser(user);

            List<Task> tasks = new ArrayList<>();
            tasks.add(task);

            when(taskService.findAllTask(any())).thenReturn(tasks);
            List<Task> tasksObtenidos = (ArrayList<Task>)taskService.findAllTask(user.getUsername());
            Assert.assertTrue(tasksObtenidos.size() > 0);

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
            task.setId(2L);

            user.setId(2L);
            user.setUsername("miguelito@gmail.com");
            task.setUser(user);

            when(taskService.findTaskById(any(), any())).thenReturn(task);
            taskbuscada = taskService.findTaskById(2L,user.getUsername());
            Assert.assertNotNull(taskbuscada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTask() {
        try {
            Task taskBuscado;
            Task taskEditado;

            task = new Task();
            task.setSummary("Edita la tarea");
            task.setId(2L);

            user.setId(2L);
            user.setUsername("miguelito@gmail.com");
            task.setUser(user);

            when(taskService.findTaskById(any(),any())).thenReturn(task);
            taskBuscado = taskService.findTaskById(2L, user.getUsername());

            task.setSummary("Tarea editada");
            task.setModifiedBy("Miguel");
            when(taskService.saveOrUpdateTask(any(), any())).thenReturn(task);
            taskEditado = taskService.saveOrUpdateTask(task, user.getUsername());

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
            task.setId(3L);

            user = new User();
            user.setId(4L);
            user.setUsername("miguelito@gmail.com");

            Boolean taskEliminado;

            when(taskService.deleteTaskByIdentifier(any(),any())).thenReturn(true);
            taskEliminado = taskService.deleteTaskByIdentifier(3L,user.getUsername());

            Assert.assertTrue(taskEliminado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}