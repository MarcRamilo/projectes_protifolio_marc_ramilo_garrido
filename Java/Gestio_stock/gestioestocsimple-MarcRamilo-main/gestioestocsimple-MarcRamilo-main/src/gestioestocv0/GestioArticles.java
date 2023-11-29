/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioestocv0;

import java.util.Scanner;

;

/*import static gestioestocv0.MainProgram.*;*/
/**
 * Es troba la gestio general del codi per poder gestionar els articles 
 *
 * @author Marc
 */
public class GestioArticles {

    /**
     * Menu que permet afegir articles al array articles, inserint els camps
     * nom, preu,quantiat i categoria
     *
     * @param articles array on guardem les dades dels articles
     * @param lector serveix per llegir dades
     * @param categories array on guardem les categories
     * @param aux array auxiliar per passar les dades per redimensionar-lo,
     * passar dades
     * @param Nom valida el camp de nou amb un regex
     * @param DoubleValid valida el nombre doble pel camp preu
     * @param Quantiat valida el nombre de quantitat
     * @return
     */
    public static String[][] SubmenuAltaArticle(String articles[][], Scanner lector, String categories[][], String aux[][], String Nom, Double DoubleValid, int Quantiat) {
        System.out.println("submenu 1.1");

        String[] article = new String[5];

        if (articles.length == 0) {
            article[0] = "0";
        } else {
            article[0] = String.valueOf(Integer.parseInt(articles[articles.length - 1][0]) + 1);
        }

        Nom = ValidadorComporvador.ValidadorNom(lector, Nom);
        article[1] = Nom;
        boolean existeixArticle = false;
        do {
            //comprovem si ja existeix un article el nom de l'article
            for (int i = 0; i < articles.length && !existeixArticle; i++) {
                if (articles[i][0].equalsIgnoreCase(article[1])) {
                    existeixArticle = false;
                }
            }
            if (existeixArticle) {
                System.out.println("El nom d'article ja existeix");
                System.out.println("Donam un nou nom d'article");
                article[1] = lector.nextLine();
            }
        } while (existeixArticle);
        DoubleValid = ValidadorComporvador.ValidarDouble(lector, article, DoubleValid);
        article[2] = String.valueOf(DoubleValid);
        //validat que siga doble
        Quantiat = ValidadorComporvador.ValidarInt(lector, article, Quantiat); //validat que siga int
        article[3] = String.valueOf(Quantiat);
        System.out.println("A quina categoria pertany?");
        boolean existeixCategoria = false;
        do {
            //Llistem les categories
            System.out.printf("%-4s %15s\n", "id", "Categoria");
            System.out.printf("%20s\n", "--------------------");
            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%-4s %15s\n", categories[i][0], categories[i][1]);
            }
            article[4] = lector.nextLine(); //faltaria validar que és int

            //comprovem que existeix la categoria
            existeixCategoria = ValidadorComporvador.ValidarCatgeriaExistent(categories, existeixCategoria, article);
        } while (!existeixCategoria);

        //creem un nou array amb una posició més
        aux = new String[articles.length][articles[0].length];

        //copiem tots els valors
        for (int i = 0; i < articles.length; i++) {
            for (int j = 0; j < articles[0].length; j++) {
                aux[i][j] = articles[i][j];

            }
        }
        //afegim al final
        aux[aux.length - 1][0] = article[0];
        aux[aux.length - 1][1] = article[1];
        aux[aux.length - 1][2] = article[2];
        aux[aux.length - 1][3] = article[3];
        aux[aux.length - 1][4] = article[4];

        //Intercanviem valors
        articles = aux;
        return articles;
    }

    /**
     * Funcio per donar de baixa els articles
     *
     * @param posicio int per indicar la posicio que ocupa
     * @param nomCategoria string per indicar nom de la categoria
     * @param trobat boolean, serveix per verificar
     * @param articles array on guardem les dades dels articles
     * @param categories array on guardem les categories
     * @param lector Scanner serveix per llegir dades
     * @param idArticle int, serveix per seleccionar el id de l'article
     * @param existeix boolean que serveix per verificar el id de Article
     * @param aux array auxiliar per passar les dades per redimensionar-lo,
     * passar dades
     * @return retorna el array d'article
     */
    public static String[][] SubmenuBaixaArticles(int posicio, String nomCategoria, boolean trobat, String articles[][], String categories[][], Scanner lector, int idArticle, boolean existeix, String aux[][]) {
        posicio = -1;

        System.out.println("Selecciona un article per donar de baixa...");
        //Llistem els articles
        nomCategoria = "";
        trobat = false;
        System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");
        for (int i = 0; i < articles.length; i++) {
            for (int j = 0; j < categories.length && !trobat; j++) {
                if (categories[j][0].equalsIgnoreCase(articles[i][4])) {
                    nomCategoria = categories[j][1];
                    trobat = false;
                }
            }
            System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                    articles[i][0],
                    articles[i][1],
                    Double.parseDouble(articles[i][2]),
                    articles[i][3],
                    articles[i][4],
                    nomCategoria);
        }
        System.out.print("id Article: ");
        while (!lector.hasNextInt()) {
            System.out.print("id Article: ");
            lector.nextLine();
        }
        idArticle = lector.nextInt();
        System.out.println("");

        //comprovem que el idArticle existeix
        existeix = false;
        for (int i = 0; i < articles.length && !existeix; i++) {
            if (Integer.parseInt(articles[i][0]) == idArticle) {
                existeix = true;
                posicio = i;
            }

        }
        if (existeix) {
            //creem un nou array amb 1 posició menys
            aux = new String[articles.length + 1][articles[0].length];

            //copiem tots els elements
            for (int i = 0, j = 0; i < articles.length; i++) {
                if (i != posicio) {
                    aux[j][0] = articles[i][0];
                    aux[j][1] = articles[i][1];
                    aux[j][2] = articles[i][2];
                    aux[j][3] = articles[i][3];
                    aux[j][4] = articles[i][4];
                    j++;
                }
            }

            //intercanviem valors
            articles = aux;
        } else {
            System.out.println("No existeix cap article amb id: " + idArticle);
        }
        return articles;
    }

    /**
     * Funcio que serveix per afegir quantiat a un article determinat que
     * selecionem
     *
     * @param existeix boolean per verificar si existeix article
     * @param lector scanner per llegir dades
     * @param unitats int, per inserir quantiat que volem inserir
     * @param articles array d'article
     * @param posicio int per saber la posicio
     * @param nomCategoria string que serveix per saber nom categoria
     * @param idArticle id de l'article
     * @return retrona l'array d'article
     */
    public static String[][] SubmenuAfegirQuantiat(boolean existeix, Scanner lector, int unitats, String articles[][], int posicio, String nomCategoria, int idArticle) {

        //Llistem tots els articles
        SubmenuLlistarArticles(nomCategoria, existeix, articles, articles);
        System.out.print("id Article: ");
        idArticle = ValidadorComporvador.ValididarArticleInt(lector, idArticle);

        System.out.println("");

        //comprovem que el idArticle existeix
        existeix = false;

        for (int i = 0; i < articles.length && !existeix; i++) {
            if (Integer.parseInt(articles[i][0]) == idArticle) {
                existeix = true;
                posicio = i;
            }
        }

        if (existeix) {
            do {
                System.out.print("Indica el número d'unitats a afegir: ");
                while (!lector.hasNextInt()) {
                    System.out.print("Indica el número d'unitats a afegir: ");
                    lector.nextLine();
                }
                unitats = lector.nextInt();
                if (unitats <= 0) {
                    System.out.println("No pots afegir 0 unitats o unitats negatives...");
                }
                if (unitats > Integer.parseInt(articles[posicio][3])) {
                    System.out.println("No pots treure més unitats de les que hi ha");

                }
            } while (unitats <= 0);

            //Incrementem les unitats a l'article
            articles[posicio][3] = String.valueOf(Integer.parseInt(articles[posicio][3]) + unitats);

            //mostrem l'article
            System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");
            System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                    articles[posicio][0],
                    articles[posicio][1],
                    Double.parseDouble(articles[posicio][2]),
                    articles[posicio][3],
                    articles[posicio][4],
                    nomCategoria);
        } else {
            System.out.println("No existeix cap article amb id: " + idArticle);
        }
        return articles;
    }

    /**
     * Funcio per eliminar quanitat d'un article determinat
     *
     * @param existeix boolean per verificar si existeix article
     * @param lector scanner per llegir dades
     * @param unitats int, per inserir quantiat que volem inserir
     * @param articles array d'article
     * @param posicio int per saber la posicio
     * @param nomCategoria string que serveix per saber nom categoria
     * @param idArticle id de l'article
     *
     */
    public static void SubmenuEliminarQuantitat(boolean existeix, Scanner lector, int unitats, String articles[][], int posicio, String nomCategoria, int idArticle) {
        SubmenuLlistarArticles(nomCategoria, existeix, articles, articles);
        System.out.print("id Article: ");
        idArticle = ValidadorComporvador.ValididarArticleInt(lector, idArticle);
        System.out.println("");

        //comprovem que el idArticle existeix
        for (int i = 0; i < articles.length && !existeix; i++) {
            if (Integer.parseInt(articles[i][0]) == idArticle) {
                existeix = true;
                posicio = i;
            }
        }

        if (existeix) {
            do {
                System.out.print("Indica el número d'unitats a eliminar : ");
                while (!lector.hasNextInt()) {
                    System.out.print("Indica el número d'unitats a eliminar : ");
                    lector.nextLine();
                }
                unitats = lector.nextInt();
                if (unitats > Integer.parseInt(articles[posicio][3])) {
                    System.out.println("No pots treure més unitats de les que hi ha");

                }
            } while (unitats <= 0);

            //eliminar  les unitats a l'article
            articles[posicio][3] = String.valueOf(Integer.parseInt(articles[posicio][3]) - unitats);

            //mostrem l'article
            System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");
            System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                    articles[posicio][0],
                    articles[posicio][1],
                    Double.parseDouble(articles[posicio][2]),
                    articles[posicio][3],
                    articles[posicio][4],
                    nomCategoria);
        } else {
            System.out.println("No existeix cap article amb id: " + idArticle + " o aquest article no te unitats");
        }
    }
/**
 * 
 * @param nomCategoria string que serveix per saber nom categoria
 * @param trobat boolean que serveix per verificar la categoria 
 * @param articles array on es troben els articles
 * @param categories array on es troben les categories 
 */
    public static void SubmenuLlistarArticles(String nomCategoria, boolean trobat, String articles[][], String categories[][]) {
        nomCategoria = "";
        trobat = false;
        System.out.printf("%4s %25s %8s %10s %6s %15s\n", "id", "Nom", "Preu U.", "Quantitat", "idCat", "Categoria");
        for (int i = 0; i < articles.length; i++) {
            for (int j = 0; j < categories.length && !trobat; j++) {
                if (categories[j][0].equalsIgnoreCase(articles[i][4])) {
                    nomCategoria = categories[j][1];
                    trobat = false;
                }
            }
            System.out.printf("%4s %25s %8.2f %10s %6s %15s\n",
                    articles[i][0],
                    articles[i][1],
                    Double.parseDouble(articles[i][2]),
                    articles[i][3],
                    articles[i][4],
                    nomCategoria);
        }
        System.out.println("");

    }

}
