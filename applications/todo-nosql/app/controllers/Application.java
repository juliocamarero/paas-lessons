package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

  public static Result index() {
      return tasks();
  }

  public static Result tasks() {

  }

  public static List<Task> getTaskList() {

  }

  public static Result newTask() {
     
  }

private static DB getDb() {
    String userName = play.Configuration.root().getString("mongo.remote.username");
    String password = play.Configuration.root().getString("mongo.remote.password");

    String langs = play.Configuration.root().getString("application.langs");

    boolean local  = true;

    String localHostName = play.Configuration.root().getString("mongo.local.hostname");
    Integer  localPort = play.Configuration.root().getInt("mongo.local.port");

    String remoteHostName = play.Configuration.root().getString("mongo.remote.hostname");
    Integer remotePort = play.Configuration.root().getInt("mongo.remote.port");

    Mongo m;
    DB db = null;

    if(local){
        String hostname = localHostName;
        int port = localPort;
        try {
            m = new Mongo( hostname, port);
            db = m.getDB( "db" );
        }catch(Exception e) {
            Logger.error("Exception while intiating Local MongoDB", e);
        }
    }else {
        String hostname = remoteHostName;
        int port = remotePort;
        try {
            m = new Mongo( hostname , port);
            db = m.getDB( "db" );
            boolean auth = db.authenticate(userName, password.toCharArray());
        }catch(Exception e) {
            Logger.error("Exception while intiating Local MongoDB", e);
        }
    }
    return db;
}
}