package bg.softuni.Battleships.model.dto;


import jakarta.validation.constraints.Positive;

public class BattleDTO {

    @Positive
    private Long attackerId;
    @Positive
    private Long defenderId;

    public Long getAttackerId() {
        return attackerId;
    }

    public BattleDTO setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public BattleDTO setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
