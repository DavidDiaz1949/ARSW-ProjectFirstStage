package arsw.bloodymoney.persistence.dao.impl;

import arsw.bloodymoney.controllers.UserController;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.UserDAO;
import java.util.List;

/**
 * Interface UserDAOImpl that implements all the
 * functionalities related with a User
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2018-11-23
 */
public class UserDAOImpl implements UserDAO{

    //@Inject
    private UserController userController;
    //Mapper
    
    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User load(int id) throws ProjectException{
        try {
            //TO-DO
            User user = new User();
            return user;
            //return userController.;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: MyBatisUserDAO\n-Method: load()\nNo existe ningun usuario con el id: \n" + id + "\n", ex);
        }
    }

    @Override
    public User load(String email) throws ProjectException{
        try {
            //TO-DO
            User user = new User();
            return user;
            //return userController.;
        } catch (Exception ex) {
            throw new ProjectException("\nERROR:\nClass: MyBatisUserDAO\n-Method: load()\nNo existe ningun usuario con el email: \n" + email + "\n", ex);
        }
    }

    @Override
    public List<User> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRole(int id, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}