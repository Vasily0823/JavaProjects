package Maven;

import org.apache.commons.lang3.StringUtils;

public class MainTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addItem(new ShopItem("Хозтовары", 12.0, "Веник", 1));
        shop.addItem(new ShopItem("Хозтовары", 2.0, "Моющее средство", 10));
        shop.addItem(new ShopItem("Хозтовары", 5.0, "Перчатки", 15));
        shop.addItem(new ShopItem("Хозтовары", 51.0, "Дрель", 15));
        shop.addItem(new ShopItem("Еда", 23.0, "Пиво", 6));
        shop.addItem(new ShopItem("Еда", 4.0, "Хлеб", 24));
        shop.addItem(new ShopItem("Еда", 12.0, "Яблоко", 21));
        shop.addItem(new ShopItem("Еда", 51.0, "Вино", 11));
        shop.addItem(new ShopItem("Еда", 10.0, "Молоко", 5));
        shop.addItem(new ShopItem("Электроника", 132.0, "Телевизор", 10));

        shop.addComporator(ItemSorters::sortByCategory);
        shop.addComporator(ItemSorters::sortByTitle);
        shop.addComporator(ItemSorters::sortByPrice);
        shop.addComporator(ItemSorters::sortByQuantity);


        System.out.println("ID\t\t\tКатегория\t\t\tНаименование\t\t\tЦена\t\t\tОстаток");
        for(ShopItem item: shop.getSortedItems()){
            StringBuilder sb = new StringBuilder();
             sb.append( StringUtils.abbreviate(item.getID(), 10)).append("\t\t\t").
                     append(StringUtils.abbreviate(item.getCategory(),10)).append("\t\t\t").
                    append(StringUtils.abbreviate(item.getName(),10)).append("\t\t\t").
                     append(item.getPrice()).
                    append("\t\t\t").append(item.getCount());
             System.out.printf(sb+"\t\n");
        }
    }
}
