package gulbozor.uz.core.exampleModels;

public class ExampleModel {
    private String imageUrl;
    private String flowerName;
    private String date;
    private int price;

    public ExampleModel() {
    }

    public ExampleModel(String imageUrl, String flowerName, String date, int price) {
        this.imageUrl = imageUrl;
        this.flowerName = flowerName;
        this.date = date;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExampleModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", flowerName='" + flowerName + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
