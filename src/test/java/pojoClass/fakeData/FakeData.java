package pojoClass.fakeData;

import UserApi.UserApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import pojoClass.Users;

public class FakeData {
    public static Users register(){
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        return new Users(firstName,lastName,email,password);
    }

    public static Users canNotBeRegister(){
        Users body = register();
        UserApi.Register(body);
        return body;
    }

    public static String getAccessToken(){
        Users body = register();
       Response response = UserApi.Register(body);
       return response.body().path("accessToken");
    }
}
