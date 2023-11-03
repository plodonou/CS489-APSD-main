package edu.miu;

import edu.miu.model.Customer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World Docker!" );
        var customers = List.of(
                new Customer(101, "Dave Degea"),
                new Customer(102, "Bruno Fernandez")
        );
        customers.forEach(System.out::println);
    }
}
