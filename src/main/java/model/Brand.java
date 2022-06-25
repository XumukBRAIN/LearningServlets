package model;

public class Brand {

    private int id;
    private String name;
    private String description;
    private String location;
    private int established;

    public Brand(){}

    public Brand(int id){
        this.id = id;
    }

    public Brand(int id, String name, String description, String location, int established){
        this(name, description, location, established);
        this.id = id;
    }

    public Brand(String name, String description, String location, int established) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.established = established;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEstablished() {
        return established = 0;
    }

    public void setEstablished(int established) {
        this.established = established;
    }
}
