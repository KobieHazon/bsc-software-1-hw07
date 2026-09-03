package il.ac.tau.cs.software1.ip;

public class IPAddressString implements IPAddress {
    private final int[] address;

    IPAddressString(String address) {
        this.address = IPAddressUtils.parse(address);
    }

    @Override
    public String toString() {
        return IPAddressUtils.format(address);
    }

    @Override
    public boolean equals(IPAddress other) {
        return IPAddressUtils.sameAddress(this, other);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IPAddress && equals((IPAddress) obj);
    }

    @Override
    public int hashCode() {
        return IPAddressUtils.hashCode(this);
    }

    @Override
    public int getOctet(int index) {
        IPAddressUtils.validateIndex(index);
        return address[index];
    }

    @Override
    public boolean isPrivateNetwork() {
        return IPAddressUtils.isPrivateNetwork(this);
    }
}
