package org.example.crud;

import java.sql.Connection;
import java.sql.ResultSet;

import org.example.utils.Messages;

public class Crud extends ConnectionDB {
    static Messages messages = Messages.getInstance();
    java.sql.Statement st;
    ResultSet rs;

    public void insert(Integer id, String nombre, String descripcion) {
        try {
            Connection connectionDB = conectar();
            st = connectionDB.createStatement();
            String sql = "INSERT INTO  superheroes(id,nombre,descripcion) VALUES('" + id + "','" + nombre + "','"
                    + descripcion + "')";
            st.execute(sql);
            st.close();
            connectionDB.close();
            messages.showMessage("se guardó correctamente");
        } catch (Exception e) {
            messages.showMessage("error al guardar...");
        }
    }

    public void show() {
        try {
            Connection connectionDB = conectar();
            st = connectionDB.createStatement();
            String sql = "SELECT * FROM superheroes";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Integer idFromDB = rs.getInt("id");
                String nameFromDB = rs.getString("nombre");
                String descripcionFromDB = rs.getString("descripcion");
                messages.showMessage("id: " + Integer.toString(idFromDB));
                messages.showMessage("nombre: " + nameFromDB);
                messages.showMessage("descripcion: " + descripcionFromDB);
            }
            rs.close();
            st.close();
            connectionDB.close();
        } catch (Exception e) {
            messages.showMessage("error al mostrar los superheroes");
        }
    }

    public void update(Integer id, String name, String description) {
        try {
            Connection connectionDB = conectar();
            st = connectionDB.createStatement();
            String sql = "UPDATE superheroes set nombre= '" + name + "',descripcion= '" + description + "' where id= '"
                    + id + "' ";
            st.executeUpdate(sql);
            messages.showMessage("se actualizó correctamente");
            st.close();
            connectionDB.close();
        } catch (Exception e) {
            messages.showMessage("error al actualizar el superheroe");
        }
    }

    public void delete(Integer id) {
        try {
            Connection connectionDB = conectar();
            st = connectionDB.createStatement();
            String sql = "DELETE FROM superheroes where id='" + id + "' ";
            st.executeUpdate(sql);
            st.close();
            connectionDB.close();
            messages.showMessage("eliminado correctamente");
        } catch (Exception e) {
            messages.showMessage("error al borrar");
        }
    }
}
