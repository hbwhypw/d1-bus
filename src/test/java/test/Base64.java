package test;

import java.util.Arrays;

public class Base64 {
	private static final boolean devLineSep = true;
	private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
	private static final int[] IA = new int[256];

	static {
		Arrays.fill(IA, -1);
		for (int i = 0, iS = CA.length; i < iS; i++)
			IA[CA[i]] = i;
		IA['='] = 0;
	}

	public final static char[] encodeToChar(byte[] sArr) {
		return encodeToChar(sArr, devLineSep);
	}

	public final static char[] encodeToChar(byte[] sArr, boolean lineSep) {

		int sLen = sArr != null ? sArr.length : 0;
		if (sLen == 0)
			return new char[0];
		int eLen = (sLen / 3) * 3; // Length of even 24-bits.
		int cCnt = ((sLen - 1) / 3 + 1) << 2; // Returned character count
		int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0); // Length of
		char[] dArr = new char[dLen];
		for (int s = 0, d = 0, cc = 0; s < eLen;) {
			int i = (sArr[s++] & 0xff) << 16 | (sArr[s++] & 0xff) << 8 | (sArr[s++] & 0xff);

			dArr[d++] = CA[(i >>> 18) & 0x3f];
			dArr[d++] = CA[(i >>> 12) & 0x3f];
			dArr[d++] = CA[(i >>> 6) & 0x3f];
			dArr[d++] = CA[i & 0x3f];
			if (lineSep && ++cc == 19 && d < dLen - 2) {
				dArr[d++] = '\r';
				dArr[d++] = '\n';
				cc = 0;

			}

		}
		int left = sLen - eLen; // 0 - 2.
		if (left > 0) {
			int i = ((sArr[eLen] & 0xff) << 10) | (left == 2 ? ((sArr[sLen - 1] & 0xff) << 2) : 0);
			dArr[dLen - 4] = CA[i >> 12];
			dArr[dLen - 3] = CA[(i >>> 6) & 0x3f];
			dArr[dLen - 2] = left == 2 ? CA[i & 0x3f] : '=';
			dArr[dLen - 1] = '=';
		}
		return dArr;

	}

	public final static byte[] decode(char[] sArr) {

		int sLen = sArr != null ? sArr.length : 0;
		if (sLen == 0)
			return new byte[0];
		int sepCnt = 0; // Number of separator characters. (Actually illegal
		for (int i = 0; i < sLen; i++)
			if (IA[sArr[i]] < 0)
				sepCnt++;
		if ((sLen - sepCnt) % 4 != 0)
			return null;
		int pad = 0;
		for (int i = sLen; i > 1 && IA[sArr[--i]] <= 0;)
			if (sArr[i] == '=')
				pad++;
		int len = ((sLen - sepCnt) * 6 >> 3) - pad;
		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length
		for (int s = 0, d = 0; d < len;) {
			int i = 0;
			for (int j = 0; j < 4; j++) { // j only increased if a valid char
				int c = IA[sArr[s++]];
				if (c >= 0)
					i |= c << (18 - j * 6);
				else
					j--;
			}
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++] = (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}
		return dArr;
	}

	public final static byte[] decodeFast(char[] sArr) {
		int sLen = sArr.length;
		if (sLen == 0)
			return new byte[0];
		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.
		while (sIx < eIx && IA[sArr[sIx]] < 0)
			sIx++;

		// Trim illegal chars from end

		while (eIx > 0 && IA[sArr[eIx]] < 0)

			eIx--;

		// get the padding count (=) (0, 1 or 2)

		int pad = sArr[eIx] == '=' ? (sArr[eIx - 1] == '=' ? 2 : 1) : 0; // Count

		// '='

		// at

		// end.

		int cCnt = eIx - sIx + 1; // Content count including possible

		// separators

		int sepCnt = sLen > 76 ? (sArr[76] == '\r' ? cCnt / 78 : 0) << 1 : 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded

		// bytes

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.

		int d = 0;

		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {

			// Assemble three bytes into an int from four "valid" characters.

			int i = IA[sArr[sIx++]] << 18 | IA[sArr[sIx++]] << 12

			| IA[sArr[sIx++]] << 6 | IA[sArr[sIx++]];

			// Add the bytes

			dArr[d++] = (byte) (i >> 16);

			dArr[d++] = (byte) (i >> 8);

			dArr[d++] = (byte) i;

			// If line separator, jump over it.

			if (sepCnt > 0 && ++cc == 19) {

				sIx += 2;

				cc = 0;

			}

		}

		if (d < len) {

			// Decode last 1-3 bytes (incl '=') into 1-3 bytes

			int i = 0;

			for (int j = 0; sIx <= eIx - pad; j++)

				i |= IA[sArr[sIx++]] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)

				dArr[d++] = (byte) (i >> r);

		}

		return dArr;

	}

	// ****************************************************************************************

	// * byte[] version

	// ****************************************************************************************

	public final static byte[] encodeToByte(byte[] sArr) {

		return encodeToByte(sArr, devLineSep);

	}

	/**
	 * 
	 * Encodes a raw byte array into a BASE64 <code>byte[]</code>
	 * 
	 * representation i accordance with RFC 2045.
	 * 
	 * 
	 * 
	 * @param sArr
	 * 
	 *            The bytes to convert. If <code>null</code> or length 0 an
	 * 
	 *            empty array will be returned.
	 * 
	 * @param lineSep
	 * 
	 *            Optional "/r/n" after 76 characters, unless end of file.<br>
	 * 
	 *            No line separator will be in breach of RFC 2045 which
	 * 
	 *            specifies max 76 per line but will be a little faster.
	 * 
	 * @return A BASE64 encoded array. Never <code>null</code>.
	 * 
	 */

	public final static byte[] encodeToByte(byte[] sArr, boolean lineSep) {

		// Check special case

		int sLen = sArr != null ? sArr.length : 0;

		if (sLen == 0)

			return new byte[0];

		int eLen = (sLen / 3) * 3; // Length of even 24-bits.

		int cCnt = ((sLen - 1) / 3 + 1) << 2; // Returned character count

		int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0); // Length of

		// returned

		// array

		byte[] dArr = new byte[dLen];

		// Encode even 24-bits

		for (int s = 0, d = 0, cc = 0; s < eLen;) {

			// Copy next three bytes into lower 24 bits of int, paying attension

			// to sign.

			int i = (sArr[s++] & 0xff) << 16 | (sArr[s++] & 0xff) << 8

			| (sArr[s++] & 0xff);

			// Encode the int into four chars

			dArr[d++] = (byte) CA[(i >>> 18) & 0x3f];

			dArr[d++] = (byte) CA[(i >>> 12) & 0x3f];

			dArr[d++] = (byte) CA[(i >>> 6) & 0x3f];

			dArr[d++] = (byte) CA[i & 0x3f];

			// Add optional line separator

			if (lineSep && ++cc == 19 && d < dLen - 2) {

				dArr[d++] = '\r';

				dArr[d++] = '\n';

				cc = 0;

			}

		}

		// Pad and encode last bits if source isn't an even 24 bits.

		int left = sLen - eLen; // 0 - 2.

		if (left > 0) {

			// Prepare the int

			int i = ((sArr[eLen] & 0xff) << 10)

			| (left == 2 ? ((sArr[sLen - 1] & 0xff) << 2) : 0);

			// Set last four chars

			dArr[dLen - 4] = (byte) CA[i >> 12];

			dArr[dLen - 3] = (byte) CA[(i >>> 6) & 0x3f];

			dArr[dLen - 2] = left == 2 ? (byte) CA[i & 0x3f] : (byte) '=';

			dArr[dLen - 1] = '=';

		}

		return dArr;

	}

	public final static byte[] decode(byte[] sArr) {

		int sLen = sArr.length;
		int sepCnt = 0; // Number of separator characters. (Actually illegal
		for (int i = 0; i < sLen; i++)
			if (IA[sArr[i] & 0xff] < 0)
				sepCnt++;
		if ((sLen - sepCnt) % 4 != 0)
			return null;
		int pad = 0;
		for (int i = sLen; i > 1 && IA[sArr[--i] & 0xff] <= 0;)
			if (sArr[i] == '=')
				pad++;
		int len = ((sLen - sepCnt) * 6 >> 3) - pad;
		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length
		for (int s = 0, d = 0; d < len;) {
			int i = 0;
			for (int j = 0; j < 4; j++) { // j only increased if a valid char
				int c = IA[sArr[s++] & 0xff];
				if (c >= 0)
					i |= c << (18 - j * 6);
				else
					j--;
			}
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++] = (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}
		return dArr;
	}

	public final static byte[] decodeFast(byte[] sArr) {

		// Check special case

		int sLen = sArr.length;

		if (sLen == 0)

			return new byte[0];

		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.

		// Trim illegal chars from start

		while (sIx < eIx && IA[sArr[sIx] & 0xff] < 0)

			sIx++;

		// Trim illegal chars from end

		while (eIx > 0 && IA[sArr[eIx] & 0xff] < 0)

			eIx--;

		// get the padding count (=) (0, 1 or 2)

		int pad = sArr[eIx] == '=' ? (sArr[eIx - 1] == '=' ? 2 : 1) : 0; // Count

		// '='

		// at

		// end.

		int cCnt = eIx - sIx + 1; // Content count including possible

		// separators

		int sepCnt = sLen > 76 ? (sArr[76] == '\r' ? cCnt / 78 : 0) << 1 : 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded

		// bytes

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.

		int d = 0;

		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {

			// Assemble three bytes into an int from four "valid" characters.

			int i = IA[sArr[sIx++]] << 18 | IA[sArr[sIx++]] << 12

			| IA[sArr[sIx++]] << 6 | IA[sArr[sIx++]];

			// Add the bytes

			dArr[d++] = (byte) (i >> 16);

			dArr[d++] = (byte) (i >> 8);

			dArr[d++] = (byte) i;

			// If line separator, jump over it.

			if (sepCnt > 0 && ++cc == 19) {

				sIx += 2;

				cc = 0;

			}

		}

		if (d < len) {

			// Decode last 1-3 bytes (incl '=') into 1-3 bytes

			int i = 0;

			for (int j = 0; sIx <= eIx - pad; j++)

				i |= IA[sArr[sIx++]] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)

				dArr[d++] = (byte) (i >> r);

		}

		return dArr;

	}

	// ****************************************************************************************

	// * String version

	// ****************************************************************************************

	/**
	 * 
	 * Encodes a raw byte array into a BASE64 <code>String</code>
	 * 
	 * representation i accordance with RFC 2045.
	 * 
	 * 
	 * 
	 * @param sArr
	 * 
	 *            The bytes to convert. If <code>null</code> or length 0 an
	 * 
	 *            empty array will be returned.
	 * 
	 * @param lineSep
	 * 
	 *            Optional "/r/n" after 76 characters, unless end of file.<br>
	 * 
	 *            No line separator will be in breach of RFC 2045 which
	 * 
	 *            specifies max 76 per line but will be a little faster.
	 * 
	 * @return A BASE64 encoded array. Never <code>null</code>.
	 * 
	 */

	public final static String encodeToString(byte[] sArr, boolean lineSep) {

		// Reuse char[] since we can't create a String incrementally anyway and

		// StringBuffer/Builder would be slower.

		return new String(encodeToChar(sArr, lineSep));

	}

	public final static String encodeToString(byte[] sArr) {

		// Reuse char[] since we can't create a String incrementally anyway and

		// StringBuffer/Builder would be slower.

		return new String(encodeToChar(sArr, devLineSep));

	}

	public final static byte[] decode(String str) {

		int sLen = str != null ? str.length() : 0;
		if (sLen == 0)
			return new byte[0];
		int sepCnt = 0;
		for (int i = 0; i < sLen; i++)
			if (IA[str.charAt(i)] < 0)
				sepCnt++;
		if ((sLen - sepCnt) % 4 != 0)
			return null;
		int pad = 0;
		for (int i = sLen; i > 1 && IA[str.charAt(--i)] <= 0;)
			if (str.charAt(i) == '=')
				pad++;
		int len = ((sLen - sepCnt) * 6 >> 3) - pad;

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		for (int s = 0, d = 0; d < len;) {

			// Assemble three bytes into an int from four "valid" characters.

			int i = 0;

			for (int j = 0; j < 4; j++) { // j only increased if a valid char

				// was found.

				int c = IA[str.charAt(s++)];

				if (c >= 0)

					i |= c << (18 - j * 6);

				else

					j--;

			}

			// Add the bytes

			dArr[d++] = (byte) (i >> 16);

			if (d < len) {

				dArr[d++] = (byte) (i >> 8);

				if (d < len)

					dArr[d++] = (byte) i;

			}

		}

		return dArr;

	}

	/**
	 * 
	 * Decodes a BASE64 encoded string that is known to be resonably well
	 * 
	 * formatted. The method is about twice as fast as {@link #decode(String)}.
	 * 
	 * The preconditions are:<br>
	 * + The array must have a line length of 76
	 * 
	 * chars OR no line separators at all (one line).<br>
	 * + Line separator must
	 * 
	 * be "/r/n", as specified in RFC 2045 + The array must not contain illegal
	 * 
	 * characters within the encoded string<br>
	 * + The array CAN have illegal
	 * 
	 * characters at the beginning and end, those will be dealt with
	 * 
	 * appropriately.<br>
	 * 
	 * 
	 * 
	 * @param s
	 * 
	 *            The source string. Length 0 will return an empty array.
	 * 
	 *            <code>null</code> will throw an exception.
	 * 
	 * @return The decoded array of bytes. May be of length 0.
	 * 
	 */

	public final static byte[] decodeFast(String s) {

		// Check special case

		int sLen = s.length();

		if (sLen == 0)

			return new byte[0];

		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.

		// Trim illegal chars from start

		while (sIx < eIx && IA[s.charAt(sIx) & 0xff] < 0)

			sIx++;

		// Trim illegal chars from end

		while (eIx > 0 && IA[s.charAt(eIx) & 0xff] < 0)

			eIx--;

		// get the padding count (=) (0, 1 or 2)

		int pad = s.charAt(eIx) == '=' ? (s.charAt(eIx - 1) == '=' ? 2 : 1) : 0; // Count

		// '='

		// at

		// end.

		int cCnt = eIx - sIx + 1; // Content count including possible

		// separators

		int sepCnt = sLen > 76 ? (s.charAt(76) == '\r' ? cCnt / 78 : 0) << 1

				: 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded

		// bytes

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.

		int d = 0;

		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {

			// Assemble three bytes into an int from four "valid" characters.

			int i = IA[s.charAt(sIx++)] << 18 | IA[s.charAt(sIx++)] << 12

			| IA[s.charAt(sIx++)] << 6 | IA[s.charAt(sIx++)];

			// Add the bytes

			dArr[d++] = (byte) (i >> 16);

			dArr[d++] = (byte) (i >> 8);

			dArr[d++] = (byte) i;

			// If line separator, jump over it.

			if (sepCnt > 0 && ++cc == 19) {

				sIx += 2;

				cc = 0;

			}

		}

		if (d < len) {

			// Decode last 1-3 bytes (incl '=') into 1-3 bytes

			int i = 0;

			for (int j = 0; sIx <= eIx - pad; j++)

				i |= IA[s.charAt(sIx++)] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)

				dArr[d++] = (byte) (i >> r);

		}

		return dArr;

	}

	public static void main(String[] args) {

		System.out.println(Base64.encodeToString("5CC9D9B48EFCF2FDB766BFB00E08EEDF".getBytes()));

	}

}