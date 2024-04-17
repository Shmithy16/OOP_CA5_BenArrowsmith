package GamesObjects;

import java.util.List;
import java.util.Date;
import java.util.Collections;

import DAOs.MySqlGamesDao;
import DAOs.GamesDaoInterface;
import DTOs.Game;
import DTOs.gameTitleComparator;
import Exceptions.DaoException;
import JSON.JsonConverter;
import java.util.*;

public class App
{
    public static void main(String[] args)
    {
        boolean menu_open = true;

        GamesDaoInterface IUserDao = new MySqlGamesDao();

        try
        {
            //Ben
            while (menu_open) {

                System.out.println("[1] Press 1 to Display Entity by Id");
                System.out.println("[2] Press 2 to other");


                //input
                Scanner menu = new Scanner(System.in);
                int answer = menu.nextInt();

                //Ben
                if(answer==1) {
                    System.out.println("Enter ID: ");

                    Scanner options = new Scanner(System.in);
                    int newID = options.nextInt();

                    Game game = IUserDao.findGameByID(newID);

                    if( game != null ) { // null returned if userid and password not valid
                        String result = JsonConverter.gameToJson(game);
                        System.out.println("JSON convert" + result);
                    }
                    else
                        System.out.println("Game with that ID not found");
                }
                if(answer==2) {
                    menu_open = false;
                }
            }
            //Jiri
            System.out.println("\nCall findAllGames()");
            List<Game> games = IUserDao.findAllGames();

            if( games.isEmpty() )
                System.out.println("There are no Games");
            else {
                for (Game game : games)
                    System.out.println("User: " + game.toString());
            }

            //Ben
            System.out.println("\nCall findGameByID");
            int gameId = 110;

            Game game = IUserDao.findGameByID(gameId);

            if( game != null ) // null returned if userid and password not valid
                System.out.println("Game found: " + game);
            else
                System.out.println("Game with that ID not found");

            //Ben
            System.out.println("Sort by Title:");

            gameTitleComparator titleComparator = new gameTitleComparator();
            Collections.sort( games, titleComparator );
            display(games);

            //John
            System.out.println("\nCall deleteGameByID");
            int gameToDeleteId = 111;

            Game deletedGame = IUserDao.deleteGameByID(gameToDeleteId);

            if (deletedGame != null)
                System.out.println("Deleted Game: " + deletedGame);
            else
                System.out.println("No game to delete :<");
            //John
            System.out.println("\nCall insertGame");
            Game g = new Game(959, "bluhbluh", "99", 23, 473, new Date(364738274));
            IUserDao.insertGame(g);

            //Ben
            String result = JsonConverter.gamesToJson(games);
            System.out.println("JSON convert" + result);


            //Jiri
            IUserDao.updatePriceById(101, 50);

        }
        catch(DaoException e )
        {
            e.printStackTrace();
        }
    }
    //Ben
    public static void display(List<Game> games)
    {
        for (Game game: games) { System.out.println(game); }
    }
}

