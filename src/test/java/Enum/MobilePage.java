package Enum;

public enum MobilePage {
    samsungGalaxyM32("a-section aok-relative s-image-fixed-height","Samsung Galaxy M13 (Midnight Blue, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus"),
    mobileDetail("seeMoreDetailsLink","a-link-normal");
    private String title;
    private String value;

    MobilePage(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
