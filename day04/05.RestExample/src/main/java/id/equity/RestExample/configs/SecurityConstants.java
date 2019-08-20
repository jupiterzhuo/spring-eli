package id.equity.RestExample.configs;

public class SecurityConstants {
	//SALT
	public final static String SECRET = "72AE25495A7981C40622D49F9A52E4F1565C90F048F59027BD9C8C8900D5C3D8";
	public final static Long EXPIRED_TIME = 864000000L;// 10 Days
	public final static String TOKEN_PREFIX ="Bearer ";
	public final static String HEADER_STRING ="Authorization";
}
