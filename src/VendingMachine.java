import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

// 3. Создали класс VendingMachine
    protected List<Product> localList= new ArrayList<Product>();
// 4. Создали защищённый лист локаллист КЛАССА product!!!
    public List<Product> getLocalList() {
        return localList;
// 5. Создали Геттер для этого локаллиста, тоже класса Product
    }
//    private Double cash; //если есть возможность писать приметивы (double), то лучше их писать чем (Double)
    private double cash;

// 28. cоздали класс деньги

    public VendingMachine addProduct(Product InputProduct){
        localList.add(InputProduct);
// 18. Теперь нам нужно добавить сюда дату, чтобы когда мы загружаем товар в неё, мы фиксировали дату.
        InputProduct.setLoadDate(Date.valueOf(LocalDate.now()));
// в скобках прописали метод запроса даты, который нам предложил IDEA(можно было поискоть в инете).
        return this;
// 6. Создали в КЛАССЕ VendingMashine метод (Эддер), который принимает на вход
// переменную класса product и добавляет в локал лист то, что принял на вход
// что значит return this я пока не понял
    }

// 9. Делаем вывод :
// - переназначаем toString - создаём стрингбилдер "локалстринг" и закидываем в него каждый product из locallist

    @Override
    public String toString() {
        StringBuilder localString = new StringBuilder();
        for (Product product: localList){ // через foreach - у него форма записи (lля каждого product  в locallist)
            localString.append(product.toString()); //
            localString.append("\n");
        }
        localString.append(cash +"\n" );
        return localString.toString();
// !!! Строки в java, c# ... это immutable объекты (не изменяемые) - создали строчку "str" добавили "r" .
// Генерирует строчку str в виде объекта, потом создаёт строчку r в виде объекта. Потом создаёт ещё одну строчку,
// которую компанует из первой и второй. Получается экономия памяти, если у нас есть несколько строкок одинаковых
// то эти строки могут указывать на один объект памяти. Но получаются проблемы, если мы начинаем строки конкатинировать.
// А стрингбилдер лишён этого недостатка, т.к. он внутри себя эти строки компанует с помощью append,
// а потом когда мы делаем toString у стрингбилдера, то он компанует все строки, которые мы добавили.
// Смысл такой - если нужно строку много раз накопить(постоянно туда что-то добавлять, то лучше использовать стрингбилдер
// обязательно при использовании стрингбилдера приводим его к toString
    }

// 24. Хотим добавить поиск по наименованию. создадим метод find:
// 28. чтобы лучше был вывод, когда у нас несколько наименований содержит слово молоко,
// то мы создаём список:
    public List <Product> findProduct(String name) {
        List<Product> foundProduct = new ArrayList<>();
        // метод публичный public , возвращать он будет продукт Product, ищем по наименованию name (которая string)
        for (Product product : localList) {
            if (product.getName().contains(name)) {
// 25. На product у нас нет getName, по этому идём и создаём. Идём в product и где name через Generate создаём getName
                foundProduct.add(product); // поменяли return product;
            }
        }
        return foundProduct;  // поменяли return product;
// 26. Пока делаем return null, это не хорошо, но пока так
    }

// 27. Далее прописываем продажу и подсчёт выручки машины
    public Product sellProduct(Product sallingProduct){ //
        Product sellProduct = new Product();
        if (localList.contains(sallingProduct)){
            for (int i = 0; i < localList.size(); i++) {
                if (localList.get(i) == sallingProduct){
                    sellProduct = localList.get(i);
                    localList.remove(i);
                    cash += sellProduct.getCost(); // 32. делаем геттер
                    return sellProduct;
                }
            }
        }
        return sellProduct;
    }
}