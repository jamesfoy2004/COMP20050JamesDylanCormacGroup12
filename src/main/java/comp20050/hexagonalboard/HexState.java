package comp20050.hexagonalboard;

import java.io.Serializable;

/**
 * Represents the possible states of a hexagon on the game board.
 * <ul>
 *     <li>{@code OFF} - The hexagon is unclaimed.</li>
 *     <li>{@code PLAYER1} - The hexagon is claimed by Player 1.</li>
 *     <li>{@code PLAYER2} - The hexagon is claimed by Player 2.</li>
 * </ul>
 *
 * Implements {@link Serializable} to support saving and loading game state.
 */
public enum HexState implements Serializable {
    OFF, PLAYER1, PLAYER2
}
