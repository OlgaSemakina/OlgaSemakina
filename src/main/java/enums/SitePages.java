package enums;

public enum SitePages {

    HOME_PAGE("https://epam.github.io/hw8JDI/index.html", "Home Page"),
    DIFFERENT_ELEMENTS_PAGE("https://epam.github.io/hw8JDI/different-elements.html", "Different Elements"),
    DATES_PAGE("https://epam.github.io/hw8JDI/dates.html", "Dates");

    public String url;
    public String title;

    SitePages(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
