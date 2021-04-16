package exercise2.validator;

import exercise2.objects.SaveObject;
import exercise2.objects.User;

public class SimpleValidator implements Validator{
    private String firstName;
    private String lastName;
    private String userName;
    private SaveObject myObject;

    public SimpleValidator(String firstName, String lastName, String userName, SaveObject myObject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.myObject = myObject;
    }

    @Override
    public User validateUser() {
        User user = new User(firstName, lastName, userName);
        boolean temp=true;
        for (User value:myObject.getUsers()) {
            if (value.getUserName().equals(user.getUserName())) {
                temp = false;
                break;
            }
        }
        if (temp){
            return user;
        }
        return null;
    }
}
