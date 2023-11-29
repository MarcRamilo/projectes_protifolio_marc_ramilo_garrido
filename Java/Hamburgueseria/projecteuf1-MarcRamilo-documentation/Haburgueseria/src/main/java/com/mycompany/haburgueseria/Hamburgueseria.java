/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.haburgueseria;


import java.util.Scanner;

/**
 *
 * @author Marc Ramilo Garrido 1rB DAW
 */
public class Hamburgueseria {

    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("--Benvinguts!!--");
        System.out.println("--Registret per poder accedir al web!--");
        System.out.println("------------------------------------------");
        Scanner entrada = new Scanner(System.in);
        int opcio = -1;//variable per escollir menu principal
        int submenu = -1;//variable per escollir submenu
        int compra = -1;//variable per escollir opcio compra
        int register = -1;
        String[][] dades = new String[10][10];//array per emegatzemar login Usuaris
        String[][] cistella = new String[3][10];
        String[][] aux = new String[10][10];//array auxiliar per passar dades
        int codi;
        int codiPostal = -1;
        int idUser = 0;//variable per incialitzar idUsuari
        int algunacosames = 1;
        
        String burguer, drink, pica;
        String[][] hamburgueses = {//Definicó de l'array HAMBURGUESES on despresa travès d'un id seleccionat agafarem la posició de i per a mostrar la opció
            {"1", "| Hamburguesa Clàssica |", " Descripcio: Deliciosa hamburguesa amb el clàssic sabor de la casa. Ingredients: Tomàquest, enciam, ceba caramelitzada, carn de vedella km0. ", " -Preu: 10,50€- "},
            {"2", "| Hamburguesa Carboni |", " Descripcio: Deliciosa hamburguesa amb el clàssic sabor de la casa. Ingredients: Tomàquest,pa de carbo, ceba flambejada, carn doble vedella km0. ", " -Preu: 12,50€- "},
            {"3", "| Hamburguesa Americana|", " Descripcio: Deliciosa hamburguesa de vedella madurada, amb cogombre, formatge,cansalada  ", " -Preu: 11,50€- "},
            {"4", "| Hamburguesa Blava|", " Descripcio: Deliciosa hamburguesa de vedella madurada, formatge blau,melmelada de cal moliné i ceba cruixent  ", " -Preu: 13,50€- "}};

        String[][] begudes = {//Definicó de l'array BEGUDES on despresa travès d'un id seleccionat agafarem la posició de i per a mostrar la opció
            {"5", "Tónica", " -", " -Preu: 1,90€-  "},
            {"6", "CocaCola", " -", " -Preu: 1,90€-  "},
            {"7", "Fanta", "-", " -Preu: 1,90€-  "},
            {"8", "Cervesa Estrella", " -", " -Preu: 2,10€-  "},
            {"9", "Cervesa Minera del Ripollès", " -", " -Preu: 3,50€-  "},
            {"10", "Aigua Mineral", "-", " -Preu: 1,50€-  "},
            {"11", "Aquarius", "-", " -Preu: 1,90€-  "}};
        String[][] picar = {//Definicó de l'array PER PICAR on despresa travès d'un id seleccionat agafarem la posició de i per a mostrar la opció
            {"12", "Braves", " Descripció: Patates braves cruixents, amb salsa picant ", " -4,00€-  "},
            {"13", "Aletes de pollastre picants", " Descripció: Aletes de pollastres marinades amb especies de la casa i picants", " -4,50€-  "},
            {"14", "Pilotilles", " Descripció: Pilotilles amb salsa de tomaquet, ceba, i verdures de temporades", " -3,50€-  "},};
        /*System.out.println(carta[0][0] + carta[0][1] + carta[0][2] + carta[0][3]);*/
        System.out.println("És la primera vagada que et registres?");
        System.out.println("SI=1, NO=2");
        while (!entrada.hasNextInt()) {
            System.out.println("Opció invalida! Introdueix un 1=Si o 2=No");
            System.out.println("És la primera vagada que et registres?");
            System.out.println("1=Si o 2=No");
            entrada.next();
        }
        register = entrada.nextInt();//Demanem quina opció vol escollir
        entrada.nextLine();
        do{
        switch (register) {
            case 1:

                System.out.println("Selecciona una opció");
                System.out.println("1.Insereix les teves dades");
                System.out.println("2. Sortir");
                opcio = entrada.nextInt();

                do {
                    switch (opcio) {
                        case 1://Usuaris introdueix les seves dades
                            System.out.println("Entra les teves dades...");
                            String x = entrada.nextLine();
                            for (int i = 0; i < 1; i++) {
                                idUser = idUser + 1;
                                String numCadena = Integer.toString(idUser);
                                System.out.println("idUser: " + idUser);
                                dades[i][0] = numCadena;
                                System.out.print("Nom: ");
                                dades[i][1] = entrada.nextLine();
                                System.out.print("Cognom: ");
                                dades[i][2] = entrada.nextLine();
                                System.out.print("CodiPostal: ");

                                while (!entrada.hasNextInt()) {
                                    System.out.println("Opció invalida! Introdueix un codi Postal");
                                  entrada.nextLine();
                                }
                                codiPostal = entrada.nextInt();
                                entrada.nextLine();
                                String codisString = Integer.toString(codiPostal);
                                dades[i][3] = codisString;
                                System.out.println("");

                                /*String codisString= Integer.toString(codi); //passem la variable del codi a string per poderla possars dins del array*/

 /* System.out.println(dades [i][j]);*/
                                System.out.printf("IdUser: %s, Nom complet: %s %s, CodiPostal: %s\n",
                                        dades[i][0], dades[i][1], dades[i][2], dades[i][3]);
                                System.out.println("");
                            }
                         /*   for (int i = 0; i < dades.length; i++) {
                                for (int j = 0; j < dades.length; j++) {
                                    System.out.println("DADES TOTAL: " + dades [i][j]);
                                }
                            }*/

                            //passem la variable del usuari a string per poderla possars dins del array
                            /*       aux = new String[dades.length + 1][dades[0].length];
                    //copiem totes les persones
                    for (int i = 0; i < dades.length; i++) {
                        for (int j = 0; j < dades[i].length; j++) {
                            aux[i][j] = dades[i][j];
                            System.out.println("aux: " + aux[i][j]);
                             System.out.println("dades " + dades[i][j]);
                        }
                    }
                    aux[aux.length - 1][0] = nom;
                    aux[aux.length - 1][1] = cognom;
                    aux[aux.length - 1][2] = codisString;
                    aux[aux.length - 1][3] = numCadena;
                    dades = aux;*/
 /*   System.out.println("Nom: " + nom + " Cognom: " + cognom + " CodiPostal: " + codi + " Id: " + numCadena);*/
                            break;
                        case 2:
                            System.out.println(" ");
                            System.out.println("Fins la propera!");
                            break;
                    }
                } while (opcio == 2);
                break;
            case 2:
                idUser = idUser + 1;
                String numCadena = Integer.toString(idUser);
                System.out.println("idUser: " + idUser);
                System.out.print("Nom: ");
                String x = entrada.nextLine();
                String nom = entrada.nextLine();
                System.out.print("Cognom: ");
                String cognom = entrada.nextLine();
                System.out.print("CodiPostal: ");
                while (!entrada.hasNextInt()) {
                    System.out.print("CodiPostal: ");
                    System.out.println("Has d'intoduir un codi postal en numeros");
                }
                codiPostal = entrada.nextInt();
                entrada.nextLine();
                String codisString = Integer.toString(codiPostal);
                System.out.println("");

                //passem la variable del usuari a string per poderla possars dins del array
                aux = new String[dades.length + 1][dades[0].length];
                //copiem totes les persones
                for (int i = 0; i < dades.length; i++) {
                    for (int j = 0; j < dades[i].length; j++) {
                        aux[i][j] = dades[i][j];
                        System.out.println("aux: " + aux[i][j]);
                        System.out.println("dades " + dades[i][j]);
                    }
                }
                aux[aux.length - 1][0] = numCadena;
                aux[aux.length - 1][1] = nom;
                aux[aux.length - 1][2] = cognom;
                aux[aux.length - 1][3] = codisString;
                dades = aux;
                System.out.println("Nom: " + nom + " Cognom: " + cognom + " CodiPostal: " + codisString + " Id: " + numCadena);
        }
        System.out.println("Entran a la pàgina comercial... ");
        try {
            //Pausem el programa durant els segons
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("1. Mostra la nostra CARTA!");
        System.out.println("2. Llista la CISTELLA");
        System.out.println("3. Comença la teva compra");
        System.out.println("4. Sortir!");
        System.out.println(" ");
        /*   System.out.print("\033[H\033[2J");  //neteja la pantalla terminal
        System.out.flush();  //neteja la pantalla del terminal*/
        while (!entrada.hasNextInt()) {
            System.out.println("Opció invalida!");
            System.out.println("1. Mostra la nostra CARTA!");
            System.out.println("2. Llista la CISTELLA");
            System.out.println("3. Comença la teva compra");
            System.out.println("4. Sortir!");
            System.out.println(" ");
            entrada.next();
        }
        submenu = entrada.nextInt();
        entrada.nextLine();
        do {

            switch (submenu) {
                case 1:
                    System.out.println(" ");
                    System.out.println("La nostra CARTA!");
                    System.out.println(" ");

                    System.out.println("-------------------------Hamburgueses--------------------");
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println(hamburgueses[i][j]);

                        }
                    }
                    System.out.println("----------------------Begudes-----------------------");
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println(begudes[i][j]);

                        }
                    }
                    System.out.println("-----------------------Per Picar---------------------");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println(picar[i][j]);

                        }
                    }
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("La teva CISTELLA!");
                    System.out.println(" ");

                    break;
                case 3:

                    System.out.println("Comença a comprar ");
                    System.out.println("1. Mostra la nostra CARTA!");
                    System.out.println("2. Llista la CISTELLA");
                    System.out.println("3. Selecciona un producte de la cistella");
                    System.out.println("4. Deseleciona un producte de la cistella");
                    System.out.println("5. Elimina el producte seleccionat");
                    System.out.println("6. Finalitza la compra");
                    System.out.println("7. Sortir!");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Opció invalida!");
                        System.out.println("Comença a comprar ");
                        System.out.println("1. Mostra la nostra CARTA!");
                        System.out.println("2. Llista la CISTELLA");
                        System.out.println("3. Selecciona un producte de la cistella");
                        System.out.println("4. Deseleciona un producte de la cistella");
                        System.out.println("5. Elimina el producte seleccionat");
                        System.out.println("6. Finalitza la compra");
                        System.out.println("7. Sortir!");
                        entrada.next();
                    }
                    compra = entrada.nextInt();
                    entrada.nextLine();
                    do {
                        switch (compra) {
                            case 1://Llista Carta
                                System.out.println("Hamburgueses");
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        System.out.println(hamburgueses[i][j]);

                                    }
                                }
                                System.out.println("Begudes");
                                for (int i = 0; i < 7; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        System.out.println(hamburgueses[i][j]);

                                    }
                                }
                                System.out.println("Per Picar");
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        System.out.println(hamburgueses[i][j]);

                                    }
                                }
                                break;
                            case 2://Llistar cistella
                                System.out.print("Mostra cistella");

                                break;

                            case 3://Seleccionar producte
                                if (algunacosames==1) {
                                    
                              
                                    System.out.print("Quin element vols seleccionar?");
                                    System.out.print("---------------------Hamburgeses---------------");
                                    System.out.print("Escull una hamburguesa");

                                    //llistem hamburguesas
                                    System.out.println("Hamburgueses");
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            System.out.println(hamburgueses[i][j]);

                                        }
                                    }
                                    //les selecionem

                                    System.out.println("Has de posar un número entre 1 i " + hamburgueses.length);
                                    burguer = entrada.nextLine();

                                    //Creem un nou array amb una posició més
                                    aux = new String[cistella.length + 1][cistella[0].length];
                                    //copiem totes les persones
                                    for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella[i].length; j++) {
                                            aux[i][j] = cistella[i][j];
                                        }
                                    }
                                    //posem les dades de la nova persona al final
                                    aux[aux.length - 1][0] = burguer;

                                    //copiem els valors de aux a persones
                                    cistella = aux;

                                    System.out.println("---------------------Seleccionat---------------");
                                      for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella.length; j++) {
                                            if(cistella[i][j]!=null)
                                             System.out.println("Seleccionats: " + cistella[i][j] );
                                        }
                                    }

                                    System.out.print("---------------------Begudes---------------");
                                    //llistem begudes
                                    System.out.println("Begudes");
                                    for (int i = 0; i < 7; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            System.out.println(begudes[i][j]);

                                        }
                                    }
                                    //selecionem una beguda
                                    System.out.print("Escull una beguda");

                                    System.out.println("Has de posar un número entre 1 i " + begudes.length);

                                    drink = entrada.nextLine();

                                    //Creem un nou array amb una posició més
                                    aux = new String[cistella.length + 1][cistella[0].length];
                                    //copiem totes les persones
                                    for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella[i].length; j++) {
                                            aux[i][j] = cistella[i][j];
                                        }
                                    }
                                    //posem les dades de la nova persona al final
                                    aux[aux.length - 1][0] = drink;

                                    //copiem els valors de aux a persones
                                    cistella = aux;

                                    System.out.println("---------------------Seleccionat---------------");
                                         for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella.length; j++) {
                                            if(cistella[i][j]!=null)
                                             System.out.println("Seleccionats: " + cistella[i][j] );
                                        }
                                    }
                                    System.out.print("---------------------Picar---------------");
                                    //llista per picar
                                    System.out.println("Per Picar");
                                    for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            System.out.println(picar[i][j]);

                                        }
                                    }

                                    //seleciona per picar
                                    System.out.print("Escull per picar");

                                    System.out.println("Has de posar un número entre 1 i " + picar.length);
                                    pica = entrada.nextLine();

                                    //Creem un nou array amb una posició més
                                    aux = new String[cistella.length + 1][cistella[0].length];
                                    //copiem totes les persones
                                    for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella[i].length; j++) {
                                            aux[i][j] = cistella[i][j];
                                        }
                                    }
                                    //posem les dades de la nova persona al final
                                    aux[aux.length - 1][0] = pica;

                                    //copiem els valors de aux a persones
                                    cistella = aux;

                                    System.out.println("---------------------Seleccionat---------------");
                                          for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella.length; j++) {
                                            if(cistella[i][j]!=null)
                                             System.out.println("Seleccionats: " + cistella[i][j] );
                                        }
                                    }
                                    System.out.println("------------------------------------------------");
                                     System.out.println("---------------------TOTAL-SELECIONATS---------------");
                                     for (int i = 0; i < cistella.length; i++) {
                                        for (int j = 0; j < cistella.length; j++) {
                                            if(cistella[i][j]!=null)
                                             System.out.println("Seleccionats: " + cistella[i][j] );
                                        }
                                    }
                                      
                                
                                  
                                    System.out.println("Vols demanar alguna cosa més?");
                                    System.out.println("1=Si o 2=No");
                                    algunacosames = entrada.nextInt();
                                 }
                               
                                break;
                            case 4://Deselecionar producte
                                System.out.print("Vols deseleccionar la selecció?");

                                break;
                            case 5://Eliminar producte de cistella
                                System.out.print("Vols eliminar el producte?");

                                break;
                            case 6://Finalitzar compra --> mostrar conta final, passar a fitxer txt
                                System.out.print("Finalitzar compra");
                                for (int i = 0; i < dades.length; i++) {
                                    for (int j = 0; j < dades.length; j++) {
                                        System.out.println(dades[i][j]);
                                    }

                                }
                                break;
                            case 7://Sortir
                                break;
                        }
                    } while (compra != 7);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("-----Gràcies per la seva visita fins aviat!-----");
                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("Sortint...");
                    try {
                        //Ponemos a "Dormir" el programa durante los ms que queremos
                        Thread.sleep(5 * 1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;

                default:
                    System.out.println("Opció incorrecta, has de seleccionar...");
                    System.out.println("1. Mostra la nostra CARTA!");
                    System.out.println("2. Llista la CISTELLA");
                    System.out.println("3. Comença la teva compra");
                    System.out.println("4. Sortir!");
                    break;

            }

        } while (submenu != 4);
       
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----Gràcies per la seva visita fins aviat!-----");
         }while(opcio!=7);
    }
}
