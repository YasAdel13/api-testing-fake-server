package pojoClass.fakeData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rooms {
@JsonProperty("id")
    private String id ;
@JsonProperty("type")
    private String type;
@JsonProperty("price")
    private String price;
@JsonProperty("Description")
    private String Description;

    public Rooms (){}

    public Rooms (String id,String type,String price,String description){
        this.id = id;
        this.type = type;
        this.price =price;
        this.Description = description ;
    }
    public Rooms (String id,String type,String description){
        this.id = id;
        this.type = type;
        this.Description = description ;
    }
    public Rooms (String price){
        this.price =price;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }
    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }
    @JsonProperty("Description")
    public void setDescription(String description) {
        Description = description;
    }



}
