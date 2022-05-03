package bot.runescape.models.location;

import org.dreambot.api.methods.map.Area;


/**
 * Create a new Location which has different attribute.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.1.0
 */
public abstract class Location {
    private String name;
    private Area area;

    /**
     * Create a new Location.
     *
     * @param name The name of the location.
     * @param area The area where to go.
     */
    public Location(String name, Area area) {
        this.name = name;
        this.area = area;
    }

    /**
     * @return The name of that location.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The area of that location.
     */
    public Area getArea() {
        return area;
    }


    /**
     * Set the name of the location.
     *
     * @param name The name of that location.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the area of the location.
     *
     * @param area The area of that location.
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return All the information about that location.
     */
    @Override
    public String toString() {
        return this.name + " " + this.area;
    }
}
