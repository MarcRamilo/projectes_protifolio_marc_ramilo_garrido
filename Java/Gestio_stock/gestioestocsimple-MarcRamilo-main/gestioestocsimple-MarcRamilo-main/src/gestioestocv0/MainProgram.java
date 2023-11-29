/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestocv0;

import java.util.Scanner;

/**
 *
 * @author Marc
 */
/**
 * Es troba el codi principal on es redirigueix en funcions. S'inclouen tots els valors que s'utilitzen
 * 
 * @author Marc
 */
public class MainProgram {
        private static Scanner lector = new Scanner(System.in);
    //id_categoria, nom
     private static String[][] categories = {{"0", "Fontaneria"}, {"1", "Electricitat"}, {"2", "Pintura"}};
    //id_article, nom, preu, quantitat, id_categoria
      private static String[][] articles = {
        {"0", "aixeta dutxa", "22.45", "4", "0"},
        {"2", "maniga", "12.22", "0", "0"},
        {"4", "endoll doble", "3.45", "8", "1"},
        {"5", "cable toma-terra 5m", "8.79", "0", "1"},
        {"6", "bombeta led 15w", "2.99", "10", "1"},
        {"7", "15 litres blanc mate", "56.44", "4", "2"},
        {"8","5 litres barnis teka","21.3","3","2"}};
         private static int opcio = 0;
         private static int idArticle, idCategoria;
         private static int posicio = -1;
        private static  boolean sortir = false;
        private static  String nomCategoria = "";
        private static  boolean trobat = false;
        private static  boolean existeix = false;
        private static  int unitats = 0;
       private static   double subtotal = 0, total = 0, totalGeneral=0;
       private static String Nom ="";
      private static String[][] aux;
      private static Double DoubleValid;
      private static int Quantiat;
        
 /**
  * Estructura de menu amb swicth que permet escollir opcions de menu amb un do while que fa que es repeteixi fins que apretem 0 per finalitzar el programa.
  * 
  * @param args argument metode main
  */
    public static void main(String[] args) {

      
        do {
           
             opcio = GestioMenus.Index(opcio, lector);
            
    
            //AMPILACIÓ:
            //PODER GESTIONAR CATEGORIES
            switch (opcio) {
                case 1: //Menú principal 1. Gestió d'Articles
                 opcio = GestioMenus.MenuPrincipal(lector,opcio);
                    
                    switch (opcio) {
                        case 1: //Submenú G.Articles 1. Alta nou article
                           articles = GestioArticles.SubmenuAltaArticle(articles, lector, categories, aux,Nom,DoubleValid,Quantiat);
                            break;

                        case 2: //Submenú G.Articles 2. Baixa d'article

                          articles = GestioArticles.SubmenuBaixaArticles(posicio, nomCategoria, trobat, articles, categories, lector, idArticle, existeix, aux);
                            break;
                        case 3: //Submenú G.Articles 3. Afegir unitats a un article
                            articles = GestioArticles.SubmenuAfegirQuantiat(existeix, lector, unitats, articles, posicio, nomCategoria, idArticle);
                            break;
                        case 4: //Submenú G.Articles 4. Eliminar unitats d'un article

                            //Llistem tots els articles
                            GestioArticles.SubmenuEliminarQuantitat(existeix, lector, unitats, articles, posicio, nomCategoria, idArticle);

                            break;
                        case 5: //Submenú G.Articles 5. Llistar articles
                            GestioArticles.SubmenuLlistarArticles(nomCategoria, trobat, articles, categories);
                            break;
                        case 0:
                            System.out.println("Tornant al menú principal...");
                            break;
                        default:
                            System.out.println("Opció incorrecta...");
                    }
                    break;
                case 2: //Menú principal 2. Gestió d'Informes
               opcio = GestioMenus.MenuSecondari(lector,opcio);

                    switch (opcio) {

                        case 1: //Submenú G.Informes 1. Obtenir inventari complet
                            // valorat amb un total
                            GestioInformes.SubmenuInformeComplet(nomCategoria, trobat, unitats, opcio, articles, categories);
                            break;
                        case 2: //Submenú G.Informes2. Obtenir inventari d'una categoria
                            //valorat amb un total

                           GestioInformes.SubmenuInformeCatgeoria(categories, existeix, posicio, lector, idCategoria, opcio, unitats, articles);
                            break;
                        case 3: //Submenú G.Informes3. Obtenir inventari ordenat per categories
                            //amb valoració total per categories i general
                            GestioInformes.OrdenatCatgeoriaGeneral(idCategoria, categories, unitats, opcio, articles);
                            break;
                        case 4: //Submenú G.Informes4. Obtenir tots els articles sense estoc                        
                            
                          GestioInformes.SubmenuSenseStoc(articles, idCategoria, trobat, categories, posicio);

                            break;
                        case 5: //Submenú G.Informes5. Obtenir articles amb import superior a 10
                            GestioInformes.SubmenuSuperior10(articles, idCategoria, trobat, categories, posicio);

                            break;
                        case 6: //Submenú G.Informes6. Obtenir articles amb import superior a 10 ordenat per categories

                         GestioInformes.Superior10Categoria(categories, articles);

                            break;
                        case 0:
                            System.out.println("Tornant al menú principal...");
                            break;
                        default:
                            System.out.println("Opció incorrecta...");
                    }
                    break;
                case 0: //Menú principal 0. Sortir
                    System.out.println("Adéu...");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció incorrecta...");
            }

        } while (!sortir);
    }
}

