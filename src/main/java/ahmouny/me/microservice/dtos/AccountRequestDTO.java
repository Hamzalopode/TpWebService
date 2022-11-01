package ahmouny.me.microservice.dtos;

import ahmouny.me.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;
}
