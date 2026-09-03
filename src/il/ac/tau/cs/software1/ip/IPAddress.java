package il.ac.tau.cs.software1.ip;

public interface IPAddress {
    /**
     * Returns a string representation of the IP address, for example "192.168.0.1".
     */
    String toString();

    /**
     * Compares this IP address to another IP address abstraction.
     */
    boolean equals(IPAddress other);

    /**
     * Returns an octet by zero-based index from left to right.
     */
    int getOctet(int index);

    /**
     * Returns true for the private IPv4 ranges 10/8, 172.16/12, 192.168/16, and 169.254/16.
     */
    boolean isPrivateNetwork();
}
