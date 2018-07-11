package json.data;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.UserModel;
import utils.Util;

//http://localhost:8080/myProject/webservice/getExample/age/2
@Path("/getExample")
public class Main {

    DbOperations dbOp;
    Statement statement;
    public CachedRowSet resWanted;
    Util myUtil;
    String result;

    @GET
    @Produces(MediaType.APPLICATION_JSON)           //JSON tipinde bir şeyler üreticem
    @Path("/getTheList")
    public List<UserModel> start() throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWork();
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)           //JSON tipinde bir şeyler üreticem
    @Path("/age/{age}")
    public List<UserModel> start(@PathParam("age") int customerAge) throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWorkByAge(customerAge);
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)           //JSON tipinde bir şeyler üreticem
    @Path("/getNameAndAge")
    public List<UserModel> start(@QueryParam("name") String customerName, @QueryParam("age") int customerAge) throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWorkByAgeAndName(customerName, customerAge);
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)           //JSON tipinde bir şeyler üreticem
    @Path("/surname/{sur}")
    public List<UserModel> surname(@PathParam("sur") String surname) throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWorkBySurname(surname);
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)           //JSON tipinde bir şeyler üreticem
    @Path("/name/{name}")
    public List<UserModel> getName(@PathParam("name") String customerName) throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWorkByName(customerName);
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public List<UserModel> doThis(@PathParam("id") int customerID) throws Exception {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        myRs = queryWorkByID(customerID);
        myUtil.addUser(myRs);
        return myUtil.getUserList();

    }

 
   /* @POST
    @Path("/insertUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Context HttpHeaders,UserModel user) {
        ResultSet myRs;
        dbOp = new DbOperations();
        myUtil = new Util();

        statement = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        UserModel mUser=new UserModel(name,surname,age);
        addANewUser(mUser);

    } */

    public ResultSet queryWork() throws SQLException {
        String query;
        query = "select * from users";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }

    public ResultSet queryWorkByAge(int age) throws SQLException {
        String query;
        query = "select * from users where age like '" + age + "%'";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }

    public ResultSet queryWorkByID(int id) throws SQLException {
        String query;
        query = "select * from users where id like '" + id + "%'";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }

    public ResultSet queryWorkByName(String name) throws SQLException {
        String query;
        query = "select * from users where name like '" + name + "%'";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }

    public ResultSet queryWorkByAgeAndName(String name, int age) throws SQLException {
        String query;
        query = "select * from users where name like '" + name + "%' and age like '" + age + "%'";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }

    public ResultSet queryWorkBySurname(String surname) throws SQLException {
        String query;
        query = "select * from users where surname like '" + surname + "%'";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;

    }
    
    public void addANewUser(UserModel user) throws SQLException{
        String query;
        query = "insert into users (name, surname, age) values ('"+user.getName()+"','"+user.getSurname()+"',"+user.getAge()+")";
        PreparedStatement pst = dbOp.getConnection().prepareStatement(query);
        pst.executeUpdate();
        
}
}
