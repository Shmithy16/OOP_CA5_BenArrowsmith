package JSON;

import DTOs.Game;
import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class JsonConverter{
    public static String gameToJson(Game game){

//            List<Game> games = new ArrayList<>();
//
//            Game gms = new Game(117, "Journey", "Thatgamecompany", 15, 4, new Date(2012 - 3 - 13));
//
//            games.add(gms);

            Gson gsonParser = new Gson();

            String jsonString = gsonParser.toJson(game);

            return jsonString;

    }
}
