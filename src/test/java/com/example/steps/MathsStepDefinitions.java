package com.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.app.Calculator;
import com.example.app.pages.CalculatorPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MathsStepDefinitions {

    int a = 0;
    int b = 0;
    int total = 0;

    Calculator calculator = new Calculator();

    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("a is {int}")
    public void givenAIs(int value) {
        a = value;
    }

    @Given("b is {int}")
    public void givenBIs(int value) {
        b = value;
    }

    @When("I add a and b")
    public void iAddAAndB() {
        total = calculator.add(a,b);
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        assertThat(total).isEqualTo(expectedTotal);
    }

    @When("user input Numb1 is {int}")
    public void userInputNumb1Is(int Value1) {
        calculatorPage.InputNumb1(Value1);
    }

    @And("user choose operator {string}")
    public void userChooseOperator(String Op) {
        calculatorPage.clickDropdownBtn();
        calculatorPage.clickOpBtn(Op);
    }

    @And("user input numb2 is {int}")
    public void userInputNumbIs(int Value2) {
        calculatorPage.InputNumb2(Value2);
    }

    @And("user using operator2 =")
    public void userUsingOperator2() {
        calculatorPage.clickOp2();
    }

    @Then("verify the operator3 {int}")
    public void verifyTheOperator(int expectedResult) {
        int actualResult = Integer.parseInt(calculatorPage.getResult().replaceAll("Hasil : ", ""));
        assertThat(expectedResult).isEqualTo(actualResult);
    }

    @When("user input Numb1 is {string}")
    public void userInputNumbIs(String spchar) {
       calculatorPage.InputNumb1Spchar(spchar);
    }

    @Then("back to list app")
    public void backToListApp() {

    }

    @When("user does not input all field")
    public void userDoesNotInputAllField() {
    }

    @And("user input numb2 is {string}")
    public void userInputNumb2Is(String Angka) {
        calculatorPage.InputNumb2char(Angka);
    }
}
