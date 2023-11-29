/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestocv0;

/*import static gestioestocv0.MainProgram.*;*/
/*import static gestioestocv0.MainProgram.*;*/
import java.util.Scanner;

/**
 *
 * Es troban els prints dels menus
 * @author Marc
 * 
 */
public class GestioMenus {
/** 
 * 
 * @param opcio serveix per obtenir el numero per seleccionar una opció
 * @param lector servei per llegir dades
 * @return retorna el valor d'opcio
 */
    public static int Index(int opcio, Scanner lector) {
        System.out.println("Selecciona una opció: ");
        System.out.println("1. Gestió d'Articles");
        System.out.println("2. Gestió d'Informes");
        System.out.println("0. Sortir");
        System.out.println("");
       
       opcio = ValidadorComporvador.ValidadorMenu(lector, opcio);
        return opcio;
    }
/** 
 * 
  * @param opcio serveix per obtenir el numero per seleccionar una opció
 * @param lector servei per llegir dades
 * @return retorna el valor d'opcio
 */
    public static int MenuPrincipal(Scanner lector, int opcio) {
        System.out.println("Selecciona una opció: ");
        System.out.println("1. Alta nou article"); // id automàtic, no ha d'existir un article amb el mateix nom
        System.out.println("2. Baixa d'article"); // no ha de tenir estoc per poder eliminar-lo
        System.out.println("3. Afegir unitats a un article");
        System.out.println("4. Eliminar unitats d'un article"); // no es poden quedar els articles en negatiu
        System.out.println("5. Llistar articles");
        System.out.println("0. Sortir");
        
       opcio = ValidadorComporvador.ValidadorMenuPrincipal(lector, opcio);
        return opcio;
    }
/**
 * 
 * @param opcio serveix per obtenir el numero per seleccionar una opció
 * @param lector servei per llegir dades
 * @return retorna el valor d'opcio
 */
    public static int MenuSecondari(Scanner lector, int opcio) {
        System.out.println("1. Obtenir inventari complet"); // valorat amb un total
        System.out.println("2. Obtenir inventari d'una categoria"); //valorat amb un total
        System.out.println("3. Obtenir inventari ordenat per categories"); //amb valoració total per categories
        System.out.println("4. Obtenir tots els articles sense estoc");
        System.out.println("5. Obtenir articles amb import superior a 10");
        System.out.println("6. Obtenir articles amb import superior a 10 ordenat per categories");
        System.out.println("0. Sortir");
        
    opcio = ValidadorComporvador.ValidadorMenuSecundari(lector, opcio);
    return opcio;
    }

   
}
