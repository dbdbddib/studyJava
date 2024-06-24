package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathexam.BankApp.Account;
import com.studymavenspringboot.study001.mathexam.BankApp.AccountService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountServiceTests {
    @Test
    public void testAddAccount() {
        AccountService accountService = new AccountService();

        accountService.clear();
        accountService.addAccount("유병훈", "111-111", 20000);

        assertThat(accountService.size()).isEqualTo(1);

        Account find = accountService.findAccountByNumber("111-111");
        assertThat(find).isNotNull();
        assertThat(find.getName()).isEqualTo("유병훈");
        assertThat(find.getCurrent()).isEqualTo(20000);
    }

    @Test
    public void testDeposit() {
        AccountService accountService = new AccountService();
        accountService.addAccount("송주영", "111-111", 20000);
        accountService.addAccount("김준혁", "222-222", 30000);
        assertThat(accountService.size()).isEqualTo(2);

        boolean result = accountService.deposit("222-222", 10000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountByNumber("222-222");
        assertThat(find).isNotNull();
        assertThat(find.getCurrent()).isEqualTo(40000);

        Account find2 = accountService.findAccountByNumber("444-444");
        assertThat(find2).isNull();
    }

    @Test
    public void testWithdraw() {
        AccountService accountService = new AccountService();
        accountService.addAccount("김형주", "333-333", 40000);
        assertThat(accountService.size()).isEqualTo(1);

        boolean result = accountService.withdraw("333-333", 20000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountByNumber("333-333");
        assertThat(find).isNotNull();
        assertThat(find.getCurrent()).isEqualTo(20000);

        Account find2 = accountService.findAccountByNumber("555-555");
        assertThat(find2).isNull();

        boolean result2 = accountService.withdraw("333-333", 30000);
        assertThat(result2).isEqualTo(false);

        Account find3 = accountService.findAccountByNumber("333-333");
        assertThat(find3).isNotNull();
        assertThat(find3.getCurrent()).isEqualTo(20000);
    }


}