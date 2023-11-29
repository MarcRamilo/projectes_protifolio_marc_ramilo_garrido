/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestocv0;

/*import static gestioestocv0.MainProgram.*;*/
import java.util.Scanner;

/**
 * Es troba la gestio general per configurar les funcions dels informes
 * 
 * @author Marc
 */
public class GestioInformes {

    /**
     * Funcio que serveix per llistar tipu informe tot lo que tenim en els
     * arrays
     *
     * @param nomCategoria string que serveix per saber nom categoria
     * @param trobat boolean que serveix per verificar si troba les dades de
     * categories
     * @param subtotal double, serveix per sumar el preu subtotal
     * @param total double, serveix per sumar el preu total de cada article
     * @param articles array on es troben els articles
     * @param categories array on es troben les categories
     * @return
     */
    public static String[][] SubmenuInformeComplet(String nomCategoria, boolean trobat, double subtotal, double total, String articles[][], String categories[][]) {

        nomCategoria = "";
        trobat = false;
        subtotal = 0;
        total = 0;
        System.out.printf("%4s %25s %8s %10s %6s %15s %8s\n",
                "id",
                "Nom",
                "Preu U.",
                "Quantitat",
                "idCat",
                "Categoria",
                "Subtotal");
        for (int i = 0; i < articles.length; i++) {
            trobat = false;
            for (int j = 0; j < categories.length && !trobat; j++) {
                if (categories[j][0].equalsIgnoreCase(articles[i][4])) {
                    nomCategoria = categories[j][1];
                    trobat = true;
                }
            }

            subtotal = (int) (Double.parseDouble(articles[i][2]) * Double.parseDouble(articles[i][3]));
            total = total + subtotal;

            System.out.printf("%4s %25s %8.2f %10s %6s %15s %8.2f\n",
                    articles[i][0],//id
                    articles[i][1],//Nom
                    Double.parseDouble(articles[i][2]),//Preu U.
                    articles[i][3],//Quantitat
                    articles[i][4],//idCat
                    nomCategoria,//Nom Categoria
                    subtotal);
        }
        System.out.printf("%73s: %7.2f\n", "Total", total);
        System.out.printf("");
        return articles;
    }
/**
 * Funcio que serveix per llistar tipu informe tot lo que tenim en els
 * arrays filtrat per categories
 * 
 * @param categories array on es troben les categories
 * @param existeix boolean que serveix per verificar que existeix la categoria 
 * @param posicio int per saber la posicio de la categoria
 * @param lector scanner per llegir dades
 * @param idCategoria identifcador de les categories
 * @param subtotal double, serveix per sumar el preu subtotal
 * @param total double, serveix per sumar el preu total de cada article
 * @param articles array on es troben els articles
 */
        public static void SubmenuInformeCatgeoria(String categories[][], boolean existeix, int posicio, Scanner lector, int idCategoria, double total, double subtotal, String articles[][]) {
        //Llistem les categories
        System.out.printf("%-4s %15s\n", "id", "Nom");
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%-4s %15s\n", categories[i][0], categories[i][1]);
        }

        System.out.print("Selecciona una categoria... ");
        idCategoria = ValidadorComporvador.ValidarIdInt(lector, idCategoria);

        //comprovem que el idCategoria existeix
        existeix = false;
        for (int i = 0; i < categories.length && !existeix; i++) {
            if (Integer.parseInt(categories[i][0]) == idCategoria) {
                existeix = true;
                posicio = i;
            }
        }
        if (existeix) {
            total = 0;
            subtotal = 0;
            System.out.println("id: " + idCategoria + " Nom: " + categories[posicio][1]);
            System.out.printf("%4s %25s %8s %10s %10s\n", "id", "Nom", "Preu U.", "Quantitat", "Subtotal");
            for (int i = 0; i < articles.length; i++) {
                if (Integer.parseInt(articles[i][4]) == idCategoria) {
                    subtotal = (Double.parseDouble(articles[i][2]) * Double.parseDouble(articles[i][3]));
                    total = total + subtotal;
                    System.out.printf("%4s %25s %8.2f %10s %10.2f\n",
                            articles[i][0], //idArticle
                            articles[i][1], //nom
                            Double.parseDouble(articles[i][2]), //preu unitari
                            articles[i][3],//quantitat  
                            subtotal);
                }
            }
            System.out.printf("%52s: %7.2f\n", "Total", total);
        } else {
            System.out.println("No existeix cap categoria amb id: " + idCategoria);
        }

    }
/**
 * Funcio que serveix per llistar tipu informe tot lo que tenim en els
 * arrays ordenat per categories
 * 
 * @param totalGeneral double que permet sumar el total més l'anterior
 * @param categories array on es troben les categories
 * @param total double que serveix per sumar el total
 * @param subtotal double que permet sumar el subtotal
 * @param articles array on es troben els articles
 */
    public static void OrdenatCatgeoriaGeneral(double totalGeneral, String categories[][], double total, double subtotal, String articles[][]) {

        totalGeneral = 0;
        for (int i = 0; i < categories.length; i++) {
            subtotal = 0;
            total = 0;
            System.out.println("id: " + categories[i][0] + " Nom: " + categories[i][1]);
            System.out.printf("%4s %25s %8s %10s %10s\n", "id", "Nom", "Preu U.", "Quantitat", "Subtotal");
            for (int j = 0; j < articles.length; j++) {
                if (categories[i][0].equalsIgnoreCase(articles[j][4])) {
                    subtotal = (Double.parseDouble(articles[j][2]) * Double.parseDouble(articles[j][3]));
                    total = total + subtotal;
                    totalGeneral = totalGeneral + total;

                    System.out.printf("%4s %25s %8.2f %10s %10.2f\n",
                            articles[j][0], //idArticle
                            articles[j][1], //nom
                            Double.parseDouble(articles[j][2]), //preu unitari
                            articles[j][3],//quantitat 
                            subtotal);

                }
            }
            //imprimim total de categoria
            System.out.printf("%52s: %7.2f\n", "Subtotal", total);
        }
        //imprimim total general
        System.out.println("");
        System.out.printf("%52s: %7.2f\n", "Total", totalGeneral);

    }
/**
 * * Funcio que serveix per llistar tipu informe tot lo que tenim en els
 * arrays sumant sense stoc
 * 
 * @param articles array on es troben els articles
 * @param idCategoria identificadors que tenen les categories
 * @param trobat boolean que permet verificar si hem trobat la categoria
 * @param categories array on tenim les categories
 * @param posicio int per posicionar-se en el array
 */
    public static void SubmenuSenseStoc(String articles[][], int idCategoria, boolean trobat, String categories[][], int posicio) {
        System.out.println("Articles sense estoc:");
        System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");

        for (int i = 0; i < articles.length; i++) {
            if (articles[i][3].equalsIgnoreCase("0")) {
                idCategoria = Integer.parseInt(articles[i][4]);
                //busquem la posició de la categoria per traure el nom
                trobat = false;
                for (int j = 0; j < categories.length && !trobat; j++) {
                    if (Integer.parseInt(categories[j][0]) == idCategoria) {
                        trobat = true;
                        posicio = j;
                    }
                }

                System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                        articles[i][0],//id
                        articles[i][1],//Nom
                        Double.parseDouble(articles[i][2]),//Preu U.
                        articles[i][3],//Quantitat
                        articles[i][4],//idCat
                        categories[posicio][1]);//Nom Categoria                   
            }
        }
    }
/**
 * Funcio que serveix per llistar tipu informe tot lo que tenim en els
 * arrays que siguin superior a 10 en stoc
 * 
 * @param articles array on tenim els articles
 * @param idCategoria identificador que tenen els articles
 * @param trobat boolean que permet verificar si troba la categoria
 * @param categories array on es troben les categories
 * @param posicio int que permet posicionar la categoria
 */
    public static void SubmenuSuperior10(String articles[][], int idCategoria, boolean trobat, String categories[][], int posicio) {

        for (int i = 0; i < articles.length; i++) {

            if (Double.parseDouble(articles[i][2]) > 10) { //import >10
                idCategoria = Integer.parseInt(articles[i][4]);
                //busquem la posició de la categoria per traure el nom
                trobat = false;
                for (int j = 0; j < categories.length && !trobat; j++) {
                    if (Integer.parseInt(categories[j][0]) == idCategoria) {
                        trobat = true;
                        posicio = j;
                    }
                }

                System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                        articles[i][0],//id
                        articles[i][1],//Nom
                        Double.parseDouble(articles[i][2]),//Preu U.
                        articles[i][3],//Quantitat
                        articles[i][4],//idCat
                        categories[posicio][1]);//Nom Categoria    
            }
        }
    }
/**
 * Funcio que serveix per llistar tipu informe tot lo que tenim en els
 * arrays que siguin superior a 10 en stoc i ordenat per categories
 * 
 * @param categories array on es troben les categories
 * @param articles  arry on es troben els articles
 */
    public static void Superior10Categoria(String categories[][], String articles[][]) {
        System.out.println("Articles amb import superior a 10 ordenat per categories:");

        for (int i = 0; i < categories.length; i++) {
            System.out.println("Categoria: " + categories[i][1]);
            System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");

            for (int j = 0; j < articles.length; j++) {
                if (categories[i][0].equalsIgnoreCase(articles[j][4])) {
                    if (Double.parseDouble(articles[j][2]) > 10) {
                        System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                                articles[j][0],//id
                                articles[j][1],//Nom
                                Double.parseDouble(articles[j][2]),//Preu U.
                                articles[j][3],//Quantitat
                                articles[j][4],//idCat
                                categories[i][1]);//Nom Categoria 
                    }
                }
            }
            System.out.println("");
        }
    }

}
