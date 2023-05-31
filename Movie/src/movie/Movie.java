/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movie;

/**
 *
 * @author PC PRAKTIKUM
 */
public class Movie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewMovie vm = new ViewMovie();
        ModelMovie model = new ModelMovie();
        new ControllerMovie(model, vm);
    }
    
}
