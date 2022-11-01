package ahmouny.me.microservice.service;

import ahmouny.me.microservice.dtos.AccountRequestDTO;
import ahmouny.me.microservice.dtos.AccountResponseDTO;

import java.util.List;


public interface AccountService {
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO);
    public List<AccountResponseDTO> getAccounts();
    public AccountResponseDTO getAccount(String id);
    public AccountResponseDTO update(AccountRequestDTO accountRequestDTO, String id);

    boolean deleteAccount(String id);
}
