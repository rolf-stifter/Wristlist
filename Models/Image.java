public class Image {
    public String imageType;
    public String format;
    public String url;
    public String altText;
    public Double galleryIndex;

    //region Getters and Setters
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public Double getGalleryIndex() {
        return galleryIndex;
    }

    public void setGalleryIndex(Double galleryIndex) {
        this.galleryIndex = galleryIndex;
    }
    //endregion
}