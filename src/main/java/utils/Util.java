package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.UserModel;

public class Util {
 List<UserModel> userList;
    public Util(){
        userList= new ArrayList<>();
    }
    

    public void addUser(ResultSet rs) throws SQLException {
        UserModel newUser;
        while (rs.next()) {
            newUser = new UserModel();
            newUser.setID(rs.getInt("id"));
            newUser.setName(rs.getString("name"));
            newUser.setSurname(rs.getString("surname"));
            newUser.setAge(rs.getInt("age"));
            userList.add(newUser);
        }

    }
    public List<UserModel> getUserList()
    {
        return userList;
    }

}
