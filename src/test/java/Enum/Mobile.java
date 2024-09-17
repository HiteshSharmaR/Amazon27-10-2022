package Enum;

public enum Mobile {
    searchInput("twotabsearchtextbox"),
    searchButton("nav-search-submit-button"),
    productTitle("a-row a-expander-container a-expander-inline-container"),
    colourAndVariant("a-button-text"),
    productColour("variation_color_name"),
    questionAndAnswer("a-autoid-49-announce"),
    variantDetail("twisterTextDiv text");

    private String title;

    Mobile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
