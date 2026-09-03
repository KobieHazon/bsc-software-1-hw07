package il.ac.tau.cs.software1.ip;

public class TestIPAddress {
    public static void main(String[] args) {
        int address1 = -1062731775;
        short[] address2 = {10, 1, 255, 1};
        short[] address3 = {5, 5, 5, 5};

        IPAddress ip1 = IPAddressFactory.createAddress(address1);
        IPAddress ip2 = IPAddressFactory.createAddress(address2);
        IPAddress ip3 = IPAddressFactory.createAddress("127.0.0.1");
        IPAddress ip4 = IPAddressFactory.createAddress("192.168.0.1");
        IPAddress ip5 = IPAddressFactory.createAddress(address3);

        printAddress(ip1);
        printAddress(ip2);
        printAddress(ip3);
        printAddress(ip4);
        printAddress(ip5);

        System.out.println("equals: " + ip1.equals(ip2));
        System.out.println("equals: " + ip1.equals(ip4));
        System.out.println("Is private Network: " + ip1.isPrivateNetwork());
        System.out.println("Is private Network: " + ip2.isPrivateNetwork());
        System.out.println("Is private Network: " + ip3.isPrivateNetwork());
        System.out.println("Is private Network: " + ip4.isPrivateNetwork());
        System.out.println("Is private Network: " + ip5.isPrivateNetwork());
    }

    private static void printAddress(IPAddress address) {
        for (int i = 0; i < 4; i++) {
            System.out.println(address.getOctet(i));
        }
    }
}
