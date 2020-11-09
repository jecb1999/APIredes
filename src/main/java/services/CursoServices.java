package services;

import dto.Response;
import model.dto.CursoDTO;
import model.provider.CursoProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("cursos")
@Stateless
public class CursoServices {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public dto.Response createCurso(CursoDTO cursoDTO){
        CursoProvider cursoProvider = new CursoProvider();
        cursoProvider.insertCurso(cursoProvider.map(cursoDTO));
        return new Response("Operacion exitosa");
    }

    @GET
    @Path("all")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<CursoDTO> getAllCursos(){
        CursoProvider provider = new CursoProvider();
        ArrayList<CursoDTO> cursosDTO = provider.getAllCurso();
        return cursosDTO;
    }
}
