package Models;

public class Places {

    private String id;
    private String category;
    private String places_list;

    /**Constructor*/
    public Places(String id, String category, String places_list) {
        this.id = id;
        this. category = category;
        this. places_list = places_list;
    }

    /**Metohds*/
    public String getId() { return this.id; }

    public String getCategory() { return this.category; }

    public String getPlacesList() { return this.places_list; }

    @Override
    public String toString() {
        return "Places: { id = " + this.id + " category = " + this.category + " places_list = " + this.places_list + " }";
    }

}
