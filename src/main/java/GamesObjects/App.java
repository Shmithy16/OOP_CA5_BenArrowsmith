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

public class App
{
    public static void main(String[] args)
    {
        GamesDaoInterface IUserDao = new MySqlGamesDao();

        try
        {
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

            String result = JsonConverter.gameToJson(g);
            System.out.println(result);
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

