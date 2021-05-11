package nl.teuno.simplecalculator.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.rest.controllers.CalculatorController;
import nl.teuno.simplecalculator.rest.dtos.CalculationDto;
import nl.teuno.simplecalculator.services.CalculatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void givenAValidCalculationRequest_whenCallCalculationEndpoint_thenGet201() throws JsonProcessingException {
        CalculationDto calculation = new CalculationDto();
        calculation.setFirstNumber(1);
        calculation.setSecondNumber(1);
        calculation.setOperator("+");

        Calculation body = new Calculation();
        body.setId(1L);
        body.setFirstNumber(1);
        body.setSecondNumber(1);
        body.setOperator("+");
        body.setOutcome(2.0);

        Mockito.when(calculatorService.executeCalculation(isA(Calculation.class)))
                .thenReturn(body);

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(calculation))
                .when()
                .post("/api/calculations")
                .then()
                .statusCode(201)
                .body("id", Matchers.equalTo(1))
                .body("firstNumber", Matchers.equalTo(1))
                .body("secondNumber", Matchers.equalTo(1))
                .body("operator", Matchers.equalTo("+"))
                .body("outcome", Matchers.equalTo(2.0f));//for some reason json thinks the double is different. With f the check works.
    }

    @Test
    void givenAnInValidFirstParameterCalculationRequest_whenCallCalculationEndpoint_thenGet400() throws JsonProcessingException {
        CalculationDto calculation = new CalculationDto();
        calculation.setSecondNumber(1);
        calculation.setOperator("+");

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(calculation))
                .when()
                .post("/api/calculations")
                .then()
                .statusCode(400);
    }

    @Test
    void givenAnInValidSecondParameterCalculationRequest_whenCallCalculationEndpoint_thenGet400() throws JsonProcessingException {
        CalculationDto calculation = new CalculationDto();
        calculation.setFirstNumber(1);
        calculation.setOperator("+");

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(calculation))
                .when()
                .post("/api/calculations")
                .then()
                .statusCode(400);
    }

    @Test
    void givenAnInValidOperatorParameterCalculationRequest_whenCallCalculationEndpoint_thenGet400() throws JsonProcessingException {
        CalculationDto calculation = new CalculationDto();
        calculation.setFirstNumber(1);
        calculation.setSecondNumber(1);
        calculation.setOperator("");

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(calculation))
                .when()
                .post("/api/calculations")
                .then()
                .statusCode(400);
    }
}
