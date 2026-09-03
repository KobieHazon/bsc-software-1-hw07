package il.ac.tau.cs.software1.ip;

final class IPAddressUtils {
    private IPAddressUtils() {
    }

    static int[] parse(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address must not be null");
        }
        String[] parts = address.split("\\.", -1);
        if (parts.length != 4) {
            throw new IllegalArgumentException("address must contain four octets");
        }
        int[] octets = new int[4];
        for (int i = 0; i < parts.length; i++) {
            try {
                octets[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid octet: " + parts[i], e);
            }
            validateOctet(octets[i]);
        }
        return octets;
    }

    static int[] fromShorts(short[] address) {
        if (address == null || address.length != 4) {
            throw new IllegalArgumentException("address must contain four octets");
        }
        int[] octets = new int[4];
        for (int i = 0; i < address.length; i++) {
            octets[i] = address[i];
            validateOctet(octets[i]);
        }
        return octets;
    }

    static String format(int[] octets) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < octets.length; i++) {
            if (i > 0) {
                builder.append('.');
            }
            builder.append(octets[i]);
        }
        return builder.toString();
    }

    static String format(IPAddress address) {
        int[] octets = new int[4];
        for (int i = 0; i < octets.length; i++) {
            octets[i] = address.getOctet(i);
        }
        return format(octets);
    }

    static boolean sameAddress(IPAddress left, IPAddress right) {
        if (right == null) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (left.getOctet(i) != right.getOctet(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrivateNetwork(IPAddress address) {
        int first = address.getOctet(0);
        int second = address.getOctet(1);
        return first == 10
                || (first == 172 && second >= 16 && second <= 31)
                || (first == 192 && second == 168)
                || (first == 169 && second == 254);
    }

    static int hashCode(IPAddress address) {
        int result = 1;
        for (int i = 0; i < 4; i++) {
            result = 31 * result + address.getOctet(i);
        }
        return result;
    }

    static void validateIndex(int index) {
        if (index < 0 || index > 3) {
            throw new IllegalArgumentException("index must be between 0 and 3");
        }
    }

    private static void validateOctet(int octet) {
        if (octet < 0 || octet > 255) {
            throw new IllegalArgumentException("octet must be between 0 and 255");
        }
    }
}
