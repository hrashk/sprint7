// импортируем RestAssured
import io.restassured.RestAssured;
// импортируем Before
import org.junit.Before;
// импортируем Test
import org.junit.Test;
// дополнительный статический импорт нужен, чтобы использовать given(), get() и then()
import static io.restassured.RestAssured.*;

public class PraktikumTest {

    // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    // создаём метод автотеста
    @Test
    public void getMyInfoStatusCode() {
        // метод given() помогает сформировать запрос
        given()
                // указываем протокол и данные авторизации
                .auth().oauth2("введи_сюда_свой_токен")
                // отправляем GET-запрос с помощью метода get, недостающую часть URL (ручку) передаём в него в качестве параметра
                .get("/api/users/me")
                // проверяем, что статус-код ответа равен 200
                .then().statusCode(200);
    }

}
