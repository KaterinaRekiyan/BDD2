package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.*;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static ru.netology.data.DataHelper.getFirstCardInfo;
import static ru.netology.data.DataHelper.getSecondCardInfo;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;


    @Дано("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(DataHelper.getAuthInfo());
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public static void veriyDashboardPage() {
        dashboardPage.DashboardPage();
    }





//    @Когда ("пользователь переводит {string} рублей с карты с номером {string} на свою 1 карту с главной страницы")
//    public void veriyTransferPage(long amount, String getSecondCardInfo) {
//        amount = 5000;
//        var firstCardInfo = getFirstCardInfo();
//        var secondCardInfo = getSecondCardInfo();
//        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
//        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);
//        var transferPage = dashboardPage.selectedCardToTransfer(secondCardInfo);
//        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardInfo);
//    }

//    @Тогда ("баланс его 1 карты из списка на главной странице должен стать \"15 000\" рублей")
//    var expectedBalanceFirstCard = 15000;
//    public void actualBalanceFirstCard() = dashboardPage.getCardBalance(firstCardInfo());

}
