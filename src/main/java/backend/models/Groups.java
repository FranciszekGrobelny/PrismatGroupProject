package backend.models;

public class Groups {
    private int id;
    private String name;
    private String description;
    private int maxNumberOfPlaces;

    public Groups(){}

    public Groups(String name, String description, int maxNumberOfPlaces) {
        this.name = name;
        this.description = description;
        this.maxNumberOfPlaces = maxNumberOfPlaces;
    }

    public Groups(int id, String name, String description, int maxNumberOfPlaces){
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxNumberOfPlaces = maxNumberOfPlaces;
    }

    public int getId(){return id;}

    public void setId(int anInt){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = this.name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = this.description;}

    public int getMaxNumberOfPlaces(){return maxNumberOfPlaces;}

    public void setMaxNumberOfPlaces(int maxNumberOfPlaces){this.maxNumberOfPlaces = this.maxNumberOfPlaces;}

    @Override
    public String toString() {
        return "Groups{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxNumberOfPlaces='" + maxNumberOfPlaces + '\'' +
                '}';
    }

}
