package model.provider;

import db.MySQLConnection;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import javax.ws.rs.Produces;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesoresProvider {

    public ProfesorDTO getCompleteProfesorByID(int id) {
        ProfesorDTO profesorDTO= new ProfesorDTO();
        MySQLConnection connection = new MySQLConnection();
        CursoProvider cursoProvider = new CursoProvider();
        try {
            String sql = "SELECT id, nombre, facultad FROM profesoresJC where id=" + id;
            ResultSet resultSet = connection.query(sql);

            while (resultSet.next()) {
                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));
                ArrayList<CursoDTO> cursos = cursoProvider.getAllCursosByProfesor(profesorDTO.getId());
                profesorDTO.setCursos(cursos);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return profesorDTO;

    }



    public void getAllProfesores(Profesor profesor) {

    }

    public void insertProfesores(Profesor profesor) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO profesoresJC (nombre,facultad) VALUES ('$nombre','$facultad') ";
        sql = sql.replace("$nombre", profesor.getNombre());
        sql = sql.replace("$facultad", profesor.getFacultad());
        connection.executeSQL(sql);
    }

    public void deleteProfesores() {

    }

    public void updateProfesores() {

    }

    public Profesor mapDTO(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.getNombre());
        profesor.setFacultad(dto.getFacultad());
        return profesor;
    }

    public ProfesorDTO mapToDTO(Profesor profesor){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setFacultad(profesor.getFacultad());
        return profesorDTO;
    }

    public ProfesorDTO getProfesorByID(int id) {
        ProfesorDTO profesorDTO= new ProfesorDTO();
        MySQLConnection connection = new MySQLConnection();
        CursoProvider cursoProvider = new CursoProvider();
        try {
            String sql = "SELECT id, nombre, facultad FROM profesoresJC where id=" + id;
            ResultSet resultSet = connection.query(sql);

            while (resultSet.next()) {
                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return profesorDTO;

    }
}
