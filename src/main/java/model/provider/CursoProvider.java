package model.provider;

import db.MySQLConnection;
import entity.Curso;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoProvider {

    public ArrayList<CursoDTO> getAllCurso(){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        ProfesoresProvider profesoresProvider = new ProfesoresProvider();
        try {
            String sql = "SELECT nombre, programa,profesorID FROM cursosJC ";
            ResultSet resultSet = connection.query(sql);

            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(resultSet.getString(1));
                cursoDTO.setPrograma(resultSet.getString(2));
                ProfesorDTO profesorDTO = profesoresProvider.getProfesorByID(resultSet.getInt(3));
                cursoDTO.setProfesor(profesorDTO);
                cursoDTOS.add(cursoDTO);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return cursoDTOS;
    }

    public ArrayList<CursoDTO> getAllCursosByProfesor(int id){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT nombre, programa FROM cursosJC WHERE profesorID=" + id;
            ResultSet resultSet = connection.query(sql);

            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(resultSet.getString(1));
                cursoDTO.setPrograma(resultSet.getString(2));
                cursoDTOS.add(cursoDTO);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return cursoDTOS;
    }

    public void insertCurso(Curso curso){
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO cursosJC (nombre,programa, profesorID) VALUES ('$nombre','$programa','$profesor') ";
        sql = sql.replace("$nombre", curso.getNombre());
        sql = sql.replace("$programa", curso.getPrograma());
        sql = sql.replace("$profesor", ""+curso.getProfesorID());
        connection.executeSQL(sql);
    }

    public void deleteCurso(){

    }

    public void updateCurso(){

    }

    public Curso map(CursoDTO dto){
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setPrograma(dto.getPrograma());
        curso.setProfesorID(dto.getProfesor().getId());
        return curso;
    }
}
