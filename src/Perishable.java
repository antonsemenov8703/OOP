import java.util.Date;

public class Perishable extends Product{
// 14. Мы добавляем "срок годности":
// date автоматически подтягивает импорт утил дата. Мы создали переменную
    private Date expireDate = new Date();
    //private Date loadDate = new Date();
// 16. а это должно быть в продукте, по этому перенесли это в Product



// 12. Чтобы этот класс унаследовал от класса product, то мы пишем extends
// 13. Правой кнопкой нажимаем на Perishable и выбираем generate сonstructor
    public Perishable(String name, double cost, Date expireDate) {
// 15. Добавили третий парамметр Date expireDate помимо родительского name и cost, добавили свой expireDate
        super(name, cost);
// 18. Cюда добавляем дату просрочки
        this.expireDate = expireDate; // т.е. мы обратились к expireDate в этом классе
        // и прировняли входные данные expireDate к нему
    }
// 20. Теперь помимо даты загрузки мы сделаем так, чтобы выводилась дата просрочки для молока
// При том можео вызвать еoString из super и добавить нашу дату
    @Override
    public String toString() {
        StringBuilder localString = new StringBuilder(super.toString());
// 21. Создали новую локал стринг формата стрингбилдер и сказали ей,
// что она принимает формат метода super.toString из родительского класса product
        localString.append(String.format(" годен до %s", expireDate.toString()));
// 22. А тут мы говорим, что в этол локал стринг мы добавили поля для дальнейшего вывода
// "годен до %s", expireDate в добавок к "наименование %s цена %f дата загрузки %s", name, cost, loadDate.toString()
        return localString.toString();
// 23. И возвращаем этот список с парамметрами для вывода, только поскольку
// это был стрингбилдер, то мы добавляем, что это надо перевести в строку.
    }
}
