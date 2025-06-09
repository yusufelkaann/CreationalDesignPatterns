package transport.model;

public class Driver implements Cloneable {
    private String name;
    private String licenseType;
    private boolean canDriveTrain;
    private boolean canDriveTanker;

    public Driver(String name, String licenseType, boolean canDriveTrain, boolean canDriveTanker) {
        this.name = name;
        this.licenseType = licenseType;
        this.canDriveTrain = canDriveTrain;
        this.canDriveTanker = canDriveTanker;
    }

    public String getName() {
        return name;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public boolean isCanDriveTrain() {
        return canDriveTrain;
    }

    public boolean isCanDriveTanker() {
        return canDriveTanker;
    }

    @Override
    public Driver clone() {
        try {
            return (Driver) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("CloneNotSupportedException thrown despite implementing Cloneable", e);
        }
    }
}