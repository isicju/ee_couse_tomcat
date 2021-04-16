package com.eecourse.rest;

import com.eecourse.rest.dao.UsersDAO;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
public class SimpleRestApi {
    @GET
    public Response getMsg() {
        List<UsersDAO.Employee> employeeList = UsersDAO.getEmployees();
        Gson gsonConverter = new Gson();
        String employeeJson = gsonConverter.toJson(employeeList);
        return Response.status(200).entity(employeeJson).build();
    }
}
