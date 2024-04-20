package JSON;

import DTOs.Game;
import com.google.gson.Gson;

import java.util.List;

//Ben
public class JsonConverter{
    //Ben
    public static String gamesToJson(List<Game> game){

//            List<Game> games = new ArrayList<>();
//
//            Game gms = new Game(117, "Journey", "Thatgamecompany", 15, 4, new Date(2012 - 3 - 13));
//
//            games.add(gms);

        Gson gsonParser = new Gson();

        String jsonString = gsonParser.toJson(game);

        return jsonString;
    }
    //Ben
    public static String gameToJson(Game game){
        Gson gsonParser = new Gson();

        String jsonString = gsonParser.toJson(game);

        return jsonString;
    }
    //Jiri
    public static String convertEntityToJson(Game game, String key){
        Gson gsonParser = new Gson();
        String jsonString = gsonParser.toJson(game);

        String jsonEntity = "{" + "\"" + key + "\"" + ":" + "\"" + game.getGameTitle() + "\"" + "}";

        return jsonEntity;
    }
}
