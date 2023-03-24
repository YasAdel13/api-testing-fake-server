package Testing;
import UserApi.UserApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoClass.Users;
import pojoClass.fakeData.FakeData;
import pojoClass.fakeData.FakeData2;
import pojoClass.fakeData.Rooms;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class Testing {
    @Test(description = "should Be Able To Register")
    public void shouldBeAbleToRegister(){
            Users body = FakeData.register();
            Response response = UserApi.Register(body);
            assertThat(response.statusCode(),equalTo(201));
            assertThat(response.path("user.email"),equalTo(body.getEmail()));
            assertThat(response.path("user.firstName"),equalTo(body.getFirstName()));
            assertThat(response.path("accessToken"),not(equalTo(null)));
    }
    @Test(description = "should Be Not Able To Register")
    public void shouldBeNotAbleToRegister(){
        Users body = FakeData.canNotBeRegister();
        Response response = UserApi.Register(body);
        assertThat(response.statusCode(),equalTo(400));
        assertThat(response.body().prettyPrint(),equalTo("\"Email already exists\""));
    }

    @Test(description = "should Be Able To Login")
    public void shouldBeAbleToLogin(){
        Users body = FakeData.canNotBeRegister();
        Users body2 = new Users(body.getEmail(),body.getPassword());
       Response response = UserApi.login(body2);
       assertThat(response.statusCode(),equalTo(200));
        assertThat(response.path("user.firstName"),equalTo(body.getFirstName()));
        assertThat(response.path("accessToken"),not(equalTo(null)));
    }
    @Test(description = "should Be Not Able To Login")
    public void shouldBeNotAbleToLogin(){
        Users body = FakeData.canNotBeRegister();
        Users body2 = new Users(body.getEmail(),"123456");
        Response response = UserApi.login(body2);
        assertThat(response.statusCode(),equalTo(400));
        assertThat(response.body().prettyPrint(),equalTo("\"Incorrect password\""));
    }

    @Test(description = "should Be Able To Add New Room")
    public void shouldBeAbleToAddNewRoom(){
        Rooms room = FakeData2.GenerateRoom();
        String token = FakeData.getAccessToken();
       Response response = UserApi.addNewRoom(token,room);
        Rooms returnedRoom = response.body().as(Rooms.class);
          assertThat(response.statusCode(),equalTo(201));
          assertThat(returnedRoom.getType(),equalTo(room.getType()));

    }

     @Test(description = "should Be Not Able To Add New Room Using The Same Id")
    public void shouldBeNotAbleToAddNewRoomUsingTheSameId(){
         String token = FakeData.getAccessToken();
        Rooms room = FakeData2.sameId(token);
       Response response = UserApi.addNewRoom(token,room);
       assertThat(response.statusCode(),equalTo(500));

    }

    @Test(description = "should Be Able To Get All Room")
    public void shouldBeAbleToGetAllRoom(){
        String token = FakeData.getAccessToken();
        Response response =  UserApi.getRooms(token);
      assertThat(response.statusCode(),equalTo(200));


    }
    @Test(description = "should Be Able To Get Specific Room By Id")
    public void shouldBeAbleToGetSpecificRoomById(){

        String token = FakeData.getAccessToken();
        Rooms room = FakeData2.GenerateRoom();
        String roomId = FakeData2.generateRoomId(token,room);
       Response response =UserApi.getSpecifRoom(token,roomId);
        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.path("price"),equalTo(room.getPrice()));

    }
    @Test(description = "should Be Not Able To Get Specific Room Without Authentication")
    public void shouldBeNotAbleToGetSpecificRoomWithoutAuthentication(){

       Response response = UserApi.withoutAuthentication();
        assertThat(response.statusCode(),equalTo(401));

    }

    @Test(description = "should Be Able To Update")
    public void shouldBeAbleToUpdate(){
        Rooms room = FakeData2.GenerateRoom();
        Rooms room2 = new Rooms("1500");
        String token = FakeData.getAccessToken();
        String roomId = FakeData2.generateRoomId(token,room);
      Response response =  UserApi.update(token,room2,roomId);
        Rooms returnedRoom = response.body().as(Rooms.class);
        assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedRoom.getPrice(),equalTo(room2.getPrice()));
    }
    @Test(description = "should Be Able To Delete Room")
    public void shouldBeAbleToDeleteRoom(){
        String token = FakeData.getAccessToken();
        Rooms room = FakeData2.GenerateRoom();
        String roomId = FakeData2.generateRoomId(token,room);
       Response response = UserApi.delete(token,roomId);
        assertThat(response.statusCode(),equalTo(200));
    }






}
