package il.ac.tau.cs.software1.ip;

public class TestIPAddress {

	public static void main(String[] args) {
		int address1 = -1062731775; // 192.168.0.1
		short[] address2 = { 10, 1, 255, 1 }; // 10.1.255.1
		short[] address3 = { 5,5,5,5 }; // 10.1.255.1

		IPAddress ip1 = IPAddressFactory.createAddress(address1);
		IPAddress ip2 = IPAddressFactory.createAddress(address2);
		IPAddress ip3 = IPAddressFactory.createAddress("127.0.0.1");
		IPAddress ip4 = IPAddressFactory.createAddress("192.168.0.1");
		IPAddress ip5 = IPAddressFactory.createAddress(address3);


		for (int i = 0; i < 4; i++) {
			System.out.println(ip1.getOctet(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(ip2.getOctet(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(ip3.getOctet(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(ip4.getOctet(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(ip5.getOctet(i));
		}

		System.out.println("equals: " + ip1.equals(ip2));
		System.out.println("equals: " + ip1.equals(ip4));
		System.out.println("Is private Network: " + ip1.isPrivateNetwork());
		System.out.println("Is private Network: " + ip2.isPrivateNetwork());
		System.out.println("Is private Network: " + ip3.isPrivateNetwork());
		System.out.println("Is private Network: " + ip4.isPrivateNetwork());
		System.out.println("Is private Network: " + ip5.isPrivateNetwork());

	}
}
