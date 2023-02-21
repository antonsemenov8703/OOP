import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
// 7. Создали в main экземпляр класса VendingMachine
        machine.addProduct(new Product("Lays",100));
        machine.addProduct(new Product("Mars",70));
        machine.addProduct(new Product("Twix",70.99));
        machine.addProduct(new Product("Алёнка",90));
        machine.addProduct(new Product("Колокольчик",85));
// 8. Добавили продукт
// 19. Добавляем в машину молоко
        machine.addProduct(new Perishable("Молоко Бурёнка",85, new Date(2023,02,25)));
        machine.addProduct(new Perishable("Молоко Коровка",85, new Date(2023,02,25)));
        machine.addProduct(new Perishable("Молоко Василёк",85, new Date(2023,02,25)));
        machine.addProduct((new Drinks("Coca Cola", 100, 0.5)));

// 10. Выводим то, что мы сделали в вендингмашине
        System.out.println(machine);
        System.out.println("____________________________________");

// 27. Создаём вывод:
        System.out.println(machine.findProduct("Молоко"));
        System.out.println(machine.findProduct("Алёнка"));
        System.out.println(machine.findProduct("Пиво"));
        System.out.println("____________________________________");
        System.out.println("продан: " + machine.sellProduct(machine.findProduct("Twix").get(0)));
        System.out.println("____________________________________");
        System.out.println(machine);

    }
}
// 11. Далее мы хотим добавить класс скоропортящихся товаров. Создали для этого perishable