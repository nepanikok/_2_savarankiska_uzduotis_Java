import java.util.Random;
public class GeoLocation {
    private double lat;
    private double lon;
    private static int numLocations = 0;
    public GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        numLocations++;
    }
    public GeoLocation() {
        this.lat = Math.random() * 180 - 90;
        this.lat = Math.round(this.lat * 1000000d) / 1000000d;
        this.lon = Math.random() * 180 - 90;
        this.lon = Math.round(this.lon * 1000000d) / 1000000d;
        numLocations++;
    }
    public GeoLocation(GeoLocation original) {
        this.lat = original.lat;
        this.lon = original.lon;
        Random random = new Random();
        this.lat += (random.nextDouble() * 0.1 - (-0.1)) + (-0.1);
        this.lon += (random.nextDouble() * 0.1 - (-0.1)) + (-0.1);
        this.lat = Math.round(this.lat * 1000000d) / 1000000d;
        this.lon = Math.round(this.lon * 1000000d) / 1000000d;
        numLocations++;
    }
    public void print() {
        System.out.println("[" + lat + ", " + lon + "]");
    }
    public static double distance(GeoLocation location1, GeoLocation location2) {
        final double EARTH_RADIUS = 6371.0;

        double lat1Rad = Math.toRadians(location1.lat);
        double lon1Rad = Math.toRadians(location1.lon);
        double lat2Rad = Math.toRadians(location2.lat);
        double lon2Rad = Math.toRadians(location2.lon);
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;
        distance = Math.round(distance * 10d) / 10d;
        return distance;
    }
    public static int getNumLocations() {
        return numLocations;
    }
}