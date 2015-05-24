package extrabiomes.meadow;

import java.util.Locale;

public abstract class Version {
	public static final String MOD_ID		= "ExtrabiomesMeadow";
	public static final String MOD_NAME		= "Extrabiomes Meadow";
	public static final String VERSION		= "0.0.1";

	public static final String LOC_PREFIX   = "extrabiomes.meadow";
	
	public static final String CHANNEL		= MOD_ID;
	public static final String TEXTURE_PATH = MOD_ID.toLowerCase(Locale.ENGLISH) + ":";
	
	public static final String CLIENT_PROXY	= "extrabiomes.meadow.proxy.ClientProxy";
	public static final String SERVER_PROXY	= "extrabiomes.meadow.proxy.CommonProxy";
}
