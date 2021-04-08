package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener <ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        System.out.println("start initData");
        // Eric Evans Domain Driven Design
        Publisher springer = new Publisher("Springer", "5th Avenue", "New York", "NewYork", (short)2468);
        publisherRepository.save(springer);

        Author eric = new Author("Eric", "Evans");
        authorRepository.save(eric);

        Book ddd = new Book("Domain Driven Design", "123456");
        bookRepository.save(ddd);

        springer.getBooks().add(ddd);
        publisherRepository.save(springer);
        eric.getBooks().add(ddd);
        authorRepository.save(eric);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(springer);
        bookRepository.save(ddd);


        // Rod Johnson
        Author rod = new Author("Rod", "Johnson");
        authorRepository.save(rod);
        Book j2ee = new Book("J2EE Development without EJB", "13579");
        bookRepository.save(j2ee);
        rod.getBooks().add(j2ee);
        authorRepository.save(rod);
        j2ee.getAuthors().add(rod);
        j2ee.setPublisher(springer);
        bookRepository.save(j2ee);
        springer.getBooks().add(j2ee);
        publisherRepository.save(springer);


        System.out.println("Authors in DB: " + authorRepository.count());
        System.out.println("Books in DB: " + bookRepository.count());
        System.out.println("Publishers in DB: " + publisherRepository.count());
        System.out.println("Publisher " + springer.getName() + " published " + springer.getBooks().size() + " books.");
    }
}
