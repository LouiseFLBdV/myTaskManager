package exercise2.creator;

import exercise2.objects.SaveObject;
import exercise2.validator.SimpleValidator;
import exercise2.objects.User;
import exercise2.validator.Validator;

public class SimpleCreatorUser implements CreatorUser {
    private String firstName;
    private String lastName;
    private String userName;
    private Validator validator;
    private SaveObject myObject;

    public SimpleCreatorUser(String[] args, SaveObject myObject){
        this.firstName = args[1].substring(4);
        this.lastName = args[2].substring(4);
        this.userName = args[3].substring(4);
        this.myObject = myObject;

        validator = new SimpleValidator(firstName, lastName, userName, myObject);
    }
    public User validateUser(){
        return validator.validateUser();
    }

    @Override
    public SaveObject createUser() {
        User newUser = validateUser();
        if(newUser!=null){
            myObject.getUsers().add(newUser);
        }
        return myObject;
    }
}
