package UserApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Users;
import pojoClass.fakeData.Rooms;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static Response Register(Users body){
       return  given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
               .log().all()
                .body(body)
                .when().post("register")
                .then().log().all()
                .extract().response();
    }

    public static Response login (Users body2){
       return given().baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .body(body2)
                .when().post("login")
                .then().log().all()
                .extract().response();
    }

    public static Response addNewRoom(String token, Rooms room){
       return given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .body(room)
                .when().post("660/Rooms")
                .then().log().all()
                .extract().response();
    }

    public static Response getRooms(String token){
       return given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().get("660/Rooms")
                .then().log().all()
                .extract().response();
    }

    public static Response getSpecifRoom(String token,String roomId){
     return  given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().get("660/Rooms/" + roomId)
                .then().log().all()
                .extract().response();
    }

    public static Response withoutAuthentication(){
       return given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .when().get("660/Rooms/4")
                .then().log().all()
                .extract().response();
    }

    public static Response update(String token,Rooms room,String roomId){
       return  given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .body(room)
                .when().put("660/Rooms/" + roomId)
                .then().log().all()
                .extract().response();
    }

    public static Response delete(String token,String roomId){
      return  given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().delete("660/Rooms/"+roomId)
                .then().log().all()
                .extract().response();
    }
}
