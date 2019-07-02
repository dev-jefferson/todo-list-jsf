package br.com.jhsgdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.jhsgdev.VO.TodoVO;

@ViewScoped
@ManagedBean(name = "todoBean")
public class TodoBean {
	
	private static final String REST_URI = "https://jhsg-todo-api.herokuapp.com/todos";

	private TodoVO obj;
	private List<TodoVO> todos = new ArrayList<>();
	private Client cliente = ClientBuilder.newClient();
	private List<TodoVO> selectedTodo;

	
	public TodoBean() {
		super();
		obj = new TodoVO();
		this.getListTodos();
	}

	/**
	 * Funções
	 */

	private Client client = ClientBuilder.newClient();
	private Gson gson = new Gson();

	public TodoVO getTodo(int id) {
		return this.cliente.target(REST_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(TodoVO.class);
	}
		
	public List<TodoVO> getListTodos() {
		
		String jsonObj = this.cliente.target(REST_URI).path("/").request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);
		TodoVO[] lista = this.gson.fromJson(jsonObj, TodoVO[].class);

		
		this.todos.clear();
		this.todos.addAll(Arrays.asList(lista));
		return this.todos;
	}
	
	
	
	public List<TodoVO> adicionarTodo() {

		if (!this.obj.getNome().equals("")) {
			
			this.getSelectedTodo();

			TodoVO todo = new TodoVO(null, this.obj.getNome(), new Date(), new Date(), false);
			
			//Client client = ClientBuilder.newClient();
			
			WebTarget webTarget = this.cliente.target(REST_URI);


			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.json(todo));
			
		
			
			//System.out.println(response.getStatus());
			//System.out.println(response.readEntity(String.class));
			//System.out.println(this.gson.toJson(todo, TodoVO.class).toString());
			//this.getTodo(1);
		}
		return this.getListTodos();
	}
	
	public void removerTodo(Integer id) {
		
		WebTarget webTarget = client.target(REST_URI).path(id.toString());
		 
		Invocation.Builder invocationBuilder =  webTarget.request();
		Response response = invocationBuilder.delete();
		 
		this.getListTodos();
		
	}


	public TodoVO getObj() {
		return obj;
	}

	public void setObj(TodoVO obj) {
		this.obj = obj;
	}

	public List<TodoVO> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoVO> todos) {
		this.todos = todos;
	}

	public List<TodoVO> getSelectedTodo() {
		return selectedTodo;
	}
	
	public void setSelectedTodo(List<TodoVO> selectedTodo) {
		this.selectedTodo = selectedTodo;
	}
	
	

}
