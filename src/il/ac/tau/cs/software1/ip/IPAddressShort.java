package il.ac.tau.cs.software1.ip;

public class IPAddressShort implements IPAddress {
    private final int[] address;

    IPAddressShort(short[] address) {
        this.address = IPAddressUtils.fromShorts(address);
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
