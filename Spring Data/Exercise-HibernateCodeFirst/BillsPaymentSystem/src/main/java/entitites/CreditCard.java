package entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {
    @Column(name = "card_type", nullable = false)
    private String cardType;
    @Column(name = "expiration_month", nullable = false)
    private String expirationMonth;
    @Column(name = "expiration_year", nullable = false)
    private short expirationYear;

    public CreditCard() {}

}
