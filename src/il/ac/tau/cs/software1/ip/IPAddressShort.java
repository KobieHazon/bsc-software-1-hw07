package il.ac.tau.cs.software1.ip;

public class IPAddressShort implements IPAddress {

	private short[] address;
	IPAddressShort(short[] address) {
		this.address = java.util.Arrays.copyOf(address, 4);
	}

	@Override
	public String toString() {
		String ret = "";
		for (short octet: address) {
			ret += String.format("%03d", octet) + ".";
		}
		return ret.substring(0, ret.length()-1);
	}

	@Override
	public boolean equals(IPAddress other) {
		return other.toString().equals(this.toString());
	}

	@Override
	public int getOctet(int index) {
		return address[index];
	}

	@Override
	public boolean isPrivateNetwork(){
		if (address[0] == 10 && (0 <= address[1] && address[1] <= 255) && (0 <= address[2] && address[2] <= 255) 
				&& (0 <= address[3] && address[3] <= 255)) {
			return true;
		}
		if (address[0] == 172 && (16 <= address[1] && address[1] <= 31) && (0 <= address[2] && address[2] <= 255) 
				&& (0 <= address[3] && address[3] <= 255)) {
			return true;
		}
		if (address[0] == 192 && address[1] == 168 && (0 <= address[2] && address[2] <= 255) 
				&& (0 <= address[3] && address[3] <= 255)) {
			return true;
		}
		if (address[0] == 169 && address[1] == 254 && (0 <= address[2] && address[2] <= 255) 
				&& (0 <= address[3] && address[3] <= 255)) {
			return true;
		}
		return false;
	}
	
}
