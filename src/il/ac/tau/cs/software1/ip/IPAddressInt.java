package il.ac.tau.cs.software1.ip;

public class IPAddressInt implements IPAddress {

	private int address;
	IPAddressInt(int address) {
		this.address = address;
	}
	
	private static int getByteValue(String newbyte) {
		return Integer.parseInt(new String(newbyte), 2);
	}
	private static String getByteString(int addr, int index) {
		char[] tmpBinary = Integer.toBinaryString(addr).toCharArray();
		char[] inBinary = new char[32];
		for (int i = inBinary.length - 1; i >= 0; i--) {
			if (i >= inBinary.length - tmpBinary.length) {
				inBinary[i] = tmpBinary[i - (inBinary.length - tmpBinary.length)];
			}
			else {
				inBinary[i] = '0';
			}
		}
		char[][] to4Parts = new char[4][8];
		int arrayCnt = 0;
		for (int i = 0; i < inBinary.length; i++) {
			if (i >= (arrayCnt+1)*8) {
				arrayCnt++;
			}
			to4Parts[arrayCnt][i - arrayCnt*8] = inBinary[i];
		}
		return new String(to4Parts[index]);
	}
	
	
	@Override
	public String toString() {
		return getOctet(0) + "." + getOctet(1) + "." + getOctet(2) + "." + getOctet(3);
	}

	@Override
	public boolean equals(IPAddress other) {
		return other.toString().equals(this.toString());
	}

	@Override
	public int getOctet(int index) {
		return getByteValue(getByteString(this.address, index));
	}

	@Override
	public boolean isPrivateNetwork(){
		if (getOctet(0) == 10 && (0 <= getOctet(1) && getOctet(1) <= 255) && (0 <= getOctet(2) && getOctet(2) <= 255) 
				&& (0 <= getOctet(3) && getOctet(3) <= 255)) {
			return true;
		}
		if (getOctet(0) == 172 && (16 <= getOctet(1) && getOctet(1) <= 31) && (0 <= getOctet(2) && getOctet(2) <= 255) 
				&& (0 <= getOctet(3) && getOctet(3) <= 255)) {
			return true;
		}
		if (getOctet(0) == 192 && getOctet(1) == 168 && (0 <= getOctet(2) && getOctet(2) <= 255) 
				&& (0 <= getOctet(3) && getOctet(3) <= 255)) {
			return true;
		}
		if (getOctet(0) == 169 && getOctet(1) == 254 && (0 <= getOctet(2) && getOctet(2) <= 255) 
				&& (0 <= getOctet(3) && getOctet(3) <= 255)) {
			return true;
		}
		return false;
	}
	
}
