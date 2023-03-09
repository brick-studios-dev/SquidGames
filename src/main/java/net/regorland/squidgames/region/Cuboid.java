package net.regorland.squidgames.region;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
public class Cuboid {
    @Getter @Setter private Vector3 firstPoint;
    @Getter @Setter private Vector3 secondPoint;

    public Cuboid(Vector3 firstPoint, Vector3 secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }
    public Cuboid(Vector firstPoint, Vector secondPoint) {
        this.firstPoint = new Vector3(firstPoint);
        this.firstPoint = new Vector3(secondPoint);
    }
    public Cuboid(Location firstPoint, Location secondPoint) {
        this.firstPoint = new Vector3(firstPoint);
        this.firstPoint = new Vector3(secondPoint);
    }
    public boolean isBetween(double x, double z) {
        double x1 = this.firstPoint.getX();
        double z1 = this.firstPoint.getZ();

        double x2 = this.secondPoint.getX();
        double z2 = this.secondPoint.getZ();

        return ((x1 < x && x < x2) || (x1 > x && x > x2)) && ((z1 < z && z < z2) || (z1 > z && z > z2));
    }
    public boolean isBetween(Vector3 vector3) {
        return isBetween(vector3.getX(), vector3.getZ());
    }
    public boolean isBetween(Vector bukkitVector) {
        return isBetween(bukkitVector.getX(), bukkitVector.getZ());
    }
    public boolean isBetween(Location bukkitLocation) {
        return isBetween(bukkitLocation.getX(), bukkitLocation.getZ());
    }
    public List<Vector3> getVectorList() {
        List<Vector3> vector3List = new ArrayList<>();

        for (int x = (int) Math.min(firstPoint.getX(), secondPoint.getX()); x <= Math.max(firstPoint.getX(), secondPoint.getX()); x++) {
            for (int y = (int) Math.min(firstPoint.getY(), secondPoint.getY()); y <= Math.max(firstPoint.getY(), secondPoint.getY()); y++) {
                for (int z = (int) Math.min(firstPoint.getZ(), secondPoint.getZ()); z <= Math.max(firstPoint.getZ(), secondPoint.getZ()); z++) {
                    vector3List.add(new Vector3(x, y, z));
                }
            }
        }

        return vector3List;
    }
}
