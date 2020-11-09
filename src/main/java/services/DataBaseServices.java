package services;

import com.mysql.cj.MysqlConnection;
import db.MySQLConnection;
import dto.Response;

import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("db")
public class DataBaseServices {

    @POST
    @Path("create")
    @Produces("application/json")
    public Response createDB(){
        MySQLConnection connection = new MySQLConnection();
        if(connection.createDataBase()) {
            return new Response("Base de datos creada con exito");
        }else{
            return new Response("No se creo la base de datos");
        }
    }
}
