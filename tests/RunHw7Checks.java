import il.ac.tau.cs.software1.bufferedIO.IBufferedWriter;
import il.ac.tau.cs.software1.bufferedIO.MyBufferedWriter;
import il.ac.tau.cs.software1.bufferedIO.MyFileWriter;
import il.ac.tau.cs.software1.ip.IPAddress;
import il.ac.tau.cs.software1.ip.IPAddressFactory;
import il.ac.tau.cs.software1.predicate.Book;
import il.ac.tau.cs.software1.predicate.ByAuthor;
import il.ac.tau.cs.software1.predicate.ByPrice;
import il.ac.tau.cs.software1.predicate.Discount;
import il.ac.tau.cs.software1.predicate.Product;
import il.ac.tau.cs.software1.predicate.SmartPhone;
import il.ac.tau.cs.software1.predicate.Store;
import il.ac.tau.cs.software1.predicate.Upgrade;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class RunHw7Checks {
    public static void main(String[] args) throws Exception {
        testPredicatesAndActions();
        testIpRepresentations();
        testBufferedWriter();
        System.out.println("All HW7 checks passed");
    }

    private static void testPredicatesAndActions() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Algorithms", 120, "Cormen"));
        books.add(new Book("Networks", 80, "Heller"));
        Store<Book> bookStore = new Store<>(books);

        checkDouble(200, Product.getTotalPrice(bookStore.getInventory()), "book total price");
        bookStore.transform(new ByAuthor('H'), new Discount(50));
        checkDouble(120, books.get(0).getPrice(), "nonmatching author price unchanged");
        checkDouble(40, books.get(1).getPrice(), "matching author discount applied");

        List<SmartPhone> phones = new ArrayList<>();
        phones.add(new SmartPhone("Alpha", 700, 1));
        phones.add(new SmartPhone("Beta", 300, 3));
        Store<SmartPhone> phoneStore = new Store<>(phones);
        phoneStore.transform(new ByPrice(500), new Upgrade());
        checkEquals(1, phones.get(0).getVersion(), "expensive phone version unchanged");
        checkEquals(4, phones.get(1).getVersion(), "cheap phone upgraded");

        String expected = String.format("Name: Algorithms%nPrice: 120.0%nName: Networks%nPrice: 40.0%n");
        checkEquals(expected, bookStore.getInventoryDescription(), "inventory description");
    }

    private static void testIpRepresentations() {
        IPAddress fromInt = IPAddressFactory.createAddress(-1062731775);
        IPAddress fromString = IPAddressFactory.createAddress("192.168.0.1");
        IPAddress fromShorts = IPAddressFactory.createAddress(new short[] {10, 1, 255, 1});

        checkEquals("192.168.0.1", fromInt.toString(), "integer address string");
        checkEquals(192, fromInt.getOctet(0), "integer first octet");
        checkEquals(1, fromInt.getOctet(3), "integer last octet");
        check(fromInt.equals(fromString), "integer and string representations compare equal");
        check(fromString.equals((Object) fromInt), "Object equality is consistent");
        checkEquals(fromInt.hashCode(), fromString.hashCode(), "equal addresses share hash code");

        checkEquals("10.1.255.1", fromShorts.toString(), "short-array address string");
        check(fromShorts.isPrivateNetwork(), "10/8 address is private");
        check(IPAddressFactory.createAddress("172.16.0.1").isPrivateNetwork(), "172.16/12 start is private");
        check(IPAddressFactory.createAddress("172.31.255.255").isPrivateNetwork(), "172.16/12 end is private");
        check(!IPAddressFactory.createAddress("172.32.0.1").isPrivateNetwork(), "172.32/12 outside range is public");
        check(IPAddressFactory.createAddress("169.254.10.20").isPrivateNetwork(), "169.254/16 address is private");
        check(!IPAddressFactory.createAddress("127.0.0.1").isPrivateNetwork(), "loopback is not listed as private by assignment contract");
    }

    private static void testBufferedWriter() throws IOException {
        File output = File.createTempFile("hw7-buffered-writer", ".txt");
        output.deleteOnExit();
        MyFileWriter fileWriter = new MyFileWriter(output);
        IBufferedWriter bufferedWriter = new MyBufferedWriter(fileWriter, 5);

        bufferedWriter.write("abc");
        checkEquals(0, fileWriter.getWritesCount(), "partial buffer is not flushed early");
        bufferedWriter.write("defghijkl");
        checkEquals(2, fileWriter.getWritesCount(), "full buffers are flushed during write");
        bufferedWriter.close();
        checkEquals(3, fileWriter.getWritesCount(), "close flushes final partial buffer");
        checkEquals("abcdefghijkl", Files.readString(output.toPath()), "buffered file content");

        boolean failed = false;
        try {
            bufferedWriter.write("after close");
        } catch (IOException expected) {
            failed = true;
        }
        check(failed, "writing after close fails");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }

    private static void checkDouble(double expected, double actual, String message) {
        if (Math.abs(expected - actual) > 1e-9) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
}
