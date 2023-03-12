package entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail {

    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(nullable = false)
    private String swift;

    public BankAccount() {}

}
