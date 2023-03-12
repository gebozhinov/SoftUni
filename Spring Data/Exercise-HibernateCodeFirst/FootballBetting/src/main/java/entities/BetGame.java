package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @Id
    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Id
    @OneToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;
    @OneToOne
    @JoinColumn(name = "result_prediction")
    private ResultPrediction resultPrediction;

    public BetGame() {}
}
