package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    @OneToOne
    private Team homeTeam;
    @OneToOne
    private Team awayTeam;
    @Column(name = "home_goals")
    private byte homeGoals;
    @Column(name = "away_goals")
    private byte awayGoals;
    @Column(name = "date_and_time_of_game")
    private Date dateAndTimeOfGame;
    @Column(name = "home_team_win_bet_rate")
    private double homeTeamWinBetRate;
    @Column(name = "away_team_win_bet_rate")
    private double awayTeamWinBetRate;
    @Column(name = "draw_game_bet_rate")
    private double drawGameBetRate;
    @ManyToOne
    private  Round round;
    @ManyToOne
    private Competition competition;

    public Game() {}

}
