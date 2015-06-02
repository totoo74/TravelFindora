package controllers;

import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void signIn(){
        render();
    }

    public static void index() {
        render();
    }

    public static void register(String firstname, String lastname, String email, String password) {
        User newUser = new User();
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setEmail(email);
        newUser.setPassword(password);


    newUser.save();

    try {
        Secure.authenticate(email, password, false); 
    } catch(Throwable t) {
        t.printStackTrace();
    }
    session.put("email", email);
    redirect("index.html");

    }

}
