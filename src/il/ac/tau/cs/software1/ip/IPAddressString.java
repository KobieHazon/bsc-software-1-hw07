package il.ac.tau.cs.software1.ip;

public class IPAddressString implements IPAddress {

	private String address;
	IPAddressString(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return address;
	}

	@Override
	public boolean equals(IPAddress other) {
		return other.toString().equals(this.toString());
	}

	@Override
	public int getOctet(int index) {
		String[] octetsStr = address.split("\\.");
		return Integer.parseInt(octetsStr[index]);
	}

	@Override
	public boolean isPrivateNetwork(){
		String[] octetsStr = address.split("\\.");
		int[] octetsInt = new int[4];
		for (int i = 0; i < 4; i++) {
			octetsInt[i] = Integer.parseInt(octetsStr[i]);
		}
		if (octetsInt[0] == 10 && (0 <= octetsInt[1] && octetsInt[1] <= 255) && (0 <= octetsInt[2] && octetsInt[2] <= 255) 
				&& (0 <= octetsInt[3] && octetsInt[3] <= 255)) {
			return true;
		}
		if (octetsInt[0] == 172 && (16 <= octetsInt[1] && octetsInt[1] <= 31) && (0 <= octetsInt[2] && octetsInt[2] <= 255) 
				&& (0 <= octetsInt[3] && octetsInt[3] <= 255)) {
			return true;
		}
		if (octetsInt[0] == 192 && octetsInt[1] == 168 && (0 <= octetsInt[2] && octetsInt[2] <= 255) 
				&& (0 <= octetsInt[3] && octetsInt[3] <= 255)) {
			return true;
		}
		if (octetsInt[0] == 169 && octetsInt[1] == 254 && (0 <= octetsInt[2] && octetsInt[2] <= 255) 
				&& (0 <= octetsInt[3] && octetsInt[3] <= 255)) {
			return true;
		}
		return false;
	}
	
}
