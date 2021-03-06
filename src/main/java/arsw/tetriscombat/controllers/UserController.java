package arsw.tetriscombat.controllers;

import arsw.tetriscombat.mappers.Bridge;
import arsw.tetriscombat.entities.Session;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.services.impl.InMemorySessionPersistence;
import arsw.tetriscombat.services.impl.UserServicesImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/session")
public class UserController {

    UserServicesImpl usi = new UserServicesImpl();

    @RequestMapping(method = RequestMethod.GET, path = "{username}")
    public ResponseEntity<?> verifyDuplicatedUsername(@PathVariable("username") String username) {
        try {
            boolean res = usi.checkduplicated(username);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{email}")
    public ResponseEntity<?> verifyLinekdEmail(@PathVariable("email") String email) {
        try {
            boolean res = usi.checkUsedEmail(email);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> verifySession(@PathVariable("user") String user) {
        try {
            Bridge bg = new Bridge();
            User res = bg.getUserByEmail(user);
            if (res.getEmail() == null){
                return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }*/
    // DAO TERMINA DE CONSULTAR ACA EN CONTROLLER

    @RequestMapping(method = RequestMethod.GET, path = "{user}/{password}")
    public ResponseEntity<?> verifyLogin(@PathVariable("user") String username, @PathVariable("password") String password) {
        try {
            //Old implementation
            //Bridge bg = new Bridge();
            //User res = bg.authentication(username, password);

            //New implementation
            User res2 = usi.checkLogin(username,password);
            Session session = new Session(res2);
            if(res2.getUsername() == null){
                return new ResponseEntity<>(session, HttpStatus.ACCEPTED);
            } else{
                InMemorySessionPersistence.sessions.put(res2,session);
                InMemorySessionPersistence.sessions2.put(res2.getUsername(),session);
                return new ResponseEntity<>(session, HttpStatus.ACCEPTED);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<?> createNewPlayer(@RequestBody User user) {
        try {
            usi.createElement(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
}