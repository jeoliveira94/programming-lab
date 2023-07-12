package com.ruemmai.webapps;

import com.ruemmai.webapps.transactions.Account;
import com.ruemmai.webapps.transactions.AccountRepository;
import com.ruemmai.webapps.transactions.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    @DisplayName(
            "Test the amount is transferred " +
            "from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() throws AccountNotFoundException {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findAccountById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findAccountById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(sender.getId(),destination.getId(),new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));

    }
}