package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.my.worklife.system.subsystems.employment.contract.offer.system.domain.wish.salary;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class WishSalary {

    int amount;

    @NonNull
    Currency currency;

    boolean isNegotiable;

}
