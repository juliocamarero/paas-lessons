package controllers;

import models.Task;
import play.data.Form;

import play.*;
import play.mvc.*;

import play.db.ebean.Model;

import java.util.List;

import static play.libs.Json.toJson;

import views.html.*;

public class Application extends Controller {
  
  public static Result addTask() {
		Form<Task> form = form(Task.class).bindFromRequest();

		Task task = form.get();
		task.save();

		return redirect(routes.Application.index());
  }

  public static Result index() {
    return ok(index.render("TODO Application", form(Task.class)));
  }

	public static Result allTasks() {
	    return ok(toJson(Task.all()));
	}
  
}