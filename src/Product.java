import java.util.Date;

public class Product {
// 1. Создали класс продукт
    private String name;

    private double cost;

    private Date loadDate = new Date();
// 17. Казалось бы мы должны добавить тогда  public Product и date как третий аргумент,
// но мы сделаем подругому - мы данную информацию будем подгружать при загрузке продукта в машину.
// Но чтобы всё работало нам ещё нужно добавить setter. Это тоже делаем через generate (правой кнопкой по loadDate)
// и выбираем по какому парамметру будет работать setter. В нашем случае по Date

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }
    public String getName() {
        return name;
    }

    public double getCost() { // 33. делаем геттер
        return cost;
    }
    public Product(){
// 31. "то мы делаем для того, чтобы вывел 0, если не сработает логика в 27.
        this("0",0);
    }

    @Override
    public String toString() {
        return String.format("наименование %s цена %f дата загрузки %s", name, cost, loadDate.toString());
// 2. первый наш полиморфизм - мы переписали для метода toString поведение вывода переменных name и cost

// 28. переназначаем equals , чтобы корректно у нас находило продукт по цене и по имени
    }

    @Override
    public boolean equals(Object obj) {
//        if (this.name.equals(((Product)obj).name)&& this.cost == (((Product)obj).cost))
//// 29. тут не можем написать this.name ==, т.к.
//// по скольку у obj нет name, а obj - это то что мы будем сравнивать(что будет подаваться аргументом,
//// по этому парамметр name мы берём из product.obj - т.е. обращаемся к родительскому классу
//// С cost другая история - это "приметив"(dddouble cost, а name - SSString name), по этому к нему можно применить "==" , а equals работать не будет.
//            return true;
//        return false;
// 30. Но тут сразу вместо использования if можно всё сразу запихнуть в return
        return (this.name.equals(((Product)obj).name) && this.cost == (((Product)obj).cost));
    }

    @Override
    public int hashCode() { // это почти уникальный код
        return name.hashCode() + (int)cost;
    }
}