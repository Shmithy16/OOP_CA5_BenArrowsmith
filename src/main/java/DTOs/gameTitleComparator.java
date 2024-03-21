package DTOs;
import java.util.Comparator;

public class gameTitleComparator implements Comparator<Games>{
    public int compare(Games game1, Games game2)
    {
        return game1.getGameTitle().compareTo(game2.getGameTitle());
    }
}
