package Model;

import Controller.PlayerController;
import Model.Direction;
import Model.Player;

public class PlayerTest {
    public static void main(String[] args) throws Exception {
        try{
            Player player1 = new Player("blue",1, 2, Direction.DOWN );
            PlayerController pc = new PlayerController((player1));
            pc.move(Direction.UP);
            pc.move(Direction.UP);
            player1.setColor("green");
            System.out.printf("\nThe color of Model.Player 1's bike is: %s", player1.color);
            System.out.printf("\nCoords are %d, %d", player1.x, player1.y );
            System.out.printf("\nModel.Direction is: %s", player1.direction);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nwhatever");
        System.out.flush();
    }
}
