package services;

import dto.Response;
import model.dto.ProfesorDTO;
import model.provider.ProfesoresProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("profesores")
@Stateless
public class ProfesorServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public dto.Response createProfesor(ProfesorDTO profesorDTO){
        ProfesoresProvider profesoresProvider = new ProfesoresProvider();
        profesoresProvider.insertProfesores(profesoresProvider.mapDTO(profesorDTO));
        return new Response("Operacion exitosa");
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("{id}")
    public ProfesorDTO getProfesor(@PathParam("id") String id){
        ProfesoresProvider provider = new ProfesoresProvider();
        ProfesorDTO profesorDTO = provider.getCompleteProfesorByID(Integer.parseInt(id));
        return profesorDTO;
    }

}
