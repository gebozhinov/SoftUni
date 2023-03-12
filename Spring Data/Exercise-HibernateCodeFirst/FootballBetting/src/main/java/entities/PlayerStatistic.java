package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistic")
public class PlayerStatistic {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @Column(name = "scored_goals")
    private int scoredGoals;
    @Column(name = "player_assists")
    private int playerAssists;
    @Column(name = "minutes_played")
    private int minutesPlayed;


    public PlayerStatistic() {}
}
