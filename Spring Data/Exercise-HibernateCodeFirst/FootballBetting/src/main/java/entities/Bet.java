package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {

    @Column(name = "bet_money")
    private BigDecimal betMoney;
    @Column(name = "date_and_time_of_bet")
    private Date dateAndTimeOfBet;
    @ManyToOne
    private User user;

    public Bet() {}
}
