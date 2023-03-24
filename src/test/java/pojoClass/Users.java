package pojoClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class Users {
@JsonProperty("firstName")
    private String firstName;
@JsonProperty("lastName")
    private String lastName;
@JsonProperty("email")
    private String email;
@JsonProperty("password")
    private String password;
@JsonProperty("accessToken")
    private  String accessToken;
    @JsonProperty("id")
    private  String id;

    public Users (){

    }

    public Users (String firstName,String lastName,String email,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }
    public Users (String email,String password){
        this.email = email;
        this.password = password;

    }

    public Users (String firstName,String email,String password){
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }
    @JsonProperty("accessToken")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }




}