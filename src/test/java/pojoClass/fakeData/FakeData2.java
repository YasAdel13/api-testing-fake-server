package pojoClass.fakeData;

import UserApi.UserApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class FakeData2 {
    public static Rooms GenerateRoom(){
        Faker faker = new Faker();
        String id = faker.idNumber().valid();
        String type = faker.space().galaxy();
        String price = String.valueOf(faker.number().randomNumber());
        String Description = faker.book().title();

        Rooms room = new Rooms(id,type,price,Description);
        return room;
    }

    public static Rooms sameId(String token){
        Rooms room = GenerateRoom();
        UserApi.addNewRoom(token ,room);
        return room;
    }

    public static String generateRoomId(String token,Rooms room){
      //  Rooms room = GenerateRoom();
         Response response = UserApi.addNewRoom(token ,room);
         return response.body().path("id");
    }
}
