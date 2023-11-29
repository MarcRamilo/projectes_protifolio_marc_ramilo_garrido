/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestocv0;

/*import static gestioestocv0.MainProgram.*;*/
import java.util.Scanner;

/**
 * Es troba el codi dels validadors que utilitza l'aplicació
 * 
 * @author Marc
 */
public class ValidadorComporvador {

    /**
     * Funcio per validar que s'introdueix un int per l'entrada del primer menu
     *
     * @param lector Scanner per llegir dades opcio
     * @param opcio int per seleccionar opcio de menu
     * @return retorna el valor de la opcio de menu
     */
    public static int ValidadorMenu(Scanner lector, int opcio) {

        while (!lector.hasNextInt()) {
            System.out.println("Selecciona una opció: ");
            System.out.println("1. Gestió d'Articles");
            System.out.println("2. Gestió d'Informes");
            System.out.println("0. Sortir");
            System.out.println("");
            lector.nextLine();
        }
        opcio = lector.nextInt();
        lector.nextLine();
        return opcio;
    }

    /**
     * Funcio per validar que s'introdueix un int per l'entrada del menu
     * principal
     *
     * @param lector Scanner per llegir dades opcio
     * @param opcio int per seleccionar opcio de menu
     * @return retorna el valor de la opcio de menu
     */
    public static int ValidadorMenuPrincipal(Scanner lector, int opcio) {

        while (!lector.hasNextInt()) {
            System.out.println("Selecciona una opció: ");
            System.out.println("1. Alta nou article"); // id automàtic, no ha d'existir un article amb el mateix nom
            System.out.println("2. Baixa d'article"); // no ha de tenir estoc per poder eliminar-lo
            System.out.println("3. Afegir unitats a un article");
            System.out.println("4. Eliminar unitats d'un article"); // no es poden quedar els articles en negatiu
            System.out.println("5. Llistar articles");
            System.out.println("0. Sortir");
            lector.nextLine();
        }
        opcio = lector.nextInt();
        lector.nextLine();
        return opcio;
    }

    /**
     * Funcio per validar que s'introdueix un int per l'entrada del menú
     * secundari
     *
     * @param lector Scanner per llegir dades opcio
     * @param opcio int per seleccionar opcio de menu
     * @return retorna el valor de la opcio de menu
     */
    public static int ValidadorMenuSecundari(Scanner lector, int opcio) {

        while (!lector.hasNextInt()) {
            System.out.println("1. Obtenir inventari complet"); // valorat amb un total
            System.out.println("2. Obtenir inventari d'una categoria"); //valorat amb un total
            System.out.println("3. Obtenir inventari ordenat per categories"); //amb valoració total per categories
            System.out.println("4. Obtenir tots els articles sense estoc");
            System.out.println("5. Obtenir articles amb import superior a 10");
            System.out.println("6. Obtenir articles amb import superior a 10 ordenat per categories");
            System.out.println("0. Sortir");
            lector.nextLine();
        }
        opcio = lector.nextInt();
        lector.nextLine();
        return opcio;
    }

    /**
     * Funcio per verificar les entrades integers per els identificadors de
     * categories
     *
     * @param lector Scanner per llegir dades
     * @param idCategoria identificador de les categories per validar que sigui
     * integer
     * @return
     */
    public static int ValidarIdInt(Scanner lector, int idCategoria) {
        while (!lector.hasNextInt()) {
            System.out.print("id Article: ");
            lector.nextLine();
        }
        idCategoria = lector.nextInt();
        lector.nextLine();
        return idCategoria;
    }

    /**
     *  * Funcio per verificar les entrades integers per els identificadors dels
     * articles
     *
     *
     * @param lector Scanner per llegir dades
     * @param idArticle identificador dels articles per validar que sigui
     * integer
     * @return
     */
    public static int ValididarArticleInt(Scanner lector, int idArticle) {
        System.out.print("id Article: ");
        while (!lector.hasNextInt()) {
            System.out.print("id Article: ");
            lector.nextLine();
        }
        idArticle = lector.nextInt();
        return idArticle;
    }

    /**
     * Funció per validar el valor doble del preu inserit
     *
     * @param lector Scanner per llegir dades
     * @param article array on es troben els articles i els seus camps
     * @param DoubleValid valor per verificar que el preu sigui doble
     * @return
     */
    public static double ValidarDouble(Scanner lector, String article[], Double DoubleValid) {
        while (!lector.hasNextDouble()) {
            System.out.println("Donam el preu de l'article");
            lector.nextLine();
        }
        DoubleValid = lector.nextDouble();
        lector.nextLine();
        return DoubleValid;
    }

    /**
     * Funció per validar el valor integer de la quantiat del producte inserit
     *
     * @param lector Scanner per llegir dades
     * @param article array on es troben els articles i els seus camps
     * @param Quantiat valor per verificar que la quiantiat sigui integer
     * @return
     */
    public static int ValidarInt(Scanner lector, String article[], int Quantiat) {
        while (!lector.hasNextInt()) {
            System.out.println("Donam la quantitat");
            lector.nextLine();
        }
        Quantiat = lector.nextInt();
        lector.nextLine();
        return Quantiat;
    }
/**
 * Funció per validar si existeix la categoria seleccionada
 * 
 * @param categories array on es troben les categories
 * @param existeixCategoria boolean per validar si existeix la categoria seleccionada
 * @param article array on es troben els articles i els seus camps
 * @return 
 */
    public static boolean ValidarCatgeriaExistent(String categories[][], boolean existeixCategoria, String article[]) {
        for (int i = 0; i < categories.length && !existeixCategoria; i++) {
            if (categories[i][0].equalsIgnoreCase(article[4])) {
                existeixCategoria = true;
            }
        }
        return existeixCategoria;
    }
/**
 * Funcio que serveix per validar el nom d'entrada dels productes
 * 
 * @param lector scanner per llegir dades
 * @param Nom string per validar el nom del producte
 * @return 
 */
    public static String ValidadorNom(Scanner lector, String Nom) {
        String comparar_nom = "[a-zA-Z0-9\s]+";
        System.out.println("Donam el nom de l'article");
        while (!Nom.matches(comparar_nom)) {
            System.out.println("Només pots posar lletres, numeros i espais en blanc");
            Nom = lector.nextLine();
            lector.nextLine();
        }
        return Nom;
    }
}
