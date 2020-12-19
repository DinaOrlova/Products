package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager manager;
    private Book TheBookThief = new Book(1, "Книжный вор", 300, "Маркус Зусак");
    private Book NightInLisbon = new Book(2, "Ночь в Лиссабоне", 350, "Эрих Мария Ремарк");
    private Book TimeToLiveAndTimeToDie = new Book(3, "Время жить и время умирать", 350, "Эрих Мария Ремарк");
    private Book PaddingtonBear = new Book(4, "Медвежонок Паддингтон", 500, "Бонд Майкл");
    private Smartphone RedmiNote9S = new Smartphone(1, "Redmi Note 9S", 15000, "XIAOMI");
    private Smartphone GalaxyA51 = new Smartphone(2, "Galaxy A51", 20000, "SAMSUNG");
    private Smartphone GalaxyM21 = new Smartphone(3, "Galaxy M21", 20000, "SAMSUNG");
    private Smartphone iPhone11 = new Smartphone(4, "iPhone 11", 60000, "APPLE");
    private Product ASICS = new Product(65, "Кроссовки ASICS", 5000);

    @Test
    void shouldSearchByAuthor() {
        Product[] returned = new Product[]{TheBookThief, NightInLisbon, TimeToLiveAndTimeToDie, PaddingtonBear, RedmiNote9S, GalaxyA51, GalaxyM21, iPhone11, ASICS};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Эрих Мария Ремарк");
        Product[] expected = new Product[]{NightInLisbon, TimeToLiveAndTimeToDie};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] returned = new Product[]{TheBookThief, NightInLisbon, TimeToLiveAndTimeToDie, PaddingtonBear, RedmiNote9S, GalaxyA51, GalaxyM21, iPhone11, ASICS};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Книжный вор");
        Product[] expected = new Product[]{TheBookThief};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] returned = new Product[]{TheBookThief, NightInLisbon, TimeToLiveAndTimeToDie, PaddingtonBear, RedmiNote9S, GalaxyA51, GalaxyM21, iPhone11, ASICS};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("SAMSUNG");
        Product[] expected = new Product[]{GalaxyA51, GalaxyM21};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product[] returned = new Product[]{TheBookThief, NightInLisbon, TimeToLiveAndTimeToDie, PaddingtonBear, RedmiNote9S, GalaxyA51, GalaxyM21, iPhone11, ASICS};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("iPhone 11");
        Product[] expected = new Product[]{iPhone11};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByWhenEmpty() {
        Product[] returned = new Product[]{TheBookThief, NightInLisbon, TimeToLiveAndTimeToDie, PaddingtonBear, RedmiNote9S, GalaxyA51, GalaxyM21, iPhone11, ASICS};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Гарри Поттер");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}