import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int MAX_POINTS = 20;
    private static String GEOGRAPHY = "geografia";
    private static String SPORTS = "deportes";
    private static String MOVIES = "cine";
    private static String SERIES = "series";

    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;


    public static void main(String[] args) {

        List<Question> mixedQuestions = buildQuestionList();


        // Preguntar al jugador 1 cual es su nombre

        String namePlayer1 = askUserForName();

        // Crear el jugador 1 con el nombre que ha proporcionado el usuario e indicializar su puntuación a 0

        player1 = new Player(namePlayer1);

        // Preguntar al jugador 2 cual es su nombre

        String namePlayer2 = askUserForName();

        // Crear el jugador 2 con el nombre que ha proporcionado el usuario e indicializar su puntuación a 0

        player2 = new Player(namePlayer2);

        // empezamos la partida por el jugador 1
        currentPlayer = player1;
        System.out.println("Empieza el jugador " + currentPlayer.getName());

        //QUÉ ES LO QUE DEBE INCLUIR EL BUCLE:
        //hacerle la  al jugador
        //decirle respuesta
        //continuar con otra pregunta

        //mientras que queden preguntas y la puntuación sea inferior al máximo para ganar la partida

        // hacemos que el juego empiece por el jugador 1

        while (mixedQuestions.size() > 0 && currentPlayer.getPlayerPuntuation() < MAX_POINTS) {

            System.out.println("Te toca jugador " + currentPlayer.getName());

            //preguntarle al usuario la categoría que quiere responder
            String topicChoosen = askTheUserWichTopic();

            Question questionByTopic = selectQuestionByTopic(mixedQuestions, topicChoosen);

            if (questionByTopic != null) {
                playWithTheQuestion(questionByTopic);
            } else {
                System.out.println("Ya no quedan preguntas de esa temática, por favor selecciona otra");
            }

            // Alternar entre players
            switchPlayers();
        }

        //Mostramos las estadísticas
        printResult();
    }


    private static void printResult() { //Mostrar las puntuaciones de ambos jugadores

        System.out.println("Tu puntuación final es: " + player1.getPlayerPuntuation() + " Jugador " + player1.getName());
        System.out.println("Tu puntuación final es: " + player2.getPlayerPuntuation() + " Jugador " + player2.getName());

    }

    private static void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    private static String askUserForName() {
        System.out.println("Escribe su nombre, por favor ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return name;
    }

    private static void playWithTheQuestion(Question question) {
        //recupero de la question el texto y se lo muestro al usuario

        System.out.println(question.getStatement());

        //le digo al usuario que diga su respuesta

        System.out.println("Es verdadero o falso? T/F ");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.nextLine();

        //contrasto la respuesta y digo si es acertada o no

        boolean userChoice = userAnswer.equalsIgnoreCase("T");

        if (userChoice == question.isTrueOrFalse()) {
            //actualizo la puntuación
            int score = currentPlayer.getPlayerPuntuation() + question.getPuntuation();
            currentPlayer.setPlayerPuntuation(score);

            System.out.println("Has acertado!");
        } else System.out.println("Respuesta incorrecta");

    }

    private static Question selectQuestionByTopic(List<Question> mixedQuestions, String topicChoosen) {
        Question oneQuestion = null;
        for (int i = 0; i < mixedQuestions.size(); i++) {
            Question currentQuestion = mixedQuestions.get(i);
            if (currentQuestion.getTheme().equals(topicChoosen)) {
                oneQuestion = currentQuestion;
                mixedQuestions.remove(i);
            }
        }
        return oneQuestion;
    }


    private static String askTheUserWichTopic() {
        System.out.println(" Elige qué categoría de preguntas quieres responder: ");
        System.out.println(" 1. geografía / 2. deportes / 3. cine / 4. series ");
        Scanner sc = new Scanner(System.in);
        int topicChoosed = sc.nextInt();
        if (topicChoosed == 1) return GEOGRAPHY;
        else if (topicChoosed == 2) return SPORTS;
        else if (topicChoosed == 3) return MOVIES;
        else if (topicChoosed == 4) return SERIES;
        return null;
    }

    private static List<Question> buildQuestionList() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("La capital de Francia es Paris", true, 3, GEOGRAPHY));
        questions.add(new Question("La capital de Italia es Roma", true, 2, GEOGRAPHY));
        /*questions.add(new Question("La capital de Portugal es Lisboa", true, 4, GEOGRAPHY));
        questions.add(new Question("La capital de Alemania es Londres", false, 5, GEOGRAPHY));
        questions.add(new Question("La capital de Holanda es Bruselas", false, 5, GEOGRAPHY));*/

        questions.add(new Question("El Barça viste de azul y rojo", true, 2, SPORTS));
        questions.add(new Question("El Madrid viste de blanco y rojo", false, 2, SPORTS));
        /*questions.add(new Question("El Espanyol viste de rojo y amarillo", false, 2, SPORTS));
        questions.add(new Question("Tom Brady ha ganado 7 veces la SuperBowl", true, 5, SPORTS));
        questions.add(new Question("Valentino Rossi lleva el número 46", true, 3, SPORTS));*/

        questions.add(new Question("Titanic va sobre un barco que se hunde", true, 2, MOVIES));
        questions.add(new Question("La Loca Academia de Policía es de humor", true, 3, MOVIES));
        /*questions.add(new Question("El Jóker es el compañero de Batman", false, 3, MOVIES));
        questions.add(new Question("El trabajo de Spiderman es periodista", true, 4, MOVIES));
        questions.add(new Question("Shrek es de color granate", false, 2, MOVIES));*/

        questions.add(new Question("Steve Carrell es el protagonista de The Office", true, 4, SERIES));
        questions.add(new Question("The Big Bang Theory va sobre geólogos", false, 3, SERIES));
        /*questions.add(new Question("En Dos Hombres y Medio los protagonistas son 3 hombres y uno de ellos es acondroplásico", false, 4, SERIES));
        questions.add(new Question("Penny de The Big Bang Theory nació en Nebraska", true, 5, SERIES));
        questions.add(new Question("En Dos Chicas Sin Blanca trabajaban en una cafetería", true, 5, SERIES));*/

        return questions;
    }

}