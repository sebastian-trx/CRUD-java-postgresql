package org.example;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import org.example.crud.Crud;
import org.example.utils.DataHeroeFromApi;
import org.example.utils.Messages;

public class App {
    static Messages messages = Messages.getInstance();
    public static void main(String[] args) throws IOException {
        Crud prueba1 = new Crud();

        menu(prueba1);
    }

    public static void menu(Crud operacionesDB) throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            messages.showMessage("1. ingresar un heroe a la base de datos\n");
            messages.showMessage("2. mostrar heroes alojados en la DB\n");
            messages.showMessage("3. actualizar heroes\n");
            messages.showMessage("4. borrar heroes\n");
            messages.showMessage("5. Salir\n");

            try {
                messages.showMessage("Ingresa una de las opciones:\n");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        messages.showMessage("Ingresa el nombre del heroe:\n");
                        String nombre = sn.next();
                        DataHeroeFromApi hero = new DataHeroeFromApi(nombre);
                        operacionesDB.insert(hero.getId(), hero.getName(), "descripcion hardcodeada");
                        break;
                    case 2:
                        operacionesDB.show();
                        break;
                    case 3:
                        messages.showMessage("ingresa el id del heroe que quieres borrar\n");
                        Integer idU = sn.nextInt();
                        messages.showMessage("ingresa el nuevo nombre\n");
                        String name = sn.next();
                        messages.showMessage("ingresa la nueva descripcion\n");
                        String description = sn.next();
                        operacionesDB.update(idU, name, description);
                        break;
                    case 4:
                        messages.showMessage("ingresa el id del heroe que quieres borrar\n");
                        Integer id = sn.nextInt();
                        operacionesDB.delete(id);
                        break;
                    case 5:
                        sn.close();
                        salir = true;
                        break;
                    default:
                        messages.showMessage("Solo números entre 1 y 5\n");
                }
            } catch (InputMismatchException e) {
                messages.showMessage("ingrese una opcion correcta:\n");
                sn.next();
            }

        }
    }

}
