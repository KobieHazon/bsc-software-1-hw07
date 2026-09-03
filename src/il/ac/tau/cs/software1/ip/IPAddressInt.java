package il.ac.tau.cs.software1.ip;

public class IPAddressInt implements IPAddress {
    private final int address;

    IPAddressInt(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return IPAddressUtils.format(this);
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
        int shift = (3 - index) * 8;
        return (address >>> shift) & 0xFF;
    }

    @Override
    public boolean isPrivateNetwork() {
        return IPAddressUtils.isPrivateNetwork(this);
    }
}
