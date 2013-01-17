package models;

import play.db.ebean.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task extends Model {

 	public static Finder<Long,Task> find = new Finder(
    	Long.class, Task.class
  	);

	public static List<Task> all() {
    	return find.all();
  	}

	public static void delete(Long id) {
	    find.ref(id).delete();
	}

    @Id
    public String id;

    public String contents;

}