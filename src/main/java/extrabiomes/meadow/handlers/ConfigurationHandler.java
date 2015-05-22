package extrabiomes.meadow.handlers;

import net.minecraftforge.common.config.Configuration;
import extrabiomes.meadow.stuff.BiomeCollection;
import extrabiomes.meadow.stuff.BlockCollection;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;

public class ConfigurationHandler {

	// Load all of our config settings
	public static void init(Configuration config) {
		
		for( final BiomeSettings settings : BiomeCollection.allSettings ) {
			settings.load(config);
		}
		
		for( final BlockSettings settings : BlockCollection.allSettings ) {
			settings.load(config);
		}
		
		config.save();
	}

}
