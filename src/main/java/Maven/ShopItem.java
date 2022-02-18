package Maven;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ShopItem {
    private String category;
    private double price;
    private String name;
    private int count;
    private String ID;

    public ShopItem() {
    }


    public ShopItem(String category, double price, String name, int count) {
        this.category = category;
        this.price = price;
        this.name = name;
        this.count = count;
        this.ID = RandomStringUtils.randomAlphabetic(25);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        return new EqualsBuilder().append(price, shopItem.price).append(count, shopItem.count).append(category, shopItem.category).append(name, shopItem.name).append(ID, shopItem.ID).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(category).append(price).append(name).append(count).append(ID).toHashCode();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", ID='" + ID + '\'' +
                '}';
    }
}
